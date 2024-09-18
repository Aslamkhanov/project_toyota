package project_toyota.report_guide;

import java.math.BigDecimal;

public enum ModelGuide {
    CAMRY(BigDecimal.valueOf(5000)),
    SOLARA(BigDecimal.valueOf(8000)),
    HIANCE(BigDecimal.valueOf(10_000)),
    DYNA(BigDecimal.valueOf(12_000));

    private BigDecimal costPriceCar;

    ModelGuide(BigDecimal costPriceCar) {
        this.costPriceCar = costPriceCar;
    }

    public BigDecimal getCostPriceCar() {
        return costPriceCar;
    }
}
