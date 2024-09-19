package project_toyota.report_guide;

import project_toyota.car.Car;

import java.util.ArrayList;
import java.util.List;

public class Report {
    private List<Car> soldCars = new ArrayList<>();
    private String managerName;

    public void addSoldCars(String name, Car car) {
        soldCars.add(car);
        managerName = name;

    }

    public List<Car> getSoldCars() {
        return soldCars;
    }

    public String getManagerName() {
        return managerName;
    }
}


