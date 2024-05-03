package com.example.api.web.dtos.responses;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Builder
@Getter
public class BaseResponse {
    private Object data;
    private String message;
    private Boolean success;
    private HttpStatus httpStatus;

    public ResponseEntity<BaseResponse> buildResponseEntity() {
        return new ResponseEntity<>(this, this.httpStatus);
    }
}
