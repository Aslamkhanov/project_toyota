package project_toyota.factory;

/**
 * фары
 */
public class Headlights {
    private boolean headlightsAreWorking;//фары работоспособны

    public Headlights() {
        this.headlightsAreWorking = true;
    }

    public boolean isHeadlightsAreWorking() {
        return headlightsAreWorking;
    }


    public void setHeadlightsAreWorking(boolean headlightsAreWorking) {
        this.headlightsAreWorking = headlightsAreWorking;
    }
}
