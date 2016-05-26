package com.example.exceptions.email;

public class InvalidEmailFormatException extends RuntimeException {
  public InvalidEmailFormatException(String message) {
    super(message);
  }
}
