package com.thomasmylonas.spring_mvc_jsf_pf_web_app.view_layer.view_backing_beans.primefaces_backing_beans.pages_level_ge2_backing_beans;

import com.thomasmylonas.spring_mvc_jsf_pf_web_app.service_layer.models.primefaces_models.Car;
import com.thomasmylonas.spring_mvc_jsf_pf_web_app.service_layer.services.CarService;
import com.thomasmylonas.spring_mvc_jsf_pf_web_app.view_layer.view_backing_beans.primefaces_backing_beans.PrimefacesBackingBean;

import javax.annotation.PostConstruct;
import java.util.List;

//@Component(value = "sortingDataTableBackingBean")
//@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SortingDataTableBackingBean extends PrimefacesBackingBean {

    private List<Car> cars;
//    @Autowired
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

    public void setService(CarService carService) {
        this.carService = carService;
    }
}
