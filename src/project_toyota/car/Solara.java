package project_toyota.car;

import project_toyota.car.car_detail.*;
import project_toyota.project_enum.Country;
import project_toyota.project_enum.Transmission;
import project_toyota.report_guide.ModelGuide;

import java.math.BigDecimal;

public class Solara extends Cabriolet {

    public Solara(ModelGuide modelGuide, Country country, String color, double maxSpeed, Transmission transmission, Wheel[] wheel,
                  GasTank gasTank, Engine engine, Electrician electrician, Headlights headlight,
                  BigDecimal price, boolean cruiseControl, Roof roof) {
        super(modelGuide, country, color, maxSpeed, transmission, wheel, gasTank, engine, electrician, headlight,
                price, cruiseControl, roof);
    }

    public void miniRefrigerator() {
        System.out.println("функция охладить напиток ");
    }
}
