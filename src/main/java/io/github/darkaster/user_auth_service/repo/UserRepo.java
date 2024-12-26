package io.github.darkaster.user_auth_service.repo;

import io.github.darkaster.user_auth_service.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
}
