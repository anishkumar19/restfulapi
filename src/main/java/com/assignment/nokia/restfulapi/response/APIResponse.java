package com.assignment.nokia.restfulapi.response;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Builder;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
@Data
public class APIResponse {
	
	private String status;
	private String message;
	private Object data;
	
}