package project_toyota.car.car_detail;

/**
 * бак
 */
public class GasTank {
    private double fuelAmount; // количество бензина

    public GasTank() {
        this.fuelAmount = 0;
    }

    public double getAmountOfGasoline() {
        return fuelAmount;
    }

    public void setAmountOfGasoline(double fuelAmount) {
        this.fuelAmount = fuelAmount;
    }
}
