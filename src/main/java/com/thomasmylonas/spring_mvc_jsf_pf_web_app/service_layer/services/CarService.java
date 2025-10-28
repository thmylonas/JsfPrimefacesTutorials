package com.thomasmylonas.spring_mvc_jsf_pf_web_app.service_layer.services;

import com.thomasmylonas.spring_mvc_jsf_pf_web_app.service_layer.models.primefaces_models.Car;
import com.thomasmylonas.spring_mvc_jsf_pf_web_app.service_layer.services._base.AbstractService;

import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@ManagedBean(name = "carService")
public class CarService extends AbstractService implements Serializable {

    private final String[] colors = new String[]{"Black", "White", "Green", "Red", "Blue", "Orange",
            "Silver", "Yellow", "Brown", "Maroon"};
    private final String[] brands = new String[]{"BMW", "Mercedes", "Volvo", "Audi", "Renault",
            "Fiat", "Volkswagen", "Honda", "Jaguar", "Ford"};

    public List<Car> createCars(int size) {
        List<Car> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(new Car(getRandomId(), getRandomBrand(), getRandomYear(),
                    getRandomColor(), getRandomPrice(), getRandomSoldState()));
        }
        return list;
    }

    private String getRandomId() {
        return UUID.randomUUID().toString().substring(0, 8);
    }

    private int getRandomYear() {
        return (int) (Math.random() * 50 + 1960);
    }

    private String getRandomColor() {
        return colors[(int) (Math.random() * 10)];
    }

    private String getRandomBrand() {
        return brands[(int) (Math.random() * 10)];
    }

    private int getRandomPrice() {
        return (int) (Math.random() * 100000);
    }

    private boolean getRandomSoldState() {
        return Math.random() > 0.5;
    }

    public List<String> getColors() {
        return Arrays.asList(colors);
    }

    public List<String> getBrands() {
        return Arrays.asList(brands);
    }
}
