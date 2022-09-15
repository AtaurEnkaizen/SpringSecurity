package com.example.SpringSecurity.registration.token;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public String findByAppUserId(Long id)
    {
        String confirmationToken = "";
        List<ConfirmationToken> confirmationTokens = confirmationTokenRepository.findByAppUserId(id);
        for(int i = 0; i < confirmationTokens.size(); i++)
        {
            if(confirmationTokens.get(i).getConfirmedAt() != null)confirmationToken = confirmationTokens.get(i).getToken();
        }
        return confirmationToken;
    }
}
