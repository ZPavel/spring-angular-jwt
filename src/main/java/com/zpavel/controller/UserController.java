package com.zpavel.controller;

import com.zpavel.model.AppUser;
import com.zpavel.request.AuthenticationRequest;
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
    public String login(@RequestBody AuthenticationRequest authenticationRequest) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(authenticationRequest.username, authenticationRequest.password);
        Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        String jwtToken = "";

        if (authentication != null && authentication.isAuthenticated()) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            jwtToken = jwtService.createToken(userDetails.getUsername());
        }

        return jwtToken;
    }

    @PostMapping(value = "/register")
    public void register(@RequestBody AuthenticationRequest authenticationRequest) {
        AppUser user = new AppUser();
        user.setUsername(authenticationRequest.username);
        user.setPassword(bCryptPasswordEncoder.encode(authenticationRequest.password));
        userService.save(user);
    }

}
