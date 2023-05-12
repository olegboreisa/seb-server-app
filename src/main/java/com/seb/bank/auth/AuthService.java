package com.seb.bank.auth;

import com.seb.bank.auth.entity.Role;
import com.seb.bank.auth.entity.User;
import com.seb.bank.auth.model.LoginForm;
import com.seb.bank.auth.model.RegistrationForm;
import com.seb.bank.auth.repository.RoleRepository;
import com.seb.bank.auth.repository.UserRepository;
import com.seb.bank.auth.token.JwtTokenService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private static final long USER_ROLE = 2L;

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;
    private final UserDetailsServiceImpl userDetailsServiceImpl;
    private final JwtTokenService jwtTokenService;

    public AuthService(
            UserRepository userRepository,
            RoleRepository roleRepository,
            PasswordEncoder passwordEncoder,
            AuthenticationManager authenticationManager,
            UserDetailsServiceImpl userDetailsServiceImpl,
            JwtTokenService jwtTokenService) {

        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.userDetailsServiceImpl = userDetailsServiceImpl;
        this.jwtTokenService = jwtTokenService;
    }

    public void register(RegistrationForm form) {
        String encodedPassword = passwordEncoder.encode(form.getPassword());
        Role role = roleRepository.getOne(USER_ROLE);

        User user = new User();
        user.setUsername(form.getUsername());
        user.setPassword(encodedPassword);
        user.setRole(role);

        userRepository.save(user);
    }

    public String authenticate(LoginForm form) throws Exception {
        try {
            UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                    form.getUsername(),
                    form.getPassword());
            authenticationManager.authenticate(authToken);
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }

        UserDetails userDetails = userDetailsServiceImpl.loadUserByUsername(form.getUsername());
        return jwtTokenService.generateToken(userDetails);
    }
}
