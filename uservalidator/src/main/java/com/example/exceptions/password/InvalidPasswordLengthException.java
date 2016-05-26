package com.example.exceptions.password;

public class InvalidPasswordLengthException extends RuntimeException {
  public InvalidPasswordLengthException(String message) {
    super(message);
  }
}
