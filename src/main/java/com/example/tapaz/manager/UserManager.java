package com.example.tapaz.manager;

import com.example.tapaz.dto.LoginResponse;
import com.example.tapaz.dto.RegisterRequest;
import com.example.tapaz.dto.UserDto;
import com.example.tapaz.entity.Role;
import com.example.tapaz.entity.User;
import com.example.tapaz.exception.NotFoundException;
import com.example.tapaz.mapper.UserMapper;
import com.example.tapaz.pagenation.UserPageResponse;
import com.example.tapaz.repository.UserRepository;
import com.example.tapaz.security.JwtService;
import com.example.tapaz.security.MyUserDetailsService;
import com.example.tapaz.service.UserService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserManager implements UserService {
    public final UserRepository userRepository;
    private final UserMapper userMapper;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final MyUserDetailsService userDetailsService;

    private final static Logger LOGGER = LoggerFactory.getLogger(UserManager.class);

    @Override
    public UserPageResponse getAll(int page, int count) {
        Page<User> userList = userRepository.findAll(PageRequest.of(page, count));
        return new UserPageResponse(userList.getContent().stream().map(userMapper::toUserDto).toList(),
                userList.getTotalElements(),
                userList.getTotalPages(),
                userList.hasNext());
    }

    @Override
    public UserDto getById(int id) {
        return userRepository.findById(id).stream().map(userMapper::toUserDto).findFirst()
                .orElseThrow(() -> new NotFoundException("istifadeci tapilmadi"));
    }

    @Override
    public User saveUser(UserDto userDto) {
        return userRepository.save(userMapper.toUser(userDto));
    }

    @Override
    public void deleteById(int id) {
        userRepository.deleteById(id);

    }

    @Override
    public void register(RegisterRequest registerRequest) {
        User build = User.builder()
                .mail(registerRequest.email())
                .password(passwordEncoder.encode(registerRequest.password()))
                .isActive(true)
                .role(Role.USER)
                .build();
        userRepository.save(build);
    }

    public LoginResponse login(RegisterRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.email(),
                        request.password()
                ));
        LOGGER.info("authenticationManager.authenticate finished");

        UserDetails userDetails = userDetailsService.loadUserByUsername(request.email());
        LOGGER.info("loadUserByUsername finished");


        String token = jwtService.generateToken(userDetails);
        LOGGER.info("Token created = {}", token);


        return new LoginResponse(token);
    }
}
