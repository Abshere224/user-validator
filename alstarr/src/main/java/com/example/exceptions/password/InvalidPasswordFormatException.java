package com.example.exceptions.password;

public class InvalidPasswordFormatException extends RuntimeException{
  public InvalidPasswordFormatException(String message) {
    super(message);
  }
}
