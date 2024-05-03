package com.example.api.services;

import com.example.api.web.dtos.requests.AuthenticateRequest;
import com.example.api.web.dtos.requests.RefreshTokenRequest;
import com.example.api.web.dtos.responses.BaseResponse;

public interface IAuthService {
    BaseResponse authenticate(AuthenticateRequest request);
    BaseResponse refreshToken(RefreshTokenRequest request);
}
