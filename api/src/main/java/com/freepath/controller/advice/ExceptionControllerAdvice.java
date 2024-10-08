package com.freepath.controller.advice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.freepath.error.ErrorException;
import com.freepath.error.ErrorMessage;
import com.freepath.error.ErrorType;
import com.freepath.support.response.ApiResponse;
import com.freepath.support.response.ResultType;

@ControllerAdvice
public class ExceptionControllerAdvice extends ResponseEntityExceptionHandler {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @ExceptionHandler(ErrorException.class)
    public ResponseEntity<ApiResponse<Object>> handleErrorException(ErrorException e) {
        switch (e.getErrorType().getLevel()) {
            case ERROR -> log.error("ErrorException: {}", e.getMessage(), e);
            case WARN -> log.warn("ErrorException: {}", e.getMessage(), e);
            default -> log.info("ErrorException: {}", e.getMessage(), e);
        }

        HttpStatus status;
        switch (e.getErrorType().getKind()) {
            case CLIENT_ERROR -> status = HttpStatus.BAD_REQUEST;
            default -> status = HttpStatus.INTERNAL_SERVER_ERROR;
        }

        return ResponseEntity.status(status).body(ApiResponse.error(e.getErrorType(), e.getData()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Object>> handleException(Exception e) {
        log.error("ErrorException: {}", e.getMessage(), e);
        return ResponseEntity
            .status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(ApiResponse.error(ErrorType.DEFAULT, e.getMessage()));
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ApiResponse<Object>> handleIllegalArgumentException(IllegalArgumentException e) {
        log.warn("ErrorException: {}", e.getMessage(), e);
        return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(ApiResponse.error(ErrorType.INVALID_REQUEST, e.getMessage()));
    }

    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<ApiResponse<Object>> handleIllegalStateException(IllegalStateException e) {
        log.warn("ErrorException: {}", e.getMessage(), e);
        return ResponseEntity
            .status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(ApiResponse.error(ErrorType.DEFAULT, e.getMessage()));
    }

    protected ResponseEntity<Object> handleHttpMessageNotReadable(
        HttpMessageNotReadableException e,
        HttpHeaders headers,
        HttpStatus status,
        WebRequest request
    ) {
        log.warn("ErrorException: {}", e.getMessage(), e);
        return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(error(ErrorType.INVALID_REQUEST));
    }

    private ApiResponse<?> error(ErrorType error) {
        return new ApiResponse<>(ResultType.ERROR, error, new ErrorMessage(error, null));
    }

    private ApiResponse<?> error(ErrorType error, Object errorData) {
        return new ApiResponse<>(ResultType.ERROR, error, new ErrorMessage(error, errorData));
    }
}

