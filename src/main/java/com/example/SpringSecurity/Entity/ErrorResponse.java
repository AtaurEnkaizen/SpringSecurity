package com.example.SpringSecurity.Entity;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ErrorResponse {
    public String code;
    public String message;
    public boolean success;
}
