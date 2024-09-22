package project_toyota.dealer;

import project_toyota.car.Car;
import project_toyota.car_exception.CountyFactoryNotEqualException;
import project_toyota.factory.AssemblyLine;
import project_toyota.project_enum.CarPrice;
import project_toyota.project_enum.CarTyp;
import project_toyota.report_guide.Report;
import project_toyota.warehouse.Warehouse;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public class Manager {
    private final BigDecimal PERCENT = BigDecimal.valueOf(0.1);
    private String name;
    private Report report = new Report();
    private AssemblyLine assemblyLine;

    public Manager(String name) {
        this.name = name;
    }

    public void setAssemblyLine(AssemblyLine assemblyLine) {
        this.assemblyLine = assemblyLine;
    }

    public BigDecimal addPercent(CarPrice prices, BigDecimal percent) {
        return prices.getPriceCar().add(prices.getPriceCar().multiply(percent));
    }

    public Car sellTheCar(Customer customer, Warehouse warehouse) throws CountyFactoryNotEqualException {
        BigDecimal customerMoney = customer.getMoney();

        if (warehouse.getTotalCars() > 0) {
            for (CarTyp carTyp : CarTyp.values()) {
                List<Car> cars = warehouse.getCarMap().get(carTyp);
                if (cars != null && !cars.isEmpty()) {
                    cars.sort((car1, car2) -> car2.getPrice().compareTo(car1.getPrice()));
                    for (Car car : cars) {
                        if (customerMoney.compareTo(car.getPrice()) >= 0) {
                            report.addSoldCars(this.name, car);
                            warehouse.removeCar(car);
                            return car;
                        }
                    }
                }
            }
        }
        Car bestCar = null;
        for (CarPrice carPrice : CarPrice.values()) {
            if (customerMoney.compareTo(addPercent(carPrice, PERCENT)) >= 0) {
                Car car = createCar(carPrice, "Black");
                if (bestCar == null || car.getPrice().compareTo(bestCar.getPrice()) > 0) {
                    bestCar = car;
                }
            }
        }
        if (bestCar != null) {
            warehouse.addCar(bestCar);
            report.addSoldCars(this.name, bestCar);
            warehouse.removeCar(bestCar);
            return bestCar;
        }
        return null;
    }

    private Car createCar(CarPrice carPrice, String color) throws CountyFactoryNotEqualException {
        if (carPrice.compareTo(CarPrice.DYNA) >= 0) {
            return assemblyLine.createDyna(addPercent(carPrice, PERCENT), color);
        } else if (carPrice.compareTo(CarPrice.HIANCE) >= 0) {
            return assemblyLine.createHiance(addPercent(carPrice, PERCENT), color);
        } else if (carPrice.compareTo(CarPrice.SOLARA) >= 0) {
            return assemblyLine.createSolara(addPercent(carPrice, PERCENT), color);
        } else if (carPrice.compareTo(CarPrice.CAMRY) >= 0) {
            return assemblyLine.createCamry(addPercent(carPrice, PERCENT), color);
        }
        return null;
    }

    public void generateReport() {
        List<Car> solidCar = report.getSoldCars();
        String managerName = report.getManagerName();

        BigDecimal totalIncome = BigDecimal.ZERO;
        BigDecimal totalCost = BigDecimal.ZERO;
        try (FileWriter file = new FileWriter("report.txt", true);
             BufferedWriter writer = new BufferedWriter(file)) {

            writer.write("Имя менеджера: " + managerName + "\n\n");

            for (Car car : solidCar) {
                BigDecimal sellingPrice = car.getPrice();
                BigDecimal costPrice = car.getModelGuide().getCostPriceCar();
                totalIncome = totalIncome.add(sellingPrice);
                totalCost = totalCost.add(costPrice);

                writer.write(car.getCarTyp() + " - стоимость продажи " + sellingPrice + " - себестоимость " +
                        costPrice + "\n");

            }
            BigDecimal profit = totalIncome.subtract(totalCost);

            writer.write("Итог:\n");
            writer.write("Доходы: " + totalIncome + "\n");
            writer.write("Расходы: " + totalCost + "\n");
            writer.write("Прибыль: " + profit + "\n");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getName() {
        return name;
    }
}