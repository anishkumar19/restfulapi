package com.assignment.nokia.restfulapi.controller.advice;

import static com.assignment.nokia.restfulapi.constant.ApplicationConstant.FAILURE;
import static com.assignment.nokia.restfulapi.constant.ApplicationConstant.INVALID_REQUEST;

import javax.validation.ValidationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.assignment.nokia.restfulapi.exception.DuplicateAccountException;
import com.assignment.nokia.restfulapi.exception.NoDataFoundException;
import com.assignment.nokia.restfulapi.response.APIResponse;

import lombok.extern.log4j.Log4j2;

@Log4j2
@ControllerAdvice
public class ControllerExceptionAdvice {
	
	@ExceptionHandler(NoDataFoundException.class)
	public ResponseEntity<APIResponse> handleNoResultException(Exception ex) {
		
		log.info(ex.getMessage());
		
		APIResponse apiResponse = APIResponse
				.builder()
				.message(ex.getMessage())
				.status(FAILURE)
				.build();
		
		return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(DuplicateAccountException.class)
	public ResponseEntity<APIResponse> handleDuplicateAccountException(Exception ex) {
		
		log.info(ex.getMessage());
		
		APIResponse apiResponse = APIResponse
				.builder()
				.message(ex.getMessage())
				.status(FAILURE)
				.build();
		
		return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler({HttpMessageNotReadableException.class, HttpMediaTypeNotSupportedException.class})
    public ResponseEntity<APIResponse> handleHttpMessageNotReadableException(Exception ex) {
        log.error(ex.getMessage());

        APIResponse apiResponse = APIResponse
                .builder()
                .message(INVALID_REQUEST)
                .status(FAILURE)
                .build();

        return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler({ValidationException.class, MethodArgumentNotValidException.class})
    public ResponseEntity<APIResponse> handleValidationException(Exception ex) {

        log.error(ex.getMessage());

        APIResponse apiResponse = APIResponse
                .builder()
                .status(FAILURE)
                .build();

        if (ex instanceof MethodArgumentNotValidException)
            for (ObjectError error : ((MethodArgumentNotValidException) ex).getBindingResult().getAllErrors())
                apiResponse.setMessage(error.getDefaultMessage());
        else
            apiResponse.setMessage(ex.getMessage());

        return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<APIResponse> handleException(Exception ex) {

        log.error(ex.getMessage(), ex);

        APIResponse apiResponse = APIResponse
                .builder()
                .message(ex.getMessage())
                .status(FAILURE)
                .build();

        return new ResponseEntity<>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
