package com.example.tapaz.pagenation;

import com.example.tapaz.dto.UserDto;

import java.util.List;

public record UserPageResponse(
        List<UserDto> userDtoList,
        long totalElement,
        int totalPage,
        boolean nextPage
) {
}
