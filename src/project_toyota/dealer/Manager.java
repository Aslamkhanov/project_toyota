package project_toyota.dealer;

import project_toyota.report_guide.Report;
import project_toyota.car.Car;
import project_toyota.car_exception.CountyFactoryNotEqualException;
import project_toyota.factory.AssemblyLine;
import project_toyota.project_enum.PricesForCars;
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

    public BigDecimal addPercent(PricesForCars prices, BigDecimal percent) {
        return prices.getPriceCar().add(prices.getPriceCar().multiply(percent));
    }

    public Car sellTheCar(Customer customer, Warehouse warehouse) throws CountyFactoryNotEqualException {
        BigDecimal costumerMoney = customer.getMoney();

        if (Warehouse.getTotalCars() == 0) {

            if (costumerMoney.compareTo(addPercent(PricesForCars.DYNA, PERCENT)) >= 0 &&
                    warehouse.getTypeDyna().isEmpty()) {
                warehouse.addDyna(assemblyLine.createDyna(addPercent(PricesForCars.DYNA, PERCENT),
                        "Black"));
                 report.addSoldCars(this.name, warehouse.getTypeDyna().get(0));
                 return warehouse.takeDyna(warehouse.getTypeDyna().get(0));
            }
            if (costumerMoney.compareTo(addPercent(PricesForCars.HIANCE, PERCENT)) >= 0 &&
                    warehouse.getTypeHiance().isEmpty()) {
                warehouse.addHiance(assemblyLine.createHiance(addPercent(PricesForCars.HIANCE, PERCENT),
                        "Black"));
                report.addSoldCars(this.name, warehouse.getTypeHiance().get(0));
                return warehouse.takeHiance(warehouse.getTypeHiance().get(0));
            }
            if (costumerMoney.compareTo(addPercent(PricesForCars.SOLARA, PERCENT)) >= 0 &&
                    warehouse.getTypeSolara().isEmpty()) {
                warehouse.addSolara(assemblyLine.createSolara(addPercent(PricesForCars.SOLARA, PERCENT),
                        "White"));
                report.addSoldCars(this.name, warehouse.getTypeSolara().get(0));
                return warehouse.takeSolara(warehouse.getTypeSolara().get(0));
            }
            if (costumerMoney.compareTo(addPercent(PricesForCars.CAMRY, PERCENT)) >= 0 &&
                    warehouse.getTypeCamry().isEmpty()) {
                warehouse.addCamry(assemblyLine.createCamry(addPercent(PricesForCars.CAMRY, PERCENT),
                        "Black"));
                report.addSoldCars(this.name, warehouse.getTypeCamry().get(0));
                return warehouse.takeCamry(warehouse.getTypeCamry().get(0));
            }
        }
            if (costumerMoney.compareTo(PricesForCars.DYNA.getPriceCar()) >= 0 &&
                    !warehouse.getTypeDyna().isEmpty()) {
                report.addSoldCars(this.name, warehouse.getTypeDyna().get(0));
                return warehouse.takeDyna(warehouse.getTypeDyna().get(0));
            }
            if (costumerMoney.compareTo(PricesForCars.HIANCE.getPriceCar()) >= 0 &&
                    !warehouse.getTypeHiance().isEmpty()) {
                report.addSoldCars(this.name, warehouse.getTypeHiance().get(0));
                return warehouse.takeHiance(warehouse.getTypeHiance().get(0));
            }
            if (costumerMoney.compareTo(PricesForCars.SOLARA.getPriceCar()) >= 0 &&
                    !warehouse.getTypeSolara().isEmpty()) {
                report.addSoldCars(this.name, warehouse.getTypeSolara().get(0));
                return warehouse.takeSolara(warehouse.getTypeSolara().get(0));
            }
            if (costumerMoney.compareTo(PricesForCars.CAMRY.getPriceCar()) >= 0 &&
                    !warehouse.getTypeCamry().isEmpty()) {
                report.addSoldCars(this.name, warehouse.getTypeCamry().get(0));
                return warehouse.takeCamry(warehouse.getTypeCamry().get(0));
            }
        return null;
    }

    public void generateReport() {
        List<Car> solidCar = report.getSoldCars();
        String managerName = report.getManagerName();

        BigDecimal totalIncome = BigDecimal.ZERO;
        BigDecimal totalCost = BigDecimal.ZERO;
        try (FileWriter file = new FileWriter("report.txt", true) ;
            BufferedWriter writer = new BufferedWriter(file)){

            writer.write("Имя менеджера: " + managerName + "\n\n");

            for (Car car : solidCar){
                BigDecimal sellingPrice = car.getPrice();
                BigDecimal costPrice = car.getModelGuide().getCostPriceCar();
                totalIncome = totalIncome.add(sellingPrice);
                totalCost = totalCost.add(costPrice);

                writer.write(car.getClass() + " стоимость продажи " + sellingPrice + " себестоимость " +
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