package com.example.exceptions.username;

public class UsernameIsNullException extends RuntimeException{
  public UsernameIsNullException(String message) {
    super(message);
  }
}
