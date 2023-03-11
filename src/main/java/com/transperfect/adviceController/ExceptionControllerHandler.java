package com.transperfect.adviceController;

import com.transperfect.exceptions.IncorrectData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionControllerHandler extends ResponseEntityExceptionHandler {

    static final String ERROR = "Exception has been thrown : {} ";
    static final String FORM_VALIDATION_ERROR = "Error when validating the form";
    Logger logger = LoggerFactory.getLogger(ExceptionControllerHandler.class);

    /**
     * handle validation IncorrectData exception
     *
     * @param ex
     * @param request
     * @return ResponseEntity with errors and status
     */
    @ExceptionHandler(value = {IncorrectData.class})
    protected ResponseEntity<Object> handleValidation(IncorrectData ex, WebRequest request) {
        logger.error(FORM_VALIDATION_ERROR, ex.getErrors());
        return handleExceptionInternal(
                ex, ex.getErrors(), new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    /**
     * handle generale exception
     *
     * @param ex
     * @param request
     * @return ResponseEntity with errors and status
     */
    @ExceptionHandler(value = {Exception.class})
    protected ResponseEntity<Object> handleGeneraleException(Exception ex, WebRequest request) {
        logger.error(ERROR, ex);
        return handleExceptionInternal(
                ex, ex.getMessage(), new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }
}
