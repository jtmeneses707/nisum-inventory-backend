package com.ascend.components.controller;

import com.ascend.components.exception.ItemNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice

@ResponseBody
public class GlobalExceptionHandler {
  @ResponseStatus(HttpStatus.NOT_FOUND)
  @ExceptionHandler(ItemNotFoundException.class)
  public void handleStatusNotFound(Exception e) {
    handleException(e);
  }



  // General exception handler.
  public void handleException(Exception e) {
    System.out.println(e.getMessage());
  }


}
