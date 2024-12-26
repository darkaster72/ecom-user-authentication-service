package io.github.darkaster.user_auth_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "app_role")
public class Role extends BaseModel {
    private String name;
    private String description;
}
