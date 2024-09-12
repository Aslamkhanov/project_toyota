package project_toyota.car;

import project_toyota.project_enum.Transmission;
import project_toyota.factory.*;

import java.math.BigDecimal;

public class Cabriolet extends LightCar {
    private boolean roof;

    public Cabriolet(String color, double maxSpeed, Transmission transmission, Wheel[] wheel,
                     GasTank gasTank, Engine engine, Electrician electrician,
                     Headlights headlight, BigDecimal price, boolean cruiseControl, boolean roof) {
        super(color, maxSpeed, transmission, wheel, gasTank, engine, electrician, headlight, price, cruiseControl);
        this.roof = roof;
    }

    public void toggleRoof() {
        this.roof = !this.roof;
        System.out.println("Крыша " + (roof ? "опущена" : "поднята"));
    }

    public boolean isRoof() {
        return roof;
    }

    public void setRoof(boolean roof) {
        this.roof = roof;
    }
}
