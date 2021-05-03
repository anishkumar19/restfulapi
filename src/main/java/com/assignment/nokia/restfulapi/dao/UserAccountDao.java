package com.assignment.nokia.restfulapi.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

import com.assignment.nokia.restfulapi.dto.UserAccountDTO;
import com.assignment.nokia.restfulapi.entity.UserAccount;
import com.assignment.nokia.restfulapi.exception.DuplicateAccountException;
import com.assignment.nokia.restfulapi.exception.NoDataFoundException;
import com.assignment.nokia.restfulapi.repo.UserAccountRepository;

@Component
public class UserAccountDao {

	@Autowired
	private UserAccountRepository repo;

	public UserAccountDTO getUserAccount(Long id) {
		UserAccount entity = repo.findById(id).get();
		UserAccountDTO dto = convertToDTO(entity);
		return dto;
	}

	public void createUserAccount(UserAccountDTO userAccountDTO) {
		if (repo.findById(userAccountDTO.getId()).isPresent()) {
			throw new DuplicateAccountException("UserAccount already exist for id " + userAccountDTO.getId());
		}
		UserAccount userAccount = convertToEntity(userAccountDTO);
		repo.save(userAccount);
	}

	public void updateUserAccount(UserAccountDTO userAccountDTO) {
		repo.findById(userAccountDTO.getId()).orElseThrow(
				() -> new NoDataFoundException("UserAccount doesn't exist for id " + userAccountDTO.getId()));

		UserAccount entity = convertToEntity(userAccountDTO);
		repo.save(entity);

	}

	public void deletUserAccount(Long id) {
		try {
			repo.deleteById(id);
		} catch (EmptyResultDataAccessException ex) {
			throw new NoDataFoundException("UserAccount doesn't exist for id " + id);
		}
	}

	private UserAccount convertToEntity(UserAccountDTO userAccountDTO) {
		UserAccount entity = new UserAccount();
		entity.setId(userAccountDTO.getId());
		entity.setAddress(userAccountDTO.getAddress());
		entity.setCountry(userAccountDTO.getCountry());
		entity.setDepartment(userAccountDTO.getDepartment());
		entity.setEmail(userAccountDTO.getEmail());
		entity.setName(userAccountDTO.getName());
		entity.setPhone(userAccountDTO.getPhone());
		return entity;
	}

	private UserAccountDTO convertToDTO(UserAccount userAccount) {
		UserAccountDTO dto = new UserAccountDTO();
		dto.setId(userAccount.getId());
		dto.setAddress(userAccount.getAddress());
		dto.setCountry(userAccount.getCountry());
		dto.setDepartment(userAccount.getDepartment());
		dto.setEmail(userAccount.getEmail());
		dto.setName(userAccount.getName());
		dto.setPhone(userAccount.getPhone());
		return dto;
	}

}
