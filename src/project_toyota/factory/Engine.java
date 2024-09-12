package project_toyota.factory;

/**
 * мотор
 */
public class Engine {
    private boolean engineIsOperational; // мотор работоспособен

    public Engine( ) {
        this.engineIsOperational = true;
    }

    public boolean isEngineIsOperational() {
        return engineIsOperational;
    }

    public void setEngineIsOperational(boolean engineIsOperational) {
        this.engineIsOperational = engineIsOperational;
    }
}
