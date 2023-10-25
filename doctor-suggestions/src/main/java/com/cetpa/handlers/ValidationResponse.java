package com.cetpa.handlers;

import java.util.List;

public class ValidationResponse 
{
	private String message;
	public List<String> errorList;
	public ValidationResponse() {}
	public ValidationResponse(String message, List<String> list) 
	{
		this.message = message;
		this.errorList = list;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<String> getErrorList() {
		return errorList;
	}
	public void setErrorList(List<String> errorList) {
		this.errorList = errorList;
	}
	
	
}
