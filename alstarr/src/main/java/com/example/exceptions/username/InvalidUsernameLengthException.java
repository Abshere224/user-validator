package com.example.exceptions.username;

public class InvalidUsernameLengthException extends RuntimeException {
  public InvalidUsernameLengthException(String message) {
    super(message);
  }
}
