package com.assignment.nokia.restfulapi.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class UserAccountDTO {
	
	@NotNull(message = "id is mandatory")
	private Long id;
	
	@NotBlank(message = "name is mandatory")
	@Size(max=150,min=3)
	private String name;
	
	@NotNull(message = "phone is mandatory")
	@Max(value=999999999999L)
	@Min(value=100000000L)
	private Long phone;
	
	@NotBlank(message = "email is mandatory")
	@Size(max=200)
	private String email;
	
	@Size(max=200)
	private String address;
	
	@NotBlank(message = "country is mandatory")
	@Size(max=56)
	private String country;
	
	@NotBlank(message = "department is mandatory")
	@Size(max=500)
	private String department;

}
