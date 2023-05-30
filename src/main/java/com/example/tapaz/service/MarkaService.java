package com.example.tapaz.service;

import com.example.tapaz.dto.MarkaDto;
import com.example.tapaz.entity.Marka;
import com.example.tapaz.pagenation.MarkaPageResponse;

public interface MarkaService {
    MarkaPageResponse getAll(int page,int count);
    MarkaDto getById(int id);
    Marka saveMarka(MarkaDto markaDto);
    void deleteById(int id);
}
