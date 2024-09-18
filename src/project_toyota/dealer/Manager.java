package project_toyota.dealer;

import project_toyota.report_guide.Report;
import project_toyota.car.Car;
import project_toyota.car_exception.CountyFactoryNotEqualException;
import project_toyota.factory.AssemblyLine;
import project_toyota.project_enum.PricesForCars;
import project_toyota.warehouse.Warehouse;

import java.math.BigDecimal;

public class Manager {
    private final BigDecimal PERCENT = BigDecimal.valueOf(0.1);
    private String name;
    private Report report;
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
              //  report.addSoldCars(warehouse.getTypeDyna().get(0));
                return warehouse.takeDyna(warehouse.getTypeDyna().get(0));
            }
            if (costumerMoney.compareTo(addPercent(PricesForCars.HIANCE, PERCENT)) >= 0 &&
                    warehouse.getTypeHiance().isEmpty()) {
                warehouse.addHiance(assemblyLine.createHiance(addPercent(PricesForCars.HIANCE, PERCENT),
                        "Black"));
                return warehouse.takeHiance(warehouse.getTypeHiance().get(0));
            }
            if (costumerMoney.compareTo(addPercent(PricesForCars.SOLARA, PERCENT)) >= 0 &&
                    warehouse.getTypeSolara().isEmpty()) {
                warehouse.addSolara(assemblyLine.createSolara(addPercent(PricesForCars.SOLARA, PERCENT),
                        "White"));
                return warehouse.takeSolara(warehouse.getTypeSolara().get(0));
            }
            if (costumerMoney.compareTo(addPercent(PricesForCars.CAMRY, PERCENT)) >= 0 &&
                    warehouse.getTypeCamry().isEmpty()) {
                warehouse.addCamry(assemblyLine.createCamry(addPercent(PricesForCars.CAMRY, PERCENT),
                        "Black"));
                return warehouse.takeCamry(warehouse.getTypeCamry().get(0));
            }
        }
            if (costumerMoney.compareTo(PricesForCars.DYNA.getPriceCar()) >= 0 &&
                    !warehouse.getTypeDyna().isEmpty()) {
                return warehouse.takeDyna(warehouse.getTypeDyna().get(0));
            }
            if (costumerMoney.compareTo(PricesForCars.HIANCE.getPriceCar()) >= 0 &&
                    !warehouse.getTypeHiance().isEmpty()) {
                return warehouse.takeHiance(warehouse.getTypeHiance().get(0));
            }
            if (costumerMoney.compareTo(PricesForCars.SOLARA.getPriceCar()) >= 0 &&
                    !warehouse.getTypeSolara().isEmpty()) {
                return warehouse.takeSolara(warehouse.getTypeSolara().get(0));
            }
            if (costumerMoney.compareTo(PricesForCars.CAMRY.getPriceCar()) >= 0 &&
                    !warehouse.getTypeCamry().isEmpty()) {
                return warehouse.takeCamry(warehouse.getTypeCamry().get(0));
            }

        return null;
    }

    /**
     * 2. Создать класс Report, в котором будет отображаться вся статистика менеджера: имя менеджера,
     * проданные машины.
     * 3. Во время продажи, менеджер должен обновить свой report - добавить проданную машину в список.
     * 5. У менеджера должен появиться метод: сгенерируй отчет, в котором он выводит информацию в файл txt формата:
     * Имя менеджера
     * Модель №1 - стоимость продажи - себестоимость
     * Модель №2 - стоимость продажи - себестоимость
     * ....
     * Итог: доходы - (сумма всех продаж), расходы (сумма всех себестоимостей), прибыль - (доходы - расходы)
     */
//
//    private void generateReport() {
//        List<Car> solidCar = report.getSoldCars();
//        try (FileWriter file = new FileWriter("report.txt", true)) {
//
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//    public String getName() {
//        return name;
//    }
}
