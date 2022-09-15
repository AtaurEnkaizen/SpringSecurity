package com.example.SpringSecurity.Security.config;

import com.example.SpringSecurity.registration.token.ConfirmationToken;
import com.example.SpringSecurity.registration.token.ConfirmationTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BearerTokenInterceptor implements HandlerInterceptor {

    @Autowired
    private ConfirmationTokenService confirmationTokenService;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        final String tokenValue = request.getHeader("Authorization");
        if(tokenValue != null && tokenValue.startsWith("Bearer "))
        {
            String token = tokenValue.substring(7, tokenValue.length());
        }
        ConfirmationToken confirmationToken = confirmationTokenService.tokenMatching(tokenValue);
        if(confirmationToken != null) return true;
        else return false;
    }
}
