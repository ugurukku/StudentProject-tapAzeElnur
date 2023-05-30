package com.example.tapaz.service;

import com.example.tapaz.dto.CarDto;
import com.example.tapaz.entity.Car;
import com.example.tapaz.entity.User;
import com.example.tapaz.pagenation.CarPageResponse;

import java.util.List;

public interface CarService {
   CarPageResponse getAll(int page, int count);
    CarDto getById(int id);
    Car saveCar(CarDto carDto);
    void deleteById(int id);
}
