package com.example.SpringSecurity.registration;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins= {"*"})
@RestController
@RequestMapping("/registration")
@AllArgsConstructor
public class RegistrationController {
    @Autowired
    private RegistrationService registrationService;
    @PostMapping
    public String register(@RequestBody RegistrationModel registrationModel)
    {
       return registrationService.Registration(registrationModel);
    }
    @GetMapping("/confirm")
    public String SignIn(@RequestParam("token") String token)
    {
        return registrationService.tokenConfirmation(token);
    }
    @PostMapping("/login")
    public boolean LogIn(@RequestParam("email") String email, @RequestParam("password") String password)
    {
        return registrationService.LogInEnable(email, password);
    }
}
