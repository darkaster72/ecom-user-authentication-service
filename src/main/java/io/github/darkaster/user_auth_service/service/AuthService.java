package io.github.darkaster.user_auth_service.service;

import io.github.darkaster.user_auth_service.dto.LoginRequestDto;
import io.github.darkaster.user_auth_service.dto.SignupRequestDto;
import io.github.darkaster.user_auth_service.exception.UsernameAlreadyExistsException;
import io.github.darkaster.user_auth_service.model.User;

public interface AuthService {

    User signup(SignupRequestDto request) throws UsernameAlreadyExistsException;

    String login(LoginRequestDto request);
}
