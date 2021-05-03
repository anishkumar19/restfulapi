package com.assignment.nokia.restfulapi.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "user_accounts")
@Data
public class UserAccount {
		
	@Id
	private Long id;	
	private String name;
	private Long phone;
	private String email;
	private String address;
	private String country;
	private String department;

}
