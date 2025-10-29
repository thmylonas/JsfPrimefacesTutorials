package com.thomasmylonas.spring_mvc_jsf_pf_web_app.service_layer.services;

import com.thomasmylonas.spring_mvc_jsf_pf_web_app.service_layer.models.primefaces_models.Car;
import com.thomasmylonas.spring_mvc_jsf_pf_web_app.service_layer.services._base.AbstractService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@ManagedBean(name = "carService")
@ViewScoped
public class CarService extends AbstractService {

    private static final List<String> COLORS = List.of("Black", "White", "Green", "Red", "Blue", "Orange",
            "Silver", "Yellow", "Brown", "Maroon");
    private static final List<String> BRANDS = List.of("BMW", "Mercedes", "Volvo", "Audi", "Renault",
            "Fiat", "Volkswagen", "Honda", "Jaguar", "Ford");

    public List<Car> createCars(int size) {

        List<Car> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(
                    Car.builder()
                            .id(generateRandomId())
                            .brand(generateRandomBrand())
                            .year(generateRandomYear())
                            .color(generateRandomColor())
                            .price(generateRandomPrice())
                            .soldState(generateRandomSoldState())
                            .build()
            );
        }
        return list;
    }

    private String generateRandomId() {
        return UUID.randomUUID().toString().substring(0, 8);
    }

    private String generateRandomBrand() {
        return BRANDS.get((int) (Math.random() * 10));
    }

    private int generateRandomYear() {
        return (int) (Math.random() * 50 + 1960);
    }

    private String generateRandomColor() {
        return COLORS.get((int) (Math.random() * 10));
    }

    private int generateRandomPrice() {
        return (int) (Math.random() * 100000);
    }

    private boolean generateRandomSoldState() {
        return Math.random() > 0.5;
    }
}
