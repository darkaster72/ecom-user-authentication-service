package io.github.darkaster.user_auth_service.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@Entity
@Table(name = "app_user")
@EqualsAndHashCode(callSuper = true)
public class User extends BaseModel {
    private String name;

    @Column(unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @ManyToMany
    private List<Role> role;
}
