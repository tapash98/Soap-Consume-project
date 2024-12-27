package com.alfaris.ipsh.soapService.exception.handler;


import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.ws.soap.client.SoapFaultClientException;

import com.alfaris.ipsh.consumessoapservice.ServiceStatus;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Order(value = Ordered.HIGHEST_PRECEDENCE)
@AllArgsConstructor
@Slf4j
@RestControllerAdvice
class ExceptionControllerAdvice extends ResponseEntityExceptionHandler { 
	

	

	@ExceptionHandler(SoapFaultClientException.class)
	public final ResponseEntity<Object> handleSoapFaultClientException(SoapFaultClientException ex, WebRequest request) {
		ServiceStatus status=new ServiceStatus();
		status.setStatus("Failed");
		status.setMessage(ex.getMessage());
		return new ResponseEntity(status, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	

	

}
