package io.github.darkaster.user_auth_service.service;

import io.github.darkaster.user_auth_service.dto.SignupRequestDto;
import io.github.darkaster.user_auth_service.model.User;
import io.github.darkaster.user_auth_service.repo.UserRepo;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    private UserRepo userRepo;

    @Override
    public String login(String username, String password) {
        if ()
        return "";
    }

    @Override
    public User signup(SignupRequestDto request) {
        return null;
    }
}
