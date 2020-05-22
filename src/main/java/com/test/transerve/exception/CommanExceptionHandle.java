package com.test.transerve.exception;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class CommanExceptionHandle {
	private static final Logger logger = LogManager.getLogger(CommanExceptionHandle.class);

	@ExceptionHandler(RecordNotFound.class)
	final ResponseEntity<?> recordNotFoundException(RecordNotFound recordExce, WebRequest request) {
		logger.error("Record Not Found Exception ", recordExce);
		ExceptionDetails exceptioDetails = new ExceptionDetails(recordExce.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(exceptioDetails, HttpStatus.NO_CONTENT);
	}

	@ExceptionHandler(NullPointerException.class)
	final ResponseEntity<?> nullPointerException(NullPointerException recordExce, WebRequest request) {
		logger.error("Null Pointer Exception ", recordExce);
		ExceptionDetails exceptioDetails = new ExceptionDetails(recordExce.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(exceptioDetails, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(Exception.class)
	final ResponseEntity<?> CommanException(Exception exce, WebRequest request) {
		logger.error(" Exception ", exce);
		ExceptionDetails exceptioDetails = new ExceptionDetails(exce.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(exceptioDetails, HttpStatus.NOT_FOUND);
	}

}
