package com.example.api.services;

import com.example.api.persistance.entities.User;
import com.example.api.web.dtos.requests.CreateUserRequest;
import com.example.api.web.dtos.responses.BaseResponse;

import java.util.Optional;

public interface IUserService {
    BaseResponse create(CreateUserRequest request);
    User getByEmail(String email);
    Optional<User> getOptionalUserByEmail(String email);
}
