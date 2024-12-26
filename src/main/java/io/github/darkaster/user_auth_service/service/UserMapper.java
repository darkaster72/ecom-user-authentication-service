package io.github.darkaster.user_auth_service.service;

import io.github.darkaster.user_auth_service.dto.UserDto;
import io.github.darkaster.user_auth_service.model.User;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {
    UserDto map(User user);
}
