package com.shantisagar.restaurant_mgnt_service.Controllers;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shantisagar.restaurant_mgnt_service.dtos.AuthenticationRequest;
import com.shantisagar.restaurant_mgnt_service.dtos.AuthenticationResponse;
import com.shantisagar.restaurant_mgnt_service.dtos.SignUpRequest;
import com.shantisagar.restaurant_mgnt_service.dtos.UserDto;
import com.shantisagar.restaurant_mgnt_service.entities.User;
import com.shantisagar.restaurant_mgnt_service.repositories.UserRepository;
import com.shantisagar.restaurant_mgnt_service.services.auth.AuthServiceImpl;
import com.shantisagar.restaurant_mgnt_service.services.jwt.UserService;
import com.shantisagar.restaurant_mgnt_service.util.JwtUtil;

import jakarta.persistence.EntityExistsException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthServiceImpl authServiceImpl;

    private final AuthenticationManager authenticationManager;

    private final UserRepository userRepository;

    private final JwtUtil jwtUtil;

    private final UserService userService;

    @PostMapping
    public ResponseEntity<?> signupUser(@RequestBody SignUpRequest signUpRequest) {
        try {
            UserDto createdUSer = authServiceImpl.createUser(signUpRequest);
            log.info("User created succefully");
            return new ResponseEntity<>(createdUSer, HttpStatus.OK);
        } catch (EntityExistsException entityExistsException) {
            log.error("User already exit");
            return new ResponseEntity<>("USer Alerady exit", HttpStatus.NOT_ACCEPTABLE);
        } catch (Exception e) {
            return new ResponseEntity<>("User Not created", HttpStatus.NOT_ACCEPTABLE);
        }

    }

    @PostMapping("/login")
    public AuthenticationResponse createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(),
                    authenticationRequest.getPassword()));
        } catch (BadCredentialsException e) {
            throw new BadCredentialsException("Incorrect Username or password");
        }
        final UserDetails userDetails = userService.userDetailsService().loadUserByUsername(authenticationRequest.getEmail());

        Optional<User> optionalUSer = userRepository.findFirstByEmail(authenticationRequest.getEmail());
        final String jwt = jwtUtil.generateToken(optionalUSer.get());

        AuthenticationResponse authenticationResponse = new AuthenticationResponse();
        if (optionalUSer.isPresent()) {
            authenticationResponse.setJwt(jwt);
            authenticationResponse.setUserRole(optionalUSer.get().getUserRole());
            authenticationResponse.setUserid(optionalUSer.get().getId());
        }
        return authenticationResponse;
    }

}
