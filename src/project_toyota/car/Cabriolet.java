package project_toyota.car;

import project_toyota.car.car_detail.*;
import project_toyota.car_exception.StartCarException;
import project_toyota.project_enum.Country;
import project_toyota.project_enum.Transmission;
import project_toyota.report_guide.ModelGuide;

import java.math.BigDecimal;

public class Cabriolet extends LightCar {
    protected Roof roof;

    public Cabriolet(ModelGuide modelGuide, Country country, String color, double maxSpeed,
                     Transmission transmission, Wheel[] wheel, GasTank gasTank, Engine engine, Electrician electrician,
                     Headlights headlight, BigDecimal price, boolean cruiseControl, Roof roof) {
        super(modelGuide, country, color, maxSpeed, transmission, wheel, gasTank, engine,
                electrician, headlight, price, cruiseControl);
        this.roof = roof;
    }
    public void toggleRoof() {
        if (roof.isToggleRoof()) {
            roof.setToggleRoof(false);
            System.out.println("Крыша опущена ");
        } else {
            roof.setToggleRoof(true);
            System.out.println("Крыша поднята ");
        }
    }

//    public void toggleRoof() {
//        this.roof.isToggleRoof() = !this.roof.isToggleRoof();
//        System.out.println("Крыша " + (roof.isToggleRoof() ? "опущена" : "поднята"));
//    }

    public Roof getRoof() {
        return roof;
    }

    public void setRoof(Roof roof) {
        this.roof = roof;
    }
}
