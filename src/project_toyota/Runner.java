package project_toyota;

import project_toyota.car.Camry;
import project_toyota.car.Dyna;
import project_toyota.car.Hiance;
import project_toyota.car.Solara;
import project_toyota.car_exception.CountyFactoryNotEqualException;
import project_toyota.car_exception.StartCarException;
import project_toyota.factory.AssemblyLine;
import project_toyota.factory.GasTank;
import project_toyota.factory.PartsFactory;
import project_toyota.project_enum.Country;

import java.math.BigDecimal;

public class Runner {
    public static void main(String[] args) throws StartCarException, CountyFactoryNotEqualException {
        PartsFactory partsFactoryJapan = new PartsFactory(Country.JAPAN);
        PartsFactory partsFactoryKorea = new PartsFactory(Country.KOREA);
        PartsFactory partsFactoryRussia = new PartsFactory(Country.RUSSIA);
        PartsFactory partsFactoryGermany = new PartsFactory(Country.GERMANY);

        AssemblyLine assemblyLineJapan = new AssemblyLine(partsFactoryJapan);
        AssemblyLine assemblyLineKorea = new AssemblyLine(partsFactoryKorea);
        AssemblyLine assemblyLineRussia = new AssemblyLine(partsFactoryRussia);
        AssemblyLine assemblyLineGermany = new AssemblyLine(partsFactoryGermany);

        Camry blackCamry = assemblyLineJapan.createCamry(BigDecimal.valueOf(10_000), "Black");
        Solara redSolara = assemblyLineKorea.createSolara(BigDecimal.valueOf(10_000), "Red");
        Hiance whiteHiance = assemblyLineRussia.createHiance(BigDecimal.valueOf(20_000), "White");
        Dyna yellowDyna = assemblyLineGermany.createDyna(BigDecimal.valueOf(30_000), "Yellow");

        blackCamry.setGasTank(new GasTank(20));
        blackCamry.cruiseControlOnOff();
        blackCamry.cruiseControlOnOff();
        blackCamry.useHeadlights();
        blackCamry.usb();
        blackCamry.startMoving();
        blackCamry.stopTheMotion();

        redSolara.setGasTank(new GasTank(20));
        redSolara.cruiseControlOnOff();
        redSolara.cruiseControlOnOff();
        redSolara.useHeadlights();
        redSolara.toggleRoof();
        redSolara.toggleRoof();
        redSolara.miniRefrigerator();
        redSolara.startMoving();
        redSolara.stopTheMotion();

        whiteHiance.setGasTank(new GasTank(20));
        whiteHiance.liftingCapacityInfo();
        System.out.println(whiteHiance.getSpareWheel());
        whiteHiance.useHeadlights();
        whiteHiance.startMoving();
        whiteHiance.stopTheMotion();

        yellowDyna.setGasTank(new GasTank(20));
        yellowDyna.liftingCapacityInfo();
        yellowDyna.useHeadlights();
        yellowDyna.chargePhone();
        yellowDyna.startMoving();
        yellowDyna.stopTheMotion();

    }
}
