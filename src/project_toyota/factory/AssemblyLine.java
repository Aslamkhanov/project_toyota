package project_toyota.factory;

import project_toyota.project_enum.Country;
import project_toyota.project_enum.Diameter;
import project_toyota.project_enum.Transmission;
import project_toyota.car.Camry;
import project_toyota.car.Dyna;
import project_toyota.car.Hiance;
import project_toyota.car.Solara;
import project_toyota.car_exception.CountyFactoryNotEqualException;

import java.math.BigDecimal;

public class AssemblyLine {
    private final int diameterCamry = Diameter.CAMRY.getDiameter();
    private final int diameterSolara = Diameter.SOLARA.getDiameter();
    private final int diameterTruck = Diameter.TRUCK.getDiameter();
    private final double MaxSpeedCamry = 200.0;
    private final double MaxSpeedSolara = 180.0;
    private final double MaxSpeedTruck = 120.0;
    private PartsFactory partsFactory;

    public AssemblyLine(PartsFactory partsFactory) {
        this.partsFactory = partsFactory;
    }

    private void checkFactoryCountry(Country country) throws CountyFactoryNotEqualException {
        if (!country.equals(partsFactory.getCountry())) {
            throw new CountyFactoryNotEqualException("Страна фабрики не совпадает: " +
                    partsFactory.getCountry() + " != " + country);
        }
    }

    public Camry createCamry(BigDecimal price, String color) throws CountyFactoryNotEqualException {
        checkFactoryCountry(Country.JAPAN);
        Wheel[] wheels = {partsFactory.createWheel(diameterCamry),
                partsFactory.createWheel(diameterCamry),
                partsFactory.createWheel(diameterCamry),
                partsFactory.createWheel(diameterCamry)};
        return new Camry(color, getMaxSpeedCamry(), Transmission.AUTOMATIC,
                wheels, partsFactory.createGasTank(), partsFactory.createEngine(),
                partsFactory.createElectrician(), partsFactory.creteHeadlights(), price, false);
    }

    public Solara createSolara(BigDecimal price, String color) throws CountyFactoryNotEqualException {
        checkFactoryCountry(Country.KOREA);
        Wheel[] wheels = {partsFactory.createWheel(diameterSolara),
                partsFactory.createWheel(diameterSolara),
                partsFactory.createWheel(diameterSolara),
                partsFactory.createWheel(diameterSolara)};
        return new Solara(color, getMaxSpeedSolara(), Transmission.AUTOMATIC,
                wheels, partsFactory.createGasTank(), partsFactory.createEngine(),
                partsFactory.createElectrician(), partsFactory.creteHeadlights(),
                price, false, false);
    }

    public Hiance createHiance(BigDecimal price, String color) throws CountyFactoryNotEqualException {
        checkFactoryCountry(Country.RUSSIA);
        Wheel[] wheels = {partsFactory.createWheel(diameterTruck),
                partsFactory.createWheel(diameterTruck),
                partsFactory.createWheel(diameterTruck),
                partsFactory.createWheel(diameterTruck)};
        return new Hiance(color, getMaxSpeedTruck(), Transmission.AUTOMATIC,
                wheels, partsFactory.createGasTank(), partsFactory.createEngine(), partsFactory.createElectrician(),
                partsFactory.creteHeadlights(), price,partsFactory.createWheel(diameterTruck));
    }

    public Dyna createDyna(BigDecimal price, String color) throws CountyFactoryNotEqualException {
        checkFactoryCountry(Country.GERMANY);
        Wheel[] wheels = {partsFactory.createWheel(diameterTruck),
                partsFactory.createWheel(diameterTruck),
                partsFactory.createWheel(diameterTruck),
                partsFactory.createWheel(diameterTruck)};
        return new Dyna(color, getMaxSpeedTruck(), Transmission.AUTOMATIC,
                wheels, partsFactory.createGasTank(), partsFactory.createEngine(),
                partsFactory.createElectrician(), partsFactory.creteHeadlights(), price);
    }

    public PartsFactory getPartsFactory() {
        return partsFactory;
    }

    public void setPartsFactory(PartsFactory partsFactory) {
        this.partsFactory = partsFactory;
    }

    public double getMaxSpeedCamry() {
        return MaxSpeedCamry;
    }

    public double getMaxSpeedSolara() {
        return MaxSpeedSolara;
    }

    public double getMaxSpeedTruck() {
        return MaxSpeedTruck;
    }
}
