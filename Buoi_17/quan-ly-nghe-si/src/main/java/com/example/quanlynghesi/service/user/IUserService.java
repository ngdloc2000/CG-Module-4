package com.example.quanlynghesi.service.user;

import com.example.quanlynghesi.model.User;
import com.example.quanlynghesi.service.IGeneralService;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

public interface IUserService extends IGeneralService<User>, UserDetailsService {
    Optional<User> findByUsername(String username);
}
