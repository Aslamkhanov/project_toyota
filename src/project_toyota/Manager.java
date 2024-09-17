package project_toyota;

import project_toyota.car.Car;
import project_toyota.car_exception.CountyFactoryNotEqualException;
import project_toyota.factory.AssemblyLine;
import project_toyota.project_enum.PricesForCars;

import java.math.BigDecimal;

public class Manager {
    final BigDecimal PERCENT = BigDecimal.valueOf(0.1);
    AssemblyLine assemblyLine;

    public void setAssemblyLine(AssemblyLine assemblyLine) {
        this.assemblyLine = assemblyLine;
    }

    public BigDecimal addPercent(PricesForCars prices, BigDecimal percent) {
        return prices.getPriceCar().add(prices.getPriceCar().multiply(percent));
    }

    public Car sellTheCar(Customer customer, Warehouse warehouse) throws CountyFactoryNotEqualException {
        BigDecimal costumerMoney = customer.getMoney();

        if (Warehouse.getTotalCars() == 0) {
            if (Warehouse.getTotalCars() != 0) {
                if (costumerMoney.compareTo(addPercent(PricesForCars.DYNA, PERCENT)) >= 0 &&
                        warehouse.getTypeDyna().isEmpty()) {
                    warehouse.addDyna(assemblyLine.createDyna(addPercent(PricesForCars.DYNA, PERCENT),
                            "Black"));
                    return warehouse.takeDyna(warehouse.getTypeDyna().getFirst());
                }
                if (costumerMoney.compareTo(addPercent(PricesForCars.HIANCE, PERCENT)) >= 0 &&
                        warehouse.getTypeHiance().isEmpty()) {
                    warehouse.addHiance(assemblyLine.createHiance(addPercent(PricesForCars.HIANCE, PERCENT),
                            "Black"));
                    return warehouse.takeHiance(warehouse.getTypeHiance().getFirst());
                }
                if (costumerMoney.compareTo(addPercent(PricesForCars.SOLARA, PERCENT)) >= 0 &&
                        warehouse.getTypeSolara().isEmpty()) {
                    warehouse.addSolara(assemblyLine.createSolara(addPercent(PricesForCars.SOLARA, PERCENT),
                            "White"));
                    return warehouse.takeSolara(warehouse.getTypeSolara().getFirst());
                }
                if (costumerMoney.compareTo(addPercent(PricesForCars.CAMRY, PERCENT)) >= 0 &&
                        warehouse.getTypeCamry().isEmpty()) {

                    warehouse.addCamry(assemblyLine.createCamry(addPercent(PricesForCars.CAMRY, PERCENT),
                            "Black"));
                    return warehouse.takeCamry(warehouse.getTypeCamry().getFirst());
                }
            }
            return null;


        } else {
            if (costumerMoney.compareTo(PricesForCars.DYNA.getPriceCar()) >= 0 &&
                    !warehouse.getTypeDyna().isEmpty()) {
                return warehouse.takeDyna(warehouse.getTypeDyna().getFirst());
            }
            if (costumerMoney.compareTo(PricesForCars.HIANCE.getPriceCar()) >= 0 &&
                    !warehouse.getTypeHiance().isEmpty()) {
                return warehouse.takeHiance(warehouse.getTypeHiance().getFirst());
            }
            if (costumerMoney.compareTo(PricesForCars.SOLARA.getPriceCar()) >= 0 &&
                    !warehouse.getTypeSolara().isEmpty()) {
                return warehouse.takeSolara(warehouse.getTypeSolara().getFirst());
            }
            if (costumerMoney.compareTo(PricesForCars.CAMRY.getPriceCar()) >= 0 &&
                    !warehouse.getTypeCamry().isEmpty()) {
                return warehouse.takeCamry(warehouse.getTypeCamry().getFirst());
            }
        }
        return null;
    }
}
//if (Warehouse.getTotalCars() == 0) {
//        if (costumerMoney.compareTo(addPercent(PricesForCars.DYNA, PERCENT)) >= 0 &&
//        warehouse.getTypeDyna().isEmpty()) {
//        warehouse.addDyna(assemblyLine.createDyna(addPercent(PricesForCars.DYNA, PERCENT), "Black"));
//        return warehouse.takeDyna(warehouse.getTypeDyna().getFirst());
//        } else if (costumerMoney.compareTo(addPercent(PricesForCars.HIANCE, PERCENT)) >= 0 &&
//        warehouse.getTypeHiance().isEmpty()) {
//        warehouse.addHiance(assemblyLine.createHiance(addPercent(PricesForCars.HIANCE, PERCENT), "Black"));
//        return warehouse.takeHiance(warehouse.getTypeHiance().getFirst());
//        } else if (costumerMoney.compareTo(addPercent(PricesForCars.SOLARA, PERCENT)) >= 0 &&
//        warehouse.getTypeSolara().isEmpty()) {
//        warehouse.addSolara(assemblyLine.createSolara(addPercent(PricesForCars.SOLARA, PERCENT), "White"));
//        return warehouse.takeSolara(warehouse.getTypeSolara().getFirst());
//        } else if (costumerMoney.compareTo(addPercent(PricesForCars.CAMRY, PERCENT)) >= 0 &&
//        warehouse.getTypeCamry().isEmpty()) {
//        warehouse.addCamry(assemblyLine.createCamry(addPercent(PricesForCars.CAMRY, PERCENT), "Black"));
//        return warehouse.takeCamry(warehouse.getTypeCamry().getFirst());
//        }
//        return null;
//        } else {
//        if (costumerMoney.compareTo(addPercent(PricesForCars.DYNA, PERCENT)) >= 0 &&
//        !warehouse.getTypeDyna().isEmpty()) {
//        return warehouse.takeDyna(warehouse.getTypeDyna().getFirst());
//        } else if (costumerMoney.compareTo(addPercent(PricesForCars.HIANCE, PERCENT)) >= 0 &&
//        !warehouse.getTypeHiance().isEmpty()) {
//        return warehouse.takeHiance(warehouse.getTypeHiance().getFirst());
//        } else if (costumerMoney.compareTo(addPercent(PricesForCars.SOLARA, PERCENT)) >= 0 &&
//        !warehouse.getTypeSolara().isEmpty()) {
//        return warehouse.takeSolara(warehouse.getTypeSolara().getFirst());
//        } else if (costumerMoney.compareTo(addPercent(PricesForCars.CAMRY, PERCENT)) >= 0 &&
//        !warehouse.getTypeCamry().isEmpty()) {
//        return warehouse.takeCamry(warehouse.getTypeCamry().getFirst());
//        }
//        return null;
//        }

