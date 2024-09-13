package project_toyota.car.car_detail;

/**
 * фары
 */
public class Headlights {
    private boolean headlightsAreWorking = true;//фары работоспособны

    public boolean isHeadlightsAreWorking() {
        return headlightsAreWorking;
    }


    public void setHeadlightsAreWorking(boolean headlightsAreWorking) {
        this.headlightsAreWorking = headlightsAreWorking;
    }
}
