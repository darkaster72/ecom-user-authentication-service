package io.github.darkaster.user_auth_service.exception;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class UsernameAlreadyExistsException extends Throwable {
    public UsernameAlreadyExistsException(@Email @NotBlank @Email @NotBlank String s) {
        super(s);
    }
}
