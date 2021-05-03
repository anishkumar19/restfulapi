package com.assignment.nokia.restfulapi.controller;

import static com.assignment.nokia.restfulapi.constant.ApplicationConstant.SUCCESS;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.nokia.restfulapi.dao.UserAccountDao;
import com.assignment.nokia.restfulapi.dto.UserAccountDTO;
import com.assignment.nokia.restfulapi.response.APIResponse;

@RestController
@RequestMapping("/userAccount")
public class Controller {

	@Autowired
	private UserAccountDao dao;

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<APIResponse> getUserAccount(@PathVariable Long id) {
		UserAccountDTO dto = dao.getUserAccount(id);
		return ResponseEntity.ok(APIResponse.builder().status(SUCCESS).data(dto).build());
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<APIResponse> createUserAccount(@RequestBody @Valid UserAccountDTO userAccountDTO) {
		dao.createUserAccount(userAccountDTO);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(APIResponse.builder().status(SUCCESS).message("Record created successfully").build());
	}

	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<APIResponse> updateUserAccount(@RequestBody @Valid UserAccountDTO userAccountDTO) {
		dao.updateUserAccount(userAccountDTO);
		return ResponseEntity
				.ok(APIResponse.builder().status(SUCCESS).message("Record updated successfully").build());
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<APIResponse> deletUserAccount(@PathVariable Long id) {
		dao.deletUserAccount(id);
		return ResponseEntity
				.ok(APIResponse.builder().status(SUCCESS).message("Record deleted successfully").build());
	}

}
