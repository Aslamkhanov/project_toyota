package project_toyota.car;

import project_toyota.car.car_detail.*;
import project_toyota.project_enum.Transmission;
import project_toyota.car_exception.StartCarException;

import java.math.BigDecimal;

public abstract class Car {
    protected String color;
    protected double maxSpeed;
    protected Transmission transmission;
    protected boolean stateOfMotion;
    protected Wheel[] wheel;
    protected GasTank gasTank;
    protected Engine engine;
    protected Electrician electrician;
    protected Headlights headlight;
    protected BigDecimal price;

    public Car(String color, double maxSpeed, Transmission transmission,
               Wheel[] wheel, GasTank gasTank, Engine engine, Electrician electrician,
               Headlights headlight, BigDecimal price) {
        this.color = color;
        this.maxSpeed = maxSpeed;
        this.transmission = transmission;
        this.wheel = wheel;
        this.gasTank = gasTank;
        this.engine = engine;
        this.electrician = electrician;
        this.headlight = headlight;
        this.price = price;
    }

    public void wheelReplacement(Wheel newWheel) {
        for (int i = 0; i < wheel.length; i++) {
            if (wheel[i].getDiameter() == newWheel.getDiameter()) {
                if (wheel[i] == null) {
                    wheel[i] = newWheel;
                    System.out.println("На место отсутствующего колеса " + wheel[i]
                            + "поставили новое колесо " + newWheel);
                } else if (wheel[i].isPierced()) {
                    wheel[i] = newWheel;
                    System.out.println(wheel[i] + "Проколотое колесо заменено на: " + newWheel);
                }
            }else {
                System.out.println("Замена колеса не требуется: все колеса на месте и целые ");
            }
        }
    }

    protected boolean presenceOfWheels() throws StartCarException {
        // проверяет все ли колеса на месте.
        for (int i = 0; i < wheel.length; i++) {
            if (wheel[i] == null) {
                throw new StartCarException("Нет колеса на позиции: " + i);
            }
        }
        return true;
    }

    protected boolean checkWheels() throws StartCarException {
        // проверяет есть ли проколотое колесо
        for (int i = 0; i < wheel.length; i++) {
            if (wheel[i].isPierced()) {
                throw new StartCarException("Колесо проколото на позиции: " + i);
            }
        }
        return true;
    }

    protected boolean amountOfFuel() throws StartCarException {
        if (gasTank.getAmountOfGasoline() <= 0) {
            throw new StartCarException("Количество бензина в баке: 0 ");
        }
        return true;
    }

    protected boolean checkElectrician() throws StartCarException {
        if (!electrician.isElectricalWorkable()) {
            throw new StartCarException("Электрика неисправна ");
        }
        return true;
    }

    protected boolean checkEngine() throws StartCarException {
        if (!engine.isEngineIsOperational()) {
            throw new StartCarException("Мотор троит ");
        }
        return true;
    }

    // старт
    public void startMoving() throws StartCarException {
        try {
            if (presenceOfWheels() && checkWheels() && amountOfFuel() && checkElectrician() && checkEngine()) {
                this.stateOfMotion = true;
                System.out.println("Автомобиль успешно запущен и движется.");
            }
        } catch (StartCarException e) {
            System.out.println("Не удалось начать движение: " + e.getMessage());
        }
    }

    // stop
    public void stopTheMotion() {
        this.stateOfMotion = false;
        System.out.println("Автомобиль заглушен ");
    }

    // включает фары
    public void useHeadlights() {
        if (headlight.isHeadlightsAreWorking()) {
            System.out.println("Фары работают");
        } else {
            System.out.println("Фары не работают");
        }
    }

    public Wheel[] getWheel() {
        return wheel;
    }

    public void setWheel(Wheel[] wheel) {
        this.wheel = wheel;
    }

    public GasTank getGasTank() {
        return gasTank;
    }

    public void setGasTank(double gasTank) {
        this.gasTank.setAmountOfGasoline(gasTank);
    }

}
