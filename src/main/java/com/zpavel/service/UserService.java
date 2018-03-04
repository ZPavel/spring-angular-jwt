package com.zpavel.service;

import com.zpavel.model.AppUser;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserService {
    AppUser findByUsername(String u) throws UsernameNotFoundException;

    AppUser save(AppUser u);
}
