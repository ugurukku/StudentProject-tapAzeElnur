package com.example.tapaz.mapper;

import com.example.tapaz.dto.MarkaDto;
import com.example.tapaz.entity.Marka;
import jakarta.validation.groups.ConvertGroup;
import org.mapstruct.Mapper;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@Mapper(componentModel = "spring")

public interface MarkaMapper {
    Marka toMarka(MarkaDto markaDto);
    MarkaDto toMarkaDto(Marka marka);
    List<MarkaDto> toMarkaDtoList(List<Marka> markaList);

}
