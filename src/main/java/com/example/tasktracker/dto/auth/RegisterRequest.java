package com.example.tasktracker.dto.auth;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegisterRequest {

    private String password;
    private String username;
    private String email;
    private String phone;
}
