package com.example.tasktracker.dto.auth;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginRequest {

    private String password;
    private String username;

}
