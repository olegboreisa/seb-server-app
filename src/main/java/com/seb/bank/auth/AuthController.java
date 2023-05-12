package com.seb.bank.auth;

import com.seb.bank.auth.model.LoginForm;
import com.seb.bank.auth.model.RegistrationForm;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public void register(@RequestBody RegistrationForm form) {
        authService.register(form);
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginForm form) throws Exception {
        return authService.authenticate(form);
    }
}
