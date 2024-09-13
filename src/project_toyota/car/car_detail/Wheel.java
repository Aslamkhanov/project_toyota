package project_toyota.car.car_detail;

/**
 * колесо
 */
public class Wheel {
    private boolean pierced;
    private int diameter;

    public Wheel(int diameter) {
        this.diameter = diameter;
    }

    @Override
    public String toString() {
        return "Wheel{" +
                "pierced=" + pierced +
                ", diameter=" + diameter +
                '}';
    }

    public boolean isPierced() {
        return pierced;
    }

    public void setPierced(boolean pierced) {
        this.pierced = pierced;
    }

    public int getDiameter() {
        return diameter;
    }
}
