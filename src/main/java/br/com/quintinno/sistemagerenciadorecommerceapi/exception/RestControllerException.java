package br.com.quintinno.sistemagerenciadorecommerceapi.exception;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.quintinno.sistemagerenciadorecommerceapi.dto.ExceptionResponseDTO;
import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class RestControllerException {

	@ExceptionHandler(value = NoSuchElementException.class)
	public ResponseEntity<ExceptionResponseDTO> noSuchElementException(NoSuchElementException noSuchElementException, HttpServletRequest httpServletRequest) {
		ExceptionResponseDTO exceptionResponseDTO = new ExceptionResponseDTO(HttpStatus.NOT_FOUND.name(),
				noSuchElementException.getMessage(), new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date()));
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionResponseDTO);
	}

}