//    public Car sellTheCar(Customer customer, Warehouse warehouse) throws CountyFactoryNotEqualException {
//        BigDecimal costumerMoney = customer.getMoney();
//
//        if (Warehouse.getTotalCars() != 0) {
//            return warehouse.getMostExpensiveCar();
//
//        } else if (costumerMoney.compareTo(BigDecimal.valueOf(22_000)) >= 0) {
//            return assemblyLine.createDyna(addPercent(PricesForCars.DYNA,PERCENT), "Black");
//            warehouse.addDyna(assemblyLine.createDyna(addPercent(PricesForCars.DYNA,PERCENT), "Black"));
//
//        } else if (costumerMoney.compareTo(BigDecimal.valueOf(15_000)) >= 0) {
//            return assemblyLine.createHiance(addPercent(PricesForCars.HIANCE,PERCENT), "Black");
//
//        } else if (costumerMoney.compareTo(BigDecimal.valueOf(12_000)) >= 0) {
//            return assemblyLine.createSolara(addPercent(PricesForCars.SOLARA,PERCENT), "White");
//
//        } else if (costumerMoney.compareTo(BigDecimal.valueOf(10_000)) >= 0) {
//            return assemblyLine.createCamry(addPercent(PricesForCars.CAMRY,PERCENT), "Black");
//        }
//        return null;
//    }
//public Car sellTheCar(Customer customer, Warehouse warehouse) throws CountyFactoryNotEqualException {
//    BigDecimal customerMoney = customer.getMoney();
//    Car mostExpensiveCar = null;

// Найти самую дорогую машину в складе, которую может купить покупатель
//    for (Car car : warehouse.getCars()) {
//        if (car.getPrice().compareTo(customerMoney) <= 0 &&
//        (mostExpensiveCar == null || car.getPrice().compareTo(mostExpensiveCar.getPrice()) > 0)) {
//            mostExpensiveCar = car;
//        }
//    }
//
//    // Если есть подходящая машина, продать ее покупателю
//    if (mostExpensiveCar != null) {
//        customer.setMoney(customer.getMoney().subtract(mostExpensiveCar.getPrice()));
//        warehouse.removeCar(mostExpensiveCar);
//        return mostExpensiveCar;
//    }
//
//    // Если нет подходящей машины, создать заказ на линию сборки
//    BigDecimal maxPrice = customerMoney.multiply(PERCENT);
//    CarType carType = null;
//
//    if (maxPrice.compareTo(PricesForCars.DYNA.getPriceCar()) >= 0) {
//        carType = CarType.DYNA;
//    } else if (maxPrice.compareTo(PricesForCars.HIANCE.getPriceCar()) >= 0) {
//        carType = CarType.HIANCE;
//    } else if (maxPrice.compareTo(PricesForCars.SOLARA.getPriceCar()) >= 0) {
//        carType = CarType.SOLARA;
//    } else if (maxPrice.compareTo(PricesForCars.CAMRY.getPriceCar()) >= 0) {
//        carType = CarType.CAMRY;
//    }
//
//    if (carType != null) {
//        Car car = assemblyLine.createCar(carType, maxPrice, "Black");
//        customer.setMoney(BigDecimal.ZERO);
//        warehouse.addCar(car);
//        return car;
//    }
//
//    return null;
//}

