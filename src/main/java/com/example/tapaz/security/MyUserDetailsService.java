package com.example.tapaz.security;

import com.example.tapaz.exception.UserNotFoundException;
import com.example.tapaz.mapper.UserMapper;
import com.example.tapaz.repository.UserRepository;
import com.example.tapaz.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userMapper
                .toMyUserDetails(userRepository
                        .findUserByMail(username)
                        .orElseThrow(() -> new UserNotFoundException("User not found!")));
    }
}
