package com.example.tapaz.pagenation;

import com.example.tapaz.dto.CarDto;

import java.util.List;

public record CarPageResponse (
        List<CarDto>carDtoList,
        long totalElement,
        int totalPage,
        boolean nextPage
){
}
