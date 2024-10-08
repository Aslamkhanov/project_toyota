package project_toyota.project_enum;

public enum WheelDiameter {
    CAMRY(17),
    SOLARA(16),
    TRUCK(20);
    private final int diameter;

    WheelDiameter(int diameter) {
        this.diameter = diameter;
    }

    public int getDiameter() {
        return diameter;
    }
}
