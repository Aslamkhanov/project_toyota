package project_toyota.car;

import project_toyota.project_enum.Transmission;
import project_toyota.factory.*;

import java.math.BigDecimal;

public class Dyna extends Truck {
    public Dyna(String color, double maxSpeed, Transmission transmission,
                Wheel[] wheel, GasTank gasTank, Engine engine, Electrician electrician,
                Headlights headlight, BigDecimal price) {
        super(color, maxSpeed, transmission, wheel, gasTank, engine, electrician, headlight, price);
    }

    @Override
    public void useHeadlights() {
        super.useHeadlights();
    }

    @Override
    public void liftingCapacityInfo() {
        super.liftingCapacityInfo();
    }

    @Override
    public void wheelReplacement(Wheel newWheel) {
        super.wheelReplacement(newWheel);
    }

    public void chargePhone() {
        System.out.println("Функция зарядить телефон ");
    }
}
