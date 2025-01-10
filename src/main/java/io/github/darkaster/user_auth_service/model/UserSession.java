package io.github.darkaster.user_auth_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
public class UserSession extends BaseModel {
    @OneToOne
    private User user;
    private String token;
    private Date expiryAt;

    public UserSession(User user, String token) {
        this.user = user;
        this.token = token;
    }

    public Boolean isExpired() {
        return new Date().after(expiryAt);
    }
}
