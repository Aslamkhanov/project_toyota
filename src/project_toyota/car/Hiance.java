package project_toyota.car;

import project_toyota.project_enum.Diameter;
import project_toyota.project_enum.Transmission;
import project_toyota.factory.*;

import java.math.BigDecimal;
import java.util.Arrays;

public class Hiance extends Truck {
    private Wheel spareWheel;

    public Hiance(String color, double maxSpeed, Transmission transmission,
                  Wheel[] wheel, GasTank gasTank, Engine engine, Electrician electrician,
                  Headlights headlight, BigDecimal price, Wheel spareWheel) {
        super(color, maxSpeed, transmission, wheel, gasTank, engine, electrician, headlight, price);
        this.spareWheel = spareWheel;
    }

    @Override
    public void liftingCapacityInfo() {
        super.liftingCapacityInfo();
    }


    @Override
    public void wheelReplacement(Wheel newWheel) {
        super.wheelReplacement(newWheel);
    }

    @Override
    public String toString() {
        return "Hiance{" +
                "spareWheel=" + spareWheel +
                '}';
    }

    @Override
    public void useHeadlights() {
        super.useHeadlights();
    }

    public Wheel getSpareWheel() {
        return spareWheel;
    }

    public void setSpareWheel(Wheel spareWheel) {
        this.spareWheel = spareWheel;
    }
}
