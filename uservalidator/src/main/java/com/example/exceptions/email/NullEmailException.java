package com.example.exceptions.email;

public class NullEmailException extends RuntimeException {
  public NullEmailException(String message) {
    super(message);
  }
}
