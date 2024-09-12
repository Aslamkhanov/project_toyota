package project_toyota.factory;

import project_toyota.project_enum.Country;

public class PartsFactory {
    private Country country;

    public PartsFactory(Country country) {
        this.country = country;
    }

    public Country getCountry() {
        return country;
    }
    public Wheel createWheel(int diameter) {
        return new Wheel(diameter);
    }
    public GasTank createGasTank() {
        return new GasTank(0);
    }
    public Engine createEngine() {
        return new Engine();
    }
    public Electrician createElectrician() {
        return new Electrician();
    }
    public Headlights creteHeadlights(){
        return new Headlights();
    }
}
