package com.example.tapaz.pagenation;

import com.example.tapaz.dto.ModelDto;

import java.util.List;

public record ModelPageResponse(
        List<ModelDto>modelDtoList,
        long totalElement,
        int totalPage,
        boolean nextPage
) {
}
