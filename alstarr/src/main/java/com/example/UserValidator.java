package com.example;

import com.example.exceptions.email.InvalidEmailFormatException;
import com.example.exceptions.email.NullEmailException;
import com.example.exceptions.password.InvalidPasswordException;
import com.example.exceptions.password.InvalidPasswordFormatException;
import com.example.exceptions.password.InvalidPasswordLengthException;
import com.example.exceptions.password.NullPasswordException;
import com.example.exceptions.username.InvalidUsernameFormatException;
import com.example.exceptions.username.InvalidUsernameLengthException;
import com.example.exceptions.username.UsernameIsNullException;
import java.util.regex.Pattern;

public class UserValidator {

  private String emailPattern;
  private String usernamePattern;
  private int usernameMinimumLength;
  private int usernameMaximumLength;
  private int passwordMaximumLength;
  private int passwordMinimumLength;
  private String passwordPattern;

  private UserValidator() {
  }

  //region Email
  public Boolean validateEmail(String email) {
    validateEmailFormat(email);
    validateEmailIsNotNull(email);
    return true;
  }

  private void validateEmailIsNotNull(String email) {
    if (email == null) {
      throw new NullEmailException("Email is null");
    }
  }

  private void validateEmailFormat(String email) {
    if (email != null) {
      Pattern emailPattern = Pattern.compile(this.emailPattern);
      boolean hasEmailFormat = emailPattern.matcher(email).matches();
      if (!hasEmailFormat) {
        throw new InvalidEmailFormatException("Email format is not valid");
      }
    }
  }
  //endregion

  //region Username
  public Boolean validateUsername(String username) {
    validateUsernameHasTheCorrectFormat(username);
    validateUsernameHasMoreThanThreeCharacters(username);
    validateUsernameHasLessThan25Characters(username);
    validateUsernameIsNotNull(username);
    return true;
  }

  private void validateUsernameHasTheCorrectFormat(String username) {
    if (username != null) {
      Pattern usernamePattern = Pattern.compile(this.usernamePattern);
      boolean hasUsernameFormat = usernamePattern.matcher(username).matches();
      if (!hasUsernameFormat) {
        throw new InvalidUsernameFormatException("Username has no correct format");
      }
    }
  }

  private void validateUsernameIsNotNull(String username) {
    if (username == null) {
      throw new UsernameIsNullException("Username has no correct format");
    }
  }

  private void validateUsernameHasMoreThanThreeCharacters(String username) {
    if (username != null && username.length() < this.usernameMinimumLength) {
      throw new InvalidUsernameLengthException("Username is too short");
    }
  }

  private void validateUsernameHasLessThan25Characters(String username) {
    if (username != null && username.length() > this.usernameMaximumLength) {
      throw new InvalidUsernameLengthException("Username is too long");
    }
  }
  //endregion

  //region Password
  public Boolean validatePassword(String username, String password) {
    validatePassWordHasNotInvalidCharacters(password);
    validatePasswordIsDifferentFromUsername(username, password);
    validatePasswordHasLesThanTwentyCharacters(password);
    validatePasswordHasMoreThanSixCharacters(password);
    validatePasswordNotNull(password);
    return true;
  }

  private void validatePassWordHasNotInvalidCharacters(String password) {
    if (password != null) {
      Pattern passwordPattern = Pattern.compile(this.passwordPattern);
      boolean hasPasswordPattern = passwordPattern.matcher(password).matches();
      if (!hasPasswordPattern) {
        throw new InvalidPasswordFormatException("Invalid characters in password");
      }
    }
  }

  private void validatePasswordIsDifferentFromUsername(String username, String password) {
    if (username != null && username.equals(password)) {
      throw new InvalidPasswordException("Password should be different than username");
    }
  }

  private void validatePasswordHasLesThanTwentyCharacters(String password) {
    if (password != null && password.length() > this.passwordMaximumLength) {
      throw new InvalidPasswordLengthException("Password too long");
    }
  }

  private void validatePasswordHasMoreThanSixCharacters(String password) {
    if (password != null && password.length() < this.passwordMinimumLength) {
      throw new InvalidPasswordLengthException("Password too short");
    }
  }

  private void validatePasswordNotNull(String password) {
    if (password == null) {
      throw new NullPasswordException("Password is null");
    }
  }
  //endregion

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder {

    public static final String EMAIL_PATTERN = "[a-zA-Z0-9\\+\\._%\\-\\+]{1,256}" +
        "@" +
        "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
        "(" +
        "\\." +
        "[a-zA-Z0-9][a-zA-Z0-9\\-]{1,25}" +
        ")+";
    private static final String USERNAME_PATTERN = "^([-_A-Za-z0-9])*$";
    private static final int USERNAME_MINIMUM_LENGTH = 3;
    private static final int USERNAME_MAXIMUM_LENGTH = 25;
    private static final int PASSWORD_MINIMUM_LENGTH = 6;
    private static final int PASSWORD_MAXIMUM_LENGTH = 20;
    private static final String PASSWORD_PATTERN = "^([A-Za-z0-9_.,&%€@#~])*$";

    private UserValidator validator = new UserValidator();

    public Builder() {
      setDefaults();
    }

    private void setDefaults() {
      validator.emailPattern = EMAIL_PATTERN;
      validator.usernamePattern = USERNAME_PATTERN;
      validator.usernameMinimumLength = USERNAME_MINIMUM_LENGTH;
      validator.usernameMaximumLength = USERNAME_MAXIMUM_LENGTH;
      validator.passwordMinimumLength = PASSWORD_MINIMUM_LENGTH;
      validator.passwordMaximumLength = PASSWORD_MAXIMUM_LENGTH;
      validator.passwordPattern = PASSWORD_PATTERN;
    }

    public Builder emailPattern(String emailPattern) {
      validator.emailPattern = emailPattern;
      return this;
    }

    public Builder usernamePattern(String usernamePattern) {
      validator.usernamePattern = usernamePattern;
      return this;
    }

    public Builder passwordPattern(String passwordPattern) {
      validator.passwordPattern = passwordPattern;
      return this;
    }

    public Builder usernameMinimumLength(Integer usernameMinimumLength) {
      validator.usernameMinimumLength = usernameMinimumLength;
      return this;
    }

    public Builder usernameMaximumLength(Integer usernameMaximumLength) {
      validator.usernameMaximumLength = usernameMaximumLength;
      return this;
    }

    public Builder passwordMinimumLength(Integer passwordMinimumLength) {
      validator.passwordMinimumLength = passwordMinimumLength;
      return this;
    }

    public Builder passwordMaximumLength(Integer passwordMaximumLength) {
      validator.passwordMaximumLength = passwordMaximumLength;
      return this;
    }

    public UserValidator build() {
      return validator;
    }
  }
}
