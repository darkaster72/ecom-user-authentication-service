package io.github.darkaster.user_auth_service.service;

import io.github.darkaster.user_auth_service.dto.LoginRequestDto;
import io.github.darkaster.user_auth_service.dto.SignupRequestDto;
import io.github.darkaster.user_auth_service.exception.UsernameAlreadyExistsException;
import io.github.darkaster.user_auth_service.model.EntityState;
import io.github.darkaster.user_auth_service.model.User;
import io.github.darkaster.user_auth_service.model.UserSession;
import io.github.darkaster.user_auth_service.repo.SessionRepo;
import io.github.darkaster.user_auth_service.repo.UserRepo;
import io.github.darkaster.user_auth_service.util.JWTUtils;
import jakarta.transaction.Transactional;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;
    private final JWTUtils jwtUtils;
    private final SessionRepo sessionRepo;

    public AuthServiceImpl(UserRepo userRepo, PasswordEncoder passwordEncoder, JWTUtils jwtUtils, SessionRepo sessionRepo) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtils = jwtUtils;
        this.sessionRepo = sessionRepo;
    }

    @Override
    @Transactional
    public User signup(SignupRequestDto request) throws UsernameAlreadyExistsException {
        var existingUser = userRepo.findByUsername(request.getEmail());
        if (existingUser.isPresent()) {
            throw new UsernameAlreadyExistsException("User with email " + request.getEmail() + " already exists");
        }
        var user = new User();
        user.setName(request.getName());
        user.setUsername(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        return userRepo.save(user);
    }

    @Override
    public String login(LoginRequestDto request) {
        var user = userRepo.findByUsername(request.getUsername());
        if (user.isPresent()) {
            if (passwordEncoder.matches(request.getPassword(), user.get().getPassword())) {
                var token = jwtUtils.generateJwtToken(request.getUsername());
                UserSession session = new UserSession(user.get(), token);
                session.setState(EntityState.ACTIVE);
                sessionRepo.save(session);
                return token;
            }
        }
        throw new UsernameNotFoundException("Invalid username or password");
    }
}
