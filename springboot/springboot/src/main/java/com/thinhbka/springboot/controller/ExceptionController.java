package com.thinhbka.springboot.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
	
	@ExceptionHandler({Exception.class,RuntimeException.class})
	public String nullPointer(Exception ex) {
		ex.printStackTrace();
		return "exception/exception";
	}
}
