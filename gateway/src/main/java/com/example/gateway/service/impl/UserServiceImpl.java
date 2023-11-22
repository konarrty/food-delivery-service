package com.example.gateway.service.impl;

import com.example.gateway.model.User;
import com.example.gateway.repository.UserRepository;
import com.example.gateway.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Нет такого пользователя!"));

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                Collections.singleton(user.getRole()));
    }
}
