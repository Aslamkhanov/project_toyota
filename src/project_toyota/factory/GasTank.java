package project_toyota.factory;

/**
 * бак
 */
public class GasTank {
    private double fuelAmount; // количество бензина

    public GasTank(double fuelAmount) {
        this.fuelAmount = fuelAmount;
    }

    public double getAmountOfGasoline() {
        return fuelAmount;
    }
    public void setAmountOfGasoline(double fuelAmount) {
        this.fuelAmount = fuelAmount;
    }
}
