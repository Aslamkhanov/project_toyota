package project_toyota.car;

import project_toyota.project_enum.Transmission;
import project_toyota.factory.*;

import java.math.BigDecimal;

public abstract class Truck extends Car {
    private BigDecimal liftingCapacity;

    public Truck(String color, double maxSpeed, Transmission transmission, Wheel[] wheel,
                 GasTank gasTank, Engine engine, Electrician electrician,
                 Headlights headlight, BigDecimal price) {
        super(color, maxSpeed, transmission, wheel, gasTank, engine, electrician, headlight, price);
        this.liftingCapacity = new BigDecimal(3000);
    }

    public void liftingCapacityInfo(){
        System.out.println("Грузоподъемность: " + getLiftingCapacity() + " килограмм");
    }
    public BigDecimal getLiftingCapacity() {
        return liftingCapacity;
    }

    public void setLiftingCapacity(BigDecimal liftingCapacity) {
        this.liftingCapacity = liftingCapacity;
    }
}
