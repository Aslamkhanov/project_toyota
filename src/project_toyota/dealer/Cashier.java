package project_toyota.dealer;

import project_toyota.car.Car;

import java.math.BigDecimal;

public class Cashier {
    private BigDecimal totalMoney = BigDecimal.ZERO;

    public void acceptsCarForSale(Car car) {
        if (car == null) {
            this.totalMoney = this.totalMoney.add(BigDecimal.valueOf(0));
        } else {
            this.totalMoney = this.totalMoney.add(car.getPrice());
        }
    }

    public BigDecimal getTotalMoney() {
        return totalMoney;
    }
}
