package project_toyota.car.car_detail;

/**
 * мотор
 */
public class Engine {
    private boolean engineIsOperational = true; // мотор работоспособен

    public boolean isEngineIsOperational() {
        return engineIsOperational;
    }

    public void setEngineIsOperational(boolean engineIsOperational) {
        this.engineIsOperational = engineIsOperational;
    }
}
