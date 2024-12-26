package io.github.darkaster.user_auth_service.service;

import io.github.darkaster.user_auth_service.dto.SignupRequestDto;
import io.github.darkaster.user_auth_service.model.User;

public interface AuthService {
    String login(String username, String password);

    User signup(SignupRequestDto request);
}
