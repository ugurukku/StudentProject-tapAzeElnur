package com.example.tapaz.mapper;

import com.example.tapaz.dto.UserDto;
import com.example.tapaz.entity.User;
import com.example.tapaz.security.MyUserDetails;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")

public interface UserMapper {
    UserDto toUserDto(User user);
    User toUser(UserDto userDto);

    MyUserDetails toMyUserDetails(User user);

    List<UserDto> userListToUserDtoList(List<User> users);}
