package project_toyota.project_enum;

import java.math.BigDecimal;

public enum CarPrice {
    CAMRY(BigDecimal.valueOf(10_000)),
    SOLARA(BigDecimal.valueOf(12_000)),
    HIANCE(BigDecimal.valueOf(15_000)),
    DYNA(BigDecimal.valueOf(22_000));
    private BigDecimal priceCar;

    CarPrice(BigDecimal priceCar) {
        this.priceCar = priceCar;
    }

    public BigDecimal getPriceCar() {
        return priceCar;
    }

    public void setPriceCar(BigDecimal priceCar) {
        this.priceCar = priceCar;
    }
}
