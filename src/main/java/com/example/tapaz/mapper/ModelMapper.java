package com.example.tapaz.mapper;

import com.example.tapaz.dto.ModelDto;
import com.example.tapaz.entity.Model;
import org.mapstruct.Mapper;

import java.util.List;
@Mapper(componentModel = "spring")

public interface ModelMapper {
    ModelDto toModelDto(Model model);
    Model toModel(ModelDto modelDto);
    List<ModelDto> toModelDtoList(List<Model> modelList);
}
