package com.example.exceptions.username;

public class InvalidUsernameFormatException extends RuntimeException {
  public InvalidUsernameFormatException(String message) {
    super(message);
  }
}
