package com.turkcell.pair1.service.abstraction;

import com.turkcell.pair1.service.dto.RegisterRequest;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    void add(RegisterRequest request);
}
