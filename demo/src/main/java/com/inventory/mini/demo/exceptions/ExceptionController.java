package com.inventory.mini.demo.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {

	@Autowired
	private static final Logger logger = LogManager.getLogger(ExceptionController.class);

	@ExceptionHandler(value = Exception.class)
	public String handleException(HttpServletRequest request, Exception e) {
		logger.error("Request " + request.getRequestURL(), e);
		return e.getMessage();

	}
}
