package com.nab.nlinkweb.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class GlobalControllerExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InputValidationException.class)
    public ResponseEntity<ApiError> handleInvalidInput() {
        return new ResponseEntity<>(new ApiError(ErrorCode.INVALID_REQUEST.getId(),
                ErrorCode.INVALID_REQUEST.getMsg()), HttpStatus.BAD_REQUEST);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> handleOtherException() {
        return new ResponseEntity<>(new ApiError(ErrorCode.UNKNOWN_EXCEPTION.getId(),
                ErrorCode.UNKNOWN_EXCEPTION.getMsg()), HttpStatus.BAD_REQUEST);
    }
}
