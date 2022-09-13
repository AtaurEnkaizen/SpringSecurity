package com.example.SpringSecurity.Entity;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SuccessResponse {
    public String code;
    public String message;
    public boolean success;
    public Object data;
}
