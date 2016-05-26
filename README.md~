# User Validator
Library to validate username, email and passwords.

Java library to validate typical user fields. Useful for validation when registering new users or logging in.

#Show me the code!!!

First, instance the validator:

```java

UserValidator validator = UserValidator.builder().build();

```

So, how are you using it?

```java

try {
  if (validator.validateUsername(username) && 
    validator.validateEmail(email) && 
    validator.validatePassword(username, password)) {
      // TODO login, register or edit user
}
  } catch (UsernameIsNullException exception) { // Catch all exceptions you're interested to handle
      // TODO show something to the user!!!
}

```

Exceptions:

```java

  @Test (expected = InvalidEmailFormatException.class)
  public void shouldThrowInvalidEmailFormatExceptionWhenEmailHasInvalidFormat() throws Exception {
    validator.validateEmail("test");
  }

  @Test (expected = NullEmailException.class)
  public void shouldThrowInvalidEmailFormatExceptionWhenEmailIsNull() throws Exception {
    validator.validateEmail(null);
  }

  @Test (expected = InvalidPasswordException.class)
  public void shouldThrowInvalidPasswordExceptionWhenInvalidPassword() throws Exception {
    validator.validatePassword("username", "username");
  }

  @Test (expected = InvalidPasswordFormatException.class)
  public void shouldThrowInvalidFormatPasswordExceptionWhenPasswordHasInvalidCharacters() throws Exception {
    validator.validatePassword("username", "pass word");
  }

  @Test (expected = InvalidPasswordLengthException.class)
  public void shouldThrowInvalidLengthPasswordExceptionPasswordIsTooLong() throws Exception {
    validator.validatePassword("username", "passwordWithMoreThanTwentyCharacters");
  }

  @Test (expected = InvalidPasswordLengthException.class)
  public void shouldThrowInvalidLengthPasswordExceptionPasswordIsTooShort() throws Exception {
    validator.validatePassword("username", "hi");
  }

  @Test (expected = NullPasswordException.class)
  public void shouldThrowNullPasswordExceptionPasswordIsNull() throws Exception {
    validator.validatePassword("username", null);
  }

  @Test (expected = UsernameIsNullException.class)
  public void shouldThrowUsernameIsNullExceptionWhenUsernameIsNull() throws Exception {
    validator.validateUsername(null);
  }

  @Test (expected = InvalidUsernameFormatException.class)
  public void shouldThrowUsernameIsNullExceptionWhenUsernameHasInvalidCharacters() throws Exception {
    validator.validateUsername("user name");
  }

  @Test (expected = InvalidUsernameLengthException.class)
  public void shouldThrowInvalidUsernameLengthExceptionWhenUsernameIsTooLong() throws Exception {
    validator.validateUsername("usernameLongerThan25Characters");
  }

  @Test (expected = InvalidUsernameLengthException.class)
  public void shouldThrowInvalidUsernameLengthExceptionWhenUsernameIsTooShort() throws Exception {
    validator.validateUsername("a");
  }

```

#How are your default validations?

```java

private static final String EMAIL_PATTERN = "[a-zA-Z0-9\\+\\._%\\-\\+]{1,256}" +
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

```

#Can I customize my validations?

Sure, you can do something like this:

```java

UserValidator.builder()
        .emailPattern("here be email pattern")
        .passwordMaximumLength(9)
        .passwordMinimumLength(0)
        .passwordPattern("here be password pattern")
        .usernameMaximumLength(9)
        .usernameMinimumLength(0)
        .usernamePattern("here be username pattern")
        .build();

```

#I want to use it!!!

* Grab via Gradle:
```groovy
compile 'com.artjimlop:AllStarr:0.0.1'
```
* Grab via Maven:
```xml
<dependency>
  <groupId>com.artjimlop</groupId>
  <artifactId>AllStarr</artifactId>
  <version>0.0.1</version>
  <type>pom</type>
</dependency>
```

#I want to contribute!!!

You are welcome! Please feel free to do Pull Requests or reporting issues.

#Who did this???

[Arturo Jiménez](https://github.com/artjimlop)
