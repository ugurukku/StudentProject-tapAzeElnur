package com.example.tapaz.repository;

import com.example.tapaz.entity.Car;
import org.apache.catalina.startup.ClassLoaderFactory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car,Integer> {

}
