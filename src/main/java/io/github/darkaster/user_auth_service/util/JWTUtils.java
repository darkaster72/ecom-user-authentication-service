package io.github.darkaster.user_auth_service.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.crypto.SecretKey;
import java.time.Instant;
import java.util.Date;

@Configuration
public class JWTUtils {
    @Value("${application.jwt.secret}")
    private String jwtSecret;

    @Value("${application.jwt.expiration}")
    private Long jwtExpirationSecs;

    private SecretKey getSingingKey() {
        byte[] keyBytes = Decoders.BASE64.decode(jwtSecret);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String generateJwtToken(String username) {
        var expiry = Date.from(Instant.now().plusSeconds(jwtExpirationSecs));

        return Jwts.builder()
                .subject(username)
                .issuedAt(new Date())
                .expiration(expiry)
                .signWith(getSingingKey())
                .compact();
    }
}
