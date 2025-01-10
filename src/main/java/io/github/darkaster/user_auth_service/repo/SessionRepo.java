package io.github.darkaster.user_auth_service.repo;

import io.github.darkaster.user_auth_service.model.UserSession;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepo extends JpaRepository<UserSession, Long> {
}
