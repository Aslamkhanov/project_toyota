package project_toyota;

import project_toyota.car.Camry;
import project_toyota.car.Dyna;
import project_toyota.car.Hiance;
import project_toyota.car.Solara;
import project_toyota.car_exception.CountyFactoryNotEqualException;
import project_toyota.car_exception.StartCarException;
import project_toyota.factory.AssemblyLine;
import project_toyota.car.car_detail.GasTank;
import project_toyota.factory.PartsFactory;
import project_toyota.project_enum.Country;
import project_toyota.project_enum.PricesForCars;

import java.math.BigDecimal;

public class Runner {
    public static void main(String[] args) throws StartCarException, CountyFactoryNotEqualException {
        PartsFactory partsFactoryJapan = new PartsFactory(Country.JAPAN);
        PartsFactory partsFactoryKorea = new PartsFactory(Country.KOREA);
        PartsFactory partsFactoryRussia = new PartsFactory(Country.RUSSIA);
        PartsFactory partsFactoryGermany = new PartsFactory(Country.GERMANY);

        AssemblyLine assemblyLineJapan = new AssemblyLine(Country.JAPAN,partsFactoryJapan);
        AssemblyLine assemblyLineKorea = new AssemblyLine(Country.KOREA,partsFactoryKorea);
        AssemblyLine assemblyLineRussia = new AssemblyLine(Country.RUSSIA,partsFactoryRussia);
        AssemblyLine assemblyLineGermany = new AssemblyLine(Country.GERMANY,partsFactoryGermany);

        try {

            new AssemblyLine(Country.JAPAN, new PartsFactory(Country.GERMANY));
        }catch (CountyFactoryNotEqualException e){
            System.out.println("неудача " + e.getMessage());
        }

        Camry blackCamry = assemblyLineJapan.createCamry(PricesForCars.CAMRY.getPriceCar(), "Black");
        Solara whiteSolara = assemblyLineJapan.createSolara(PricesForCars.SOLARA.getPriceCar(), "White");
        Hiance blackHiance = assemblyLineJapan.createHiance(PricesForCars.HIANCE.getPriceCar(), "Black");
        Dyna blackDyna = assemblyLineJapan.createDyna(PricesForCars.DYNA.getPriceCar(), "Black");

        // склад
        Warehouse warehouse = new Warehouse();
        warehouse.addCamry(blackCamry);
        warehouse.addSolara(whiteSolara);
        warehouse.addHiance(blackHiance);
        warehouse.addDyna(blackDyna);
        Manager manager = new Manager();
        Cashier cashier = new Cashier();

        // В первый день придет 8 покупателей.
        // у первого будет 10000 - уйдет с камри, которая в наличии на складе
        Customer customer1 = new Customer("Anbu", BigDecimal.valueOf(10_000));
        cashier.acceptsCarForSale(manager.sellTheCar(customer1,warehouse));

        // у второго будет 12000 - уйдет с соларой, которая в наличии на складе
        Customer customer2 = new Customer("Ivan", BigDecimal.valueOf(12_000));
        cashier.acceptsCarForSale(manager.sellTheCar(customer2,warehouse));

        // у третьего будет 15000 - уйдет с хайянс, которая в наличии на складе
        Customer customer3 = new Customer("Andrey", BigDecimal.valueOf(15_000));
        cashier.acceptsCarForSale(manager.sellTheCar(customer3,warehouse));

        // у четвертого будет 22000 - уйдет с дюной, которая в наличии на складе
        Customer customer4 = new Customer("Andrey", BigDecimal.valueOf(22_000));
        cashier.acceptsCarForSale(manager.sellTheCar(customer4,warehouse));

        // у пятого будет 11000 - уйдет с камри, созданной по запросу на производство (цена камри + 10%)
        Customer customer5 = new Customer("Andrey", BigDecimal.valueOf(11_000));
        cashier.acceptsCarForSale(manager.sellTheCar(customer5,warehouse));

        // у шестого будет 13200 - уйдет с соларой, созданной по запросу на производство (цена солары + 10%)
        Customer customer6 = new Customer("Andrey", BigDecimal.valueOf(13_200));
        cashier.acceptsCarForSale(manager.sellTheCar(customer6,warehouse));

        // у седьмого будет 8000 - уйдет ни с чем
        Customer customer7 = new Customer("Andrey", BigDecimal.valueOf(8_000));
        cashier.acceptsCarForSale(manager.sellTheCar(customer7,warehouse));

        // у восьмого будет 30000 - уйдет с дюной, созданной по запросу на производство (цена дюны + 10%)
        Customer customer8 = new Customer("Andrey", BigDecimal.valueOf(15_000));
        cashier.acceptsCarForSale(manager.sellTheCar(customer8,warehouse));
        System.out.println("Сумма всех проданных машин: " + cashier.getTotalMoney());



        blackCamry.setGasTank(10);
        blackCamry.cruiseControlOnOff();
        blackCamry.cruiseControlOnOff();
        blackCamry.useHeadlights();
        blackCamry.usb();
        blackCamry.usb();
        blackCamry.startMoving();
        blackCamry.stopTheMotion();

        whiteSolara.setGasTank(5);
        whiteSolara.cruiseControlOnOff();
        whiteSolara.cruiseControlOnOff();
        whiteSolara.useHeadlights();
        whiteSolara.toggleRoof();
        whiteSolara.toggleRoof();
        whiteSolara.miniRefrigerator();
        whiteSolara.startMoving();
        whiteSolara.stopTheMotion();

        blackHiance.setGasTank(15);
        blackHiance.liftingCapacityInfo();
        System.out.println(blackHiance.getSpareWheel());
        blackHiance.useHeadlights();
        blackCamry.startMoving();
        blackCamry.stopTheMotion();

        blackDyna.setGasTank(20);
        blackDyna.liftingCapacityInfo();
        blackDyna.useHeadlights();
        blackDyna.chargePhone();
        blackDyna.chargePhone();
        blackDyna.startMoving();
        blackDyna.stopTheMotion();

    }
}
