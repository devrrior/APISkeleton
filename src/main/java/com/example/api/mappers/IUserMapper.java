package com.example.api.mappers;

import com.example.api.persistance.entities.User;
import com.example.api.web.dtos.responses.CreateUserResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IUserMapper {
    CreateUserResponse toCreateUserResponse(User user);
}
