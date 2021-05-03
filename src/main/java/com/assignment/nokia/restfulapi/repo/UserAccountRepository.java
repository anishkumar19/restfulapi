package com.assignment.nokia.restfulapi.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assignment.nokia.restfulapi.entity.UserAccount;

@Repository
public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {

}
