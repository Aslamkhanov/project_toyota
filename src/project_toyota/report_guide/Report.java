package project_toyota.report_guide;

import project_toyota.car.Car;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Report {
    private List<Car> soldCars = new ArrayList<>();
    public void addSoldCars(Car car){
        soldCars.add(car);
    }

    public List<Car> getSoldCars() {
        return soldCars;
    }
}


