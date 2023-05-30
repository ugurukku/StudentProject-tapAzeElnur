package com.example.tapaz.mapper;

import com.example.tapaz.dto.CarDto;
import com.example.tapaz.entity.Car;
import org.mapstruct.Mapper;

import java.util.List;
@Mapper(componentModel = "spring")
public interface CarMapper {
    CarDto toCarDto(Car car);
    Car toCar(CarDto carDto);
    List<CarDto> toListCar(List<Car> cars);
}
