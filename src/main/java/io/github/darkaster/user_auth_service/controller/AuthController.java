package io.github.darkaster.user_auth_service.controller;

import io.github.darkaster.user_auth_service.dto.LoginRequestDto;
import io.github.darkaster.user_auth_service.dto.SignupRequestDto;
import io.github.darkaster.user_auth_service.dto.UserDto;
import io.github.darkaster.user_auth_service.exception.UsernameAlreadyExistsException;
import io.github.darkaster.user_auth_service.service.AuthService;
import io.github.darkaster.user_auth_service.service.UserMapper;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
    private final AuthService authService;
    private final UserMapper userMapper;

    public AuthController(AuthService authService, UserMapper userMapper) {
        this.authService = authService;
        this.userMapper = userMapper;
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody LoginRequestDto request) {
        return ResponseEntity.ok(Map.of("token", authService.login(request)));
    }

    @PostMapping("/signup")
    public ResponseEntity<UserDto> signup(@Valid @RequestBody SignupRequestDto request) throws UsernameAlreadyExistsException {
        var user = authService.signup(request);
        return ResponseEntity.ok(userMapper.map(user));
    }
}
