package com.example.exceptions.password;

public class NullPasswordException extends RuntimeException {
  public NullPasswordException(String message) {
    super(message);
  }
}
