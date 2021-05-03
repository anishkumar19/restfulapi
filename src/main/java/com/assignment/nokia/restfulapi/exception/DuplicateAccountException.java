package com.assignment.nokia.restfulapi.exception;

public class DuplicateAccountException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public DuplicateAccountException(String errorMessage) {
		super(errorMessage);

	}
}