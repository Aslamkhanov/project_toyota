package project_toyota.car;

import project_toyota.car.car_detail.*;
import project_toyota.project_enum.Transmission;

import java.math.BigDecimal;

public class Dyna extends Truck {
    private Charger charger;
    public Dyna(String color, double maxSpeed, Transmission transmission,
                Wheel[] wheel, GasTank gasTank, Engine engine, Electrician electrician,
                Headlights headlight, BigDecimal price, Charger charger) {
        super(color, maxSpeed, transmission, wheel, gasTank, engine, electrician, headlight, price);
        this.charger = charger;
    }
    public void chargePhone() {
        if (charger.isCarChargePhone()) {
            charger.setCarChargePhone(false);
            System.out.println("Функция - зарядить телефон подключена ");
        } else {
            charger.setCarChargePhone(true);
            System.out.println("Функция - зарядить телефон отключена ");
        }
    }
   // public void chargePhone() {
      //  System.out.println("Функция зарядить телефон ");
   // }
}
