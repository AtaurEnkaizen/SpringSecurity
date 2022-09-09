package com.example.SpringSecurity.Entity;

import org.springframework.http.HttpEntity;
import org.springframework.util.MultiValueMap;

public class ResponseEntity<T> extends HttpEntity<T> {
    public ResponseEntity(T body, MultiValueMap<String, String> headers) {

    }
}
