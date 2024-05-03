package com.example.api.services;

import com.example.api.web.dtos.responses.GetRoleResponse;

import java.util.List;

public interface IUserRoleService {
    List<GetRoleResponse> getRolesByUserId(Long userId);
}
