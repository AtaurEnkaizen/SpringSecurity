package com.example.SpringSecurity.registration;

import com.example.SpringSecurity.appuser.AppUser;
import com.example.SpringSecurity.appuser.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins= {"*"})
@RestController
@RequestMapping("/registration")
@AllArgsConstructor
public class RegistrationController {
    @Autowired
    private RegistrationService registrationService;

    @Autowired
    private UserRepository userRepository;
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
    public Object LogIn(@RequestParam("email") String email, @RequestParam("password") String password)
    {
        return registrationService.LogInEnable(email, password);
    }
    @GetMapping("/logout")
    public Object LogOut()
    {
        return registrationService.LogOut();
    }
    @GetMapping("/all")
    public List<AppUser> findAllUser()
    {
        return userRepository.findAll();
    }
}
