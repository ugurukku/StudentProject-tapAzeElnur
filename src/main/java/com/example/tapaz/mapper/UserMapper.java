package com.example.tapaz.mapper;

import com.example.tapaz.dto.UserDto;
import com.example.tapaz.entity.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")

public interface UserMapper {
    UserDto toUserDto(User user);
    User toUser(UserDto userDto);
    List<UserDto> userListToUserDtoList(List<User> users);}
