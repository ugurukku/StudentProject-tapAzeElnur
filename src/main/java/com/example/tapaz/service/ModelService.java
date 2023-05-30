package com.example.tapaz.service;

import com.example.tapaz.dto.ModelDto;
import com.example.tapaz.entity.Model;
import com.example.tapaz.pagenation.ModelPageResponse;

public interface ModelService {
    ModelPageResponse getAll(int page,int count);
    ModelDto getById(int id);
    Model saveModel(ModelDto modelDto);
    void deleteById(int id);
}
