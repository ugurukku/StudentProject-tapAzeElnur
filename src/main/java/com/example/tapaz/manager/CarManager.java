package com.example.tapaz.manager;

import com.example.tapaz.dto.CarDto;
import com.example.tapaz.entity.Car;
import com.example.tapaz.exception.NotFoundExceptionn;
import com.example.tapaz.mapper.CarMapper;
import com.example.tapaz.pagenation.CarPageResponse;
import com.example.tapaz.repository.CarRepository;
import com.example.tapaz.service.CarService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor
@Service
public class CarManager implements CarService {
    private final CarRepository carRepository;
    private final CarMapper carMapper;

    @Override
    public CarPageResponse getAll(int page, int count) {
        Page<Car>carList=carRepository.findAll(PageRequest.of(page, count));
        return new CarPageResponse(carList.getContent().stream().map(carMapper::toCarDto).toList(),
                carList.getTotalElements(),
                carList.getTotalPages(),
                carList.hasNext());
    }

    @Override
    public CarDto getById(int id) {
        return carRepository.findById(id).stream().map(carMapper::toCarDto).findFirst()
                .orElseThrow(()->new NotFoundExceptionn("bu melumata uygun netice tapilmadi"));
    }

    @Override
    public Car saveCar(CarDto carDto) {
        return carRepository.save(carMapper.toCar(carDto));
    }

    @Override
    public void deleteById(int id) {
      carRepository.deleteById(id);
    }
}
