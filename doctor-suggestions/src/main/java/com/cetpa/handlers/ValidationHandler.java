package com.cetpa.handlers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.cetpa.exceptions.DoctorNotFoundException;
import com.cetpa.exceptions.PatientNotFoundException;

@RestControllerAdvice
public class ValidationHandler extends  ResponseEntityExceptionHandler
{
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exp,HttpHeaders headers, HttpStatus status, WebRequest request) 
	{
		BindingResult br=exp.getBindingResult();
		List<ObjectError> errorList=br.getAllErrors();
		List<String> list=new ArrayList<>();
		for(ObjectError error:errorList)
		{
			list.add(error.getDefaultMessage());
		}
		ValidationResponse response=new ValidationResponse("Validation failed...",list);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	}
	@ExceptionHandler(DoctorNotFoundException.class)
	public ResponseEntity<Object> handleDoctorNotFound(DoctorNotFoundException ex)
	{
		List<String> exList=new ArrayList<>();
		exList.add(ex.getMessage());
		ValidationResponse response=new ValidationResponse("Exception occurred...",exList);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	}
	@ExceptionHandler(PatientNotFoundException.class)
	public ResponseEntity<Object> handlePatientNotFound(PatientNotFoundException ex)
	{
		List<String> exList=new ArrayList<>();
		exList.add(ex.getMessage());
		ValidationResponse response=new ValidationResponse("Exception occurred...",exList);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	}
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<Object> handleOtherExceptions(RuntimeException ex)
	{
		List<String> exList=new ArrayList<>();
		exList.add(ex.getMessage());
		ValidationResponse response=new ValidationResponse("Exception occurred...",exList);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	}
}
