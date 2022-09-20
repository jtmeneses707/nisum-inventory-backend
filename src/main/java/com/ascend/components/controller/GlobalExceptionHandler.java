package com.ascend.components.controller;

import com.ascend.components.exception.ItemNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.SQLSyntaxErrorException;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice

public class GlobalExceptionHandler {
  /**
   * Handles any exception that should return a 404 response code
   * @param e Exception being handled
   */

  @ExceptionHandler(ItemNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  @ResponseBody
  public void handleStatusNotFound(Exception e) {
    logException(e);
  }

  /**
   * Handles any exception that should return a 500 response code
   * @param e Exception being handled
   * @return JSON object with hint to check the request body.
   */
  @ExceptionHandler({SQLIntegrityConstraintViolationException.class, IllegalArgumentException.class, SQLSyntaxErrorException.class})
//  @ExceptionHandler(SQLSyntaxErrorException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ResponseBody
  public Map<String, String> handleBadRequest(Exception e) {
    logException(e);
    var res = new HashMap<String, String>();
    res.put("hint", "check request body is valid");
    return res;
  }

  // Helper to print errors to console.
  public void logException(Exception e) {
    System.out.println(e.getMessage());
  }


}
