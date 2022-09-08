package com.example.SpringSecurity.registration.token;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ConfirmationTokenService {
    @Autowired
    private final ConfirmationTokenRepository confirmationTokenRepository;

    public void addToken(ConfirmationToken token)
    {
        confirmationTokenRepository.save(token);
    }
    public ConfirmationToken tokenMatching(String token)
    {
        return confirmationTokenRepository.findByToken(token);
    }
}
