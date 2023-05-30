package com.example.tapaz.service;

import com.example.tapaz.dto.RegisterRequest;
import com.example.tapaz.dto.UserDto;
import com.example.tapaz.entity.User;
import com.example.tapaz.pagenation.UserPageResponse;

public interface UserService {
    UserPageResponse getAll(int page,int count);
    UserDto getById(int id);
    User saveUser(UserDto userDto);
    void deleteById(int id);
    void register(RegisterRequest registerRequest);
}
