package project_toyota.car;

import project_toyota.project_enum.Transmission;
import project_toyota.factory.*;

import java.math.BigDecimal;

public class Camry extends LightCar {

    public Camry(String color, double maxSpeed, Transmission transmission,
                 Wheel[] wheel, GasTank gasTank, Engine engine, Electrician electrician,
                 Headlights headlight, BigDecimal price, boolean cruiseControl) {
        super(color, maxSpeed, transmission, wheel, gasTank, engine, electrician, headlight, price, cruiseControl);
    }

    @Override
    public void useHeadlights() {
        super.useHeadlights();
    }

    @Override
    public void cruiseControlOnOff() {
        super.cruiseControlOnOff();
    }

    @Override
    public void wheelReplacement(Wheel newWheel) {
        super.wheelReplacement(newWheel);
    }

    public void usb() {
        System.out.println("функция подключить музыку ");
    }
}
