package project_toyota;

import project_toyota.car.Camry;
import project_toyota.car.Dyna;
import project_toyota.car.Hiance;
import project_toyota.car.Solara;
import project_toyota.car_exception.CountyFactoryNotEqualException;
import project_toyota.car_exception.StartCarException;
import project_toyota.dealer.Cashier;
import project_toyota.dealer.Customer;
import project_toyota.dealer.Manager;
import project_toyota.factory.AssemblyLine;
import project_toyota.factory.PartsFactory;
import project_toyota.project_enum.CarPrice;
import project_toyota.project_enum.Country;
import project_toyota.warehouse.Warehouse;

import java.math.BigDecimal;
import java.util.List;

public class Runner {
    public static void main(String[] args) throws StartCarException, CountyFactoryNotEqualException {
        PartsFactory partsFactoryJapan = new PartsFactory(Country.JAPAN);

        AssemblyLine assemblyLineJapan = new AssemblyLine(Country.JAPAN, partsFactoryJapan);

        Camry blackCamry = assemblyLineJapan.createCamry(CarPrice.CAMRY.getPriceCar(), "Black");
        Solara whiteSolara = assemblyLineJapan.createSolara(CarPrice.SOLARA.getPriceCar(), "White");
        Hiance blackHiance = assemblyLineJapan.createHiance(CarPrice.HIANCE.getPriceCar(), "Black");
        Dyna blackDyna = assemblyLineJapan.createDyna(CarPrice.DYNA.getPriceCar(), "Black");

        // склад
        Warehouse warehouse = new Warehouse();
        warehouse.addCar(blackCamry);
        warehouse.addCar(whiteSolara);
        warehouse.addCar(blackHiance);
        warehouse.addCar(blackDyna);
        Manager manager = new Manager("Nikolay");
        Cashier cashier = new Cashier();
        manager.setAssemblyLine(assemblyLineJapan);

        Customer customerAnbu = new Customer("Anbu", BigDecimal.valueOf(10_000));
        Customer customerIvan = new Customer("Ivan", BigDecimal.valueOf(12_000));
        Customer customerAndrey = new Customer("Andrey", BigDecimal.valueOf(15_000));
        Customer customerIgor = new Customer("Igor", BigDecimal.valueOf(22_000));
        Customer customerVladimir = new Customer("Vladimir", BigDecimal.valueOf(11_000));
        Customer customerAnna = new Customer("Anna", BigDecimal.valueOf(13_200));
        Customer customerGalina = new Customer("Galina", BigDecimal.valueOf(8_000));
        Customer customerPetr = new Customer("Petr", BigDecimal.valueOf(30_000));

        List<Customer> listCustomers = List.of(customerAnbu, customerIvan, customerAndrey,
                customerIgor, customerVladimir, customerAnna, customerGalina, customerPetr);
        for (Customer customer : listCustomers) {
            cashier.acceptsCarForSale(manager.sellTheCar(customer, warehouse));
        }

        System.out.println("Сумма всех проданных машин: " + cashier.getTotalMoney());
        manager.generateReport();
    }
}
