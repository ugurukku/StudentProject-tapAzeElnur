package com.example.tapaz.manager;

import com.example.tapaz.dto.UserDto;
import com.example.tapaz.entity.User;
import com.example.tapaz.exception.NotFoundExceptionn;
import com.example.tapaz.mapper.UserMapper;
import com.example.tapaz.pagenation.UserPageResponse;
import com.example.tapaz.repository.UserRepository;
import com.example.tapaz.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor
@Service
public class UserManager implements UserService {
    public  final UserRepository userRepository;
    private final UserMapper userMapper;
    @Override
    public UserPageResponse getAll(int page,int count) {
        Page<User> userList=userRepository.findAll(PageRequest.of(page, count));
        return new UserPageResponse(userList.getContent().stream().map(userMapper::toUserDto).toList(),
                userList.getTotalElements(),
                userList.getTotalPages(),
                userList.hasNext());
    }

    @Override
    public UserDto getById(int id) {
        return userRepository.findById(id).stream().map(userMapper::toUserDto).findFirst()
                .orElseThrow(()->new NotFoundExceptionn("istifadeci tapilmadi"));
    }
    @Override
    public User saveUser(UserDto userDto) {
        return userRepository.save(userMapper.toUser(userDto));
    }
    @Override
    public void deleteById(int id) {
         userRepository.deleteById(id);

    }
}
