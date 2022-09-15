package com.example.SpringSecurity.Entity;

import com.example.SpringSecurity.registration.token.ConfirmationToken;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SuccessResponse {
    public String code;
    public String message;
    public boolean success;
    public Object data;
    public String token;
}
