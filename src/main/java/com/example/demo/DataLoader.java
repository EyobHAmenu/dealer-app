package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    CarsRepository carsRepository;
    @Override
    public void run(String... args) throws Exception {
        Category category1 = new Category();
        category1.setType("Sedan");
        categoryRepository.save(category1);

        Set<Car> cars = new HashSet<>();
        Car car1 = new Car();
        car1.setMake("Toyota");
        car1.setModel("Camry");
        car1.setYear(2020);
        car1.setMSRP(24425);
        car1.setCategory(category1);
        carsRepository.save(car1);
        cars.add(car1);

        Car car2 = new Car();
        car2.setMake("Hyundai");
        car2.setModel("Sonata");
        car2.setYear(2020);
        car2.setMSRP(23600);
        car2.setCategory(category1);
        carsRepository.save(car2);
        cars.add(car2);

        Category category2 = new Category();
        category2.setType("SUV");
        categoryRepository.save(category2);

        Car car3 = new Car();
        car3.setMake("Toyota");
        car3.setModel("Rav-4");
        car3.setYear(2020);
        car3.setMSRP(25900);
        car3.setCategory(category2);
        carsRepository.save(car3);
        cars.add(car3);

    }
}
