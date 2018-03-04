package com.zpavel.service.impl;


import com.zpavel.model.AppUser;
import com.zpavel.repository.UserRepository;
import com.zpavel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public AppUser findByUsername(String u) throws UsernameNotFoundException {
        return userRepository.findByUsername(u);
    }

    @Override
    public AppUser save(AppUser u) {
        return userRepository.save(u);
    }
}
