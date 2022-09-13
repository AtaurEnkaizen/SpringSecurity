package com.example.SpringSecurity.registration;

import com.example.SpringSecurity.Entity.Employee;
import com.example.SpringSecurity.Entity.ErrorResponse;
import com.example.SpringSecurity.Entity.SuccessResponse;
import com.example.SpringSecurity.appuser.AppUser;
import com.example.SpringSecurity.appuser.AppUserRole;
import com.example.SpringSecurity.appuser.AppUserService;
import com.example.SpringSecurity.appuser.UserRepository;
import com.example.SpringSecurity.registration.token.ConfirmationToken;
import com.example.SpringSecurity.registration.token.ConfirmationTokenService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RegistrationService {
    private final AppUserService appUserService;
    private final EmailValidator emailValidator;
    private  final ConfirmationTokenService confirmationTokenService;
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public Object LogOut()
    {
        return new SuccessResponse(
            "200", "Logout successful", true, null
        );
    }
    public Object LogInEnable(String email, String password)
    {
        Optional<AppUser> appUser = userRepository.findByEmail(email);
        String passwordFromDatabase = appUser.get().getPassword().toString();
        if(appUser.isPresent() && bCryptPasswordEncoder.matches(password,passwordFromDatabase))
        {
            return new SuccessResponse(
                 "200", "Login successful", true, appUser
            );
        }
        return new ErrorResponse(
                "400", "Login Unsuccessful", false
        );
    }
    public String Registration(RegistrationModel registrationModel)
    {

        boolean isValid = emailValidator.test(registrationModel.getEmail());
        if(!isValid) throw new IllegalStateException("Not a Valid Email");
        return appUserService.SignUp(
                new AppUser(
                registrationModel.getFirstname(),
                registrationModel.getLastname(),
                registrationModel.getEmail(),
                registrationModel.getPassword(),
                AppUserRole.Management, new Employee()
                )
        );
    }
    @Transactional
    public String tokenConfirmation(String token)
    {
        ConfirmationToken confirmationToken = confirmationTokenService.tokenMatching(token);
        if(confirmationToken == null)
        {
            throw new IllegalStateException("User Not Found");
        }

        if(confirmationToken.getConfirmedAt() != null) throw new IllegalStateException("email already Confirmed");
        if(confirmationToken.getExpiresAt().isBefore(LocalDateTime.now())) throw new IllegalStateException("email expired");
        confirmationToken.setConfirmedAt(LocalDateTime.now());
        return appUserService.enableAppUser(confirmationToken.getAppUser());
    }
}
