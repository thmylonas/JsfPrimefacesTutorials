package com.thomasmylonas.jsf_primefaces_tutorials.view_layer.view_backing_beans.primefaces_backing_beans.pages_level_ge2_backing_beans;

import com.thomasmylonas.jsf_primefaces_tutorials.service_layer.models.primefaces_models.Car;
import com.thomasmylonas.jsf_primefaces_tutorials.service_layer.services.CarService;
import com.thomasmylonas.jsf_primefaces_tutorials.view_layer.view_backing_beans.primefaces_backing_beans.PrimefacesBackingBean;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import java.util.List;

@ManagedBean(name = "sortingDataTableBackingBean")
@ViewScoped
public class SortingDataTableBackingBean extends PrimefacesBackingBean {

    private List<Car> cars;

    @ManagedProperty(value = "#{carService}")
    @Setter
    private CarService carService;

    @PostConstruct
    private void init() {
        cars = carService.createCars(10);
    }

    public List<Car> getCars() {
        if (cars == null) {
            cars = this.carService.createCars(10);
        }
        return cars;
    }
}
