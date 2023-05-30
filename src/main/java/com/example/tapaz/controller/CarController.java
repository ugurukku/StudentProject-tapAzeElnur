package com.example.tapaz.controller;

import com.example.tapaz.dto.CarDto;
import com.example.tapaz.entity.Car;
import com.example.tapaz.manager.CarManager;
import com.example.tapaz.pagenation.CarPageResponse;
import jakarta.validation.Valid;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/cars")
public class CarController {
    private final CarManager carManager;

    public CarController(CarManager carManager) {
        this.carManager = carManager;
    }


    @GetMapping
    public CarPageResponse getAll(int page,int count){
       return carManager.getAll(page, count);
    }
    @GetMapping("?{id}")
    public CarDto getById(@PathVariable int id){
        return carManager.getById(id);
    }
    @PostMapping("/post")
    public void saveCar(@RequestBody @Valid Car car){
        carManager.saveCar(new CarDto(car.getColor(), car.getQiymet(), car.getId()));
    }
    @DeleteMapping("/delete/{id}")
    public void deleteCar(@PathVariable int id){
        carManager.deleteById(id);
    }
}
