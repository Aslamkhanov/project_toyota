package project_toyota.car.car_detail;

/**
 * электрика
 */
public class Electrician {
    private boolean electricalWorkable = true; // электрика работоспособна

    public boolean isElectricalWorkable() {
        return electricalWorkable;
    }

    public void setElectricalWorkable(boolean electricalWorkable) {
        this.electricalWorkable = electricalWorkable;
    }
}
