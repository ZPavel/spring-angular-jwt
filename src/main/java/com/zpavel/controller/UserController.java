package com.zpavel.controller;

import com.zpavel.model.AppUser;
import com.zpavel.request.AuthenticationRequest;
import com.zpavel.response.AuthenticationResponse;
import com.zpavel.service.JwtService;
import com.zpavel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping(value = "/login")
    public AuthenticationResponse login(@RequestBody AuthenticationRequest authenticationRequest) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword());
        Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        AuthenticationResponse authenticationResponse = null;

        if (authentication != null && authentication.isAuthenticated()) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            authenticationResponse = new AuthenticationResponse();
            authenticationResponse.setUsername(userDetails.getUsername());
            authenticationResponse.setToken(jwtService.createToken(userDetails.getUsername()));
        }

        return authenticationResponse;
    }

    @PostMapping(value = "/register")
    public void register(@RequestBody AuthenticationRequest authenticationRequest) {
        AppUser user = new AppUser();
        user.setUsername(authenticationRequest.getUsername());
        user.setPassword(bCryptPasswordEncoder.encode(authenticationRequest.getPassword()));
        userService.save(user);
    }

}
