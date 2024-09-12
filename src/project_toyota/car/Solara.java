package project_toyota.car;

import project_toyota.project_enum.Transmission;
import project_toyota.factory.*;

import java.math.BigDecimal;

public class Solara extends Cabriolet {

    public Solara(String color, double maxSpeed, Transmission transmission, Wheel[] wheel,
                  GasTank gasTank, Engine engine, Electrician electrician, Headlights headlight,
                  BigDecimal price, boolean cruiseControl, boolean roof) {
        super(color, maxSpeed, transmission, wheel, gasTank, engine, electrician, headlight,
                price, cruiseControl, roof);
    }

    @Override
    public void useHeadlights() {
        super.useHeadlights();
    }

    @Override
    public void toggleRoof() {
        super.toggleRoof();
    }

    @Override
    public void wheelReplacement(Wheel newWheel) {
        super.wheelReplacement(newWheel);
    }

    public void miniRefrigerator() {
        System.out.println("функция охладить напиток ");
    }
}
