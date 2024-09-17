package project_toyota.car;

import project_toyota.car.car_detail.*;
import project_toyota.project_enum.Country;
import project_toyota.project_enum.Transmission;

import java.math.BigDecimal;

public class Hiance extends Truck {
    private Wheel spareWheel;

    public Hiance(Country country, String color, double maxSpeed, Transmission transmission,
                  Wheel[] wheel, GasTank gasTank, Engine engine, Electrician electrician,
                  Headlights headlight, BigDecimal price, Wheel spareWheel) {
        super(country, color, maxSpeed, transmission, wheel, gasTank, engine, electrician, headlight, price);
        this.spareWheel = spareWheel;
    }
    public Wheel getSpareWheel() {
        return spareWheel;
    }

    public void setSpareWheel(Wheel spareWheel) {
        this.spareWheel = spareWheel;
    }
}
