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

import java.math.BigDecimal;

public class Runner {
    public static void main(String[] args) throws StartCarException, CountyFactoryNotEqualException {
        PartsFactory partsFactoryJapan = new PartsFactory(Country.JAPAN);
        PartsFactory partsFactoryKorea = new PartsFactory(Country.KOREA);
        PartsFactory partsFactoryRussia = new PartsFactory(Country.RUSSIA);
        PartsFactory partsFactoryGermany = new PartsFactory(Country.GERMANY);

        AssemblyLine assemblyLineJapan2 = new AssemblyLine(Country.JAPAN,partsFactoryJapan);

        AssemblyLine assemblyLineJapan = new AssemblyLine(Country.JAPAN,partsFactoryJapan);
        AssemblyLine assemblyLineKorea = new AssemblyLine(Country.KOREA,partsFactoryKorea);
        AssemblyLine assemblyLineRussia = new AssemblyLine(Country.RUSSIA,partsFactoryRussia);
        AssemblyLine assemblyLineGermany = new AssemblyLine(Country.GERMANY,partsFactoryGermany);

        try {

            new AssemblyLine(Country.JAPAN, new PartsFactory(Country.GERMANY));
        }catch (CountyFactoryNotEqualException e){
            System.out.println("неудача " + e.getMessage());
        }


        Camry blackCamry = assemblyLineJapan.createCamry(BigDecimal.valueOf(10_000), "Black");
        Solara redSolara = assemblyLineKorea.createSolara(BigDecimal.valueOf(10_000), "Red");
        Hiance whiteHiance = assemblyLineRussia.createHiance(BigDecimal.valueOf(20_000), "White");
        Dyna yellowDyna = assemblyLineGermany.createDyna(BigDecimal.valueOf(30_000), "Yellow");

        blackCamry.setGasTank(10);
        blackCamry.cruiseControlOnOff();
        blackCamry.cruiseControlOnOff();
        blackCamry.useHeadlights();
        blackCamry.usb();
        blackCamry.usb();
        blackCamry.startMoving();
        blackCamry.stopTheMotion();

        redSolara.setGasTank(5);
        redSolara.cruiseControlOnOff();
        redSolara.cruiseControlOnOff();
        redSolara.useHeadlights();
        redSolara.toggleRoof();
        redSolara.toggleRoof();
        redSolara.miniRefrigerator();
        redSolara.startMoving();
        redSolara.stopTheMotion();

        whiteHiance.setGasTank(15);
        whiteHiance.liftingCapacityInfo();
        System.out.println(whiteHiance.getSpareWheel());
        whiteHiance.useHeadlights();
        whiteHiance.startMoving();
        whiteHiance.stopTheMotion();

        yellowDyna.setGasTank(20);
        yellowDyna.liftingCapacityInfo();
        yellowDyna.useHeadlights();
        yellowDyna.chargePhone();
        yellowDyna.chargePhone();
        yellowDyna.startMoving();
        yellowDyna.stopTheMotion();

    }
}
