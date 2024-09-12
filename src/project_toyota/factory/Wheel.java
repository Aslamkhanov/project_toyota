package project_toyota.factory;

/**
 * колесо
 */
public class Wheel {
    private boolean pierced;
    private int diameter;

    public Wheel(int diameter) {
        this.diameter = diameter;
        this.pierced = false;
    }

    public boolean isPierced() {
        return pierced;
    }

    public int getDiameter() {
        return diameter;
    }

    public void setPierced(boolean pierced) {
        this.pierced = pierced;
    }
}
