package com.example.api.web.controllers;

import com.example.api.services.IUserService;
import com.example.api.web.dtos.requests.CreateUserRequest;
import com.example.api.web.dtos.responses.BaseResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class UserController {
    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<BaseResponse> create(@Valid @RequestBody CreateUserRequest request) {
        BaseResponse baseResponse = userService.create(request);

        return baseResponse.buildResponseEntity();
    }
}
