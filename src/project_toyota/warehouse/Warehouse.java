package project_toyota.warehouse;

import project_toyota.car.Car;
import project_toyota.project_enum.CarTyp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Warehouse {
    private static final int WAREHOUSE_CAPACITY = 1000;
    private int totalCars = 0;
    private Map<CarTyp, List<Car>> carMap = new HashMap<>();

    public void addCar(Car car) {
        if (isWarehouseCapacity()) {
            List<Car> carList = carMap.get(car.getCarTyp());
            if (carList == null) {
                carList = new ArrayList<>();
                carMap.put(car.getCarTyp(), carList);
            }
            carList.add(car);
            totalCars++;
        }
    }

    public Car removeCar(Car car) {
        List<Car> carList = carMap.get(car.getCarTyp());
        if (carList != null) {
            if (carList.remove(car)) {
                totalCars--;
            }
        }
        return car;
    }

    private boolean isWarehouseCapacity() {
        if (WAREHOUSE_CAPACITY > totalCars) {
            return true;
        }
        System.out.println("На складе нет места!");
        return false;
    }

    public int getTotalCars() {
        return totalCars;
    }

    public Map<CarTyp, List<Car>> getCarMap() {
        return carMap;
    }
}
