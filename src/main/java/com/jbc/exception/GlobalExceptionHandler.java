package com.jbc.exception;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.util.CustomObjectInputStream;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice//is used for exception handled from only controller class .
public class GlobalExceptionHandler {
		
 @ExceptionHandler(ResourceAlreadyExistsException.class)
	public CustomExceptionResponce xyz(ResourceAlreadyExistsException ex, HttpServletRequest request) {
	 String msg =ex.getMessage();
	 String timestamp = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss").format(Calendar.getInstance().getTime());
	 String path = request.getRequestURI();
	 CustomExceptionResponce respose = new CustomExceptionResponce(path,timestamp,msg);
		return respose ;
	
}}
