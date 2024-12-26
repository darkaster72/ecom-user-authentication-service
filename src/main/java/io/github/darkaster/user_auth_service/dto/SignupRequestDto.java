package io.github.darkaster.user_auth_service.dto;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class SignupRequestDto {
    @NotBlank
    private String name;

    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String password;

    @NotBlank
    private String confirmPassword;

    @AssertTrue(message = "Passwords do not match")
    boolean isPasswordMatching() {
        return password.equals(confirmPassword);
    }

    @AssertTrue(message = "Passwords must be greater than 8 characters")
    boolean validPassword() {
        return password.length() >= 8;
    }

}
