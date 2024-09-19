package project_toyota.factory;

import project_toyota.car.Camry;
import project_toyota.car.Dyna;
import project_toyota.car.Hiance;
import project_toyota.car.Solara;
import project_toyota.car.car_detail.Wheel;
import project_toyota.car_exception.CountyFactoryNotEqualException;
import project_toyota.project_enum.Country;
import project_toyota.project_enum.Diameter;
import project_toyota.project_enum.Transmission;
import project_toyota.report_guide.ModelGuide;

import java.math.BigDecimal;
import java.util.Objects;

public class AssemblyLine {
    private final double maxSpeedCamry = 200.0;
    private final double maxSpeedSolara = 180.0;
    private final double maxSpeedTruck = 120.0;
    private Country country;
    private PartsFactory partsFactory;


    public AssemblyLine(Country country, PartsFactory partsFactory)throws CountyFactoryNotEqualException  {
        this.country = country;
        if (!partsFactory.getCountry().equals(country)) {
            throw new CountyFactoryNotEqualException("Страна фабрики не совпадает: " +
                    partsFactory.getCountry() + " != " + country);
        }
        this.partsFactory = partsFactory;
    }

    private Wheel[] wheelsDiameter(Diameter diameter) {
        Wheel[] wheels = new Wheel[3];

        for (int i = 0; i < wheels.length; i++) {
            if (diameter.equals(Diameter.CAMRY)) {
                wheels[i] = partsFactory.createWheel(Diameter.CAMRY.getDiameter());
            } else if (diameter.equals(Diameter.SOLARA)) {
                wheels[i] = partsFactory.createWheel(Diameter.SOLARA.getDiameter());
            } else if (diameter.equals(Diameter.TRUCK)) {
                wheels[i] = partsFactory.createWheel(Diameter.TRUCK.getDiameter());
            }
        }
        return wheels;
    }

    public Camry createCamry(BigDecimal price, String color) throws CountyFactoryNotEqualException {
        Wheel[] wheels = wheelsDiameter(Diameter.CAMRY);
        return new Camry(ModelGuide.CAMRY, country, color, maxSpeedCamry, Transmission.AUTOMATIC, wheels,
                partsFactory.createGasTank(), partsFactory.createEngine(), partsFactory.createElectrician(),
                partsFactory.creteHeadlights(), price, false, partsFactory.createUsbSocket());
    }

    public Solara createSolara(BigDecimal price, String color) throws CountyFactoryNotEqualException {
        Wheel[] wheels = wheelsDiameter(Diameter.SOLARA);
        return new Solara(ModelGuide.SOLARA ,country, color, maxSpeedSolara, Transmission.AUTOMATIC,
                wheels, partsFactory.createGasTank(), partsFactory.createEngine(),
                partsFactory.createElectrician(), partsFactory.creteHeadlights(),
                price, false, partsFactory.createRoof());
    }

    public Hiance createHiance(BigDecimal price, String color) throws CountyFactoryNotEqualException {
        Wheel[] wheels = wheelsDiameter(Diameter.TRUCK);
        return new Hiance(ModelGuide.HIANCE, country, color, maxSpeedTruck, Transmission.AUTOMATIC,
                wheels, partsFactory.createGasTank(), partsFactory.createEngine(), partsFactory.createElectrician(),
                partsFactory.creteHeadlights(), price, partsFactory.createWheel(Diameter.TRUCK.getDiameter()));
    }

    public Dyna createDyna(BigDecimal price, String color) throws CountyFactoryNotEqualException {
        Wheel[] wheels = wheelsDiameter(Diameter.TRUCK);
        return new Dyna(ModelGuide.DYNA, country, color, maxSpeedTruck, Transmission.AUTOMATIC, wheels,
                partsFactory.createGasTank(), partsFactory.createEngine(), partsFactory.createElectrician(),
                partsFactory.creteHeadlights(), price, partsFactory.createCharger());
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        AssemblyLine that = (AssemblyLine) object;
        return country == that.country;
    }

    @Override
    public int hashCode() {
        return Objects.hash(country);
    }

    public Country getCountry() {
        return country;
    }
}
