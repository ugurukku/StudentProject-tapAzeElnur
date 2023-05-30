package com.example.tapaz.pagenation;

import com.example.tapaz.dto.MarkaDto;

import java.util.List;

public record MarkaPageResponse (
        List<MarkaDto>markaDtoList,
        long totalElement,
        int totalPage,
        boolean nextPage
){

}
