package project_toyota.car;

import project_toyota.car.car_detail.*;
import project_toyota.project_enum.CarTyp;
import project_toyota.project_enum.Country;
import project_toyota.project_enum.Transmission;
import project_toyota.report_guide.ModelGuide;

import java.math.BigDecimal;

public abstract class LightCar extends Car {
    private boolean cruiseControl;

    public LightCar(CarTyp carTyp, ModelGuide modelGuide, Country country, String color, double maxSpeed,
                    Transmission transmission, Wheel[] wheel, GasTank gasTank, Engine engine, Electrician electrician,
                    Headlights headlight, BigDecimal price, boolean cruiseControl) {
        super(carTyp, modelGuide, country, color, maxSpeed, transmission, wheel, gasTank, engine,
                electrician, headlight, price);
        this.cruiseControl = cruiseControl;
    }

    public void cruiseControlOnOff() {
        this.cruiseControl = !this.cruiseControl;
        System.out.println("Круиз-контроль " + (cruiseControl ? "включен" : "выключен"));
    }

    public boolean isCruiseControl() {
        return cruiseControl;
    }

    public void setCruiseControl(boolean cruiseControl) {
        this.cruiseControl = cruiseControl;
    }
}
