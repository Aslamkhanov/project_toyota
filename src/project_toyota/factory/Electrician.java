package project_toyota.factory;

/**
 * электрика
 */
public class Electrician {
    private boolean electricalWorkable; // электрика работоспособна

    public Electrician() {
        this.electricalWorkable = true;
    }

    public boolean isElectricalWorkable() {
        return electricalWorkable;
    }

    public void setElectricalWorkable(boolean electricalWorkable) {
        this.electricalWorkable = electricalWorkable;
    }
}
