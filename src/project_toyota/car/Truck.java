package project_toyota.car;

import project_toyota.car.car_detail.*;
import project_toyota.project_enum.CarTyp;
import project_toyota.project_enum.Country;
import project_toyota.project_enum.Transmission;
import project_toyota.report_guide.ModelGuide;

import java.math.BigDecimal;

public abstract class Truck extends Car {
    private int liftingCapacity;

    public Truck(CarTyp carTyp, ModelGuide modelGuide, Country country, String color, double maxSpeed,
                 Transmission transmission, Wheel[] wheel, GasTank gasTank, Engine engine, Electrician electrician,
                 Headlights headlight, BigDecimal price) {
        super(carTyp, modelGuide, country, color, maxSpeed, transmission, wheel, gasTank, engine,
                electrician, headlight, price);
        this.liftingCapacity = 3000;
    }

    public void liftingCapacityInfo(){
        System.out.println("Грузоподъемность: " + getLiftingCapacity() + " килограмм");
    }
    public int getLiftingCapacity() {
        return liftingCapacity;
    }

    public void setLiftingCapacity(int liftingCapacity) {
        this.liftingCapacity = liftingCapacity;
    }
}
