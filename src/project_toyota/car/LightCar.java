package project_toyota.car;

import project_toyota.car.car_detail.*;
import project_toyota.project_enum.Transmission;

import java.math.BigDecimal;

public abstract class LightCar extends Car {
    private boolean cruiseControl;

    public LightCar(String color, double maxSpeed, Transmission transmission, Wheel[] wheel,
                    GasTank gasTank, Engine engine, Electrician electrician,
                    Headlights headlight, BigDecimal price, boolean cruiseControl) {
        super(color, maxSpeed, transmission, wheel, gasTank, engine, electrician, headlight, price);
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
