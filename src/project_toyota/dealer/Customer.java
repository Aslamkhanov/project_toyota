package project_toyota.dealer;

import java.math.BigDecimal;

public class Customer {
    private String name;
    private BigDecimal money;

    public Customer(String name, BigDecimal money) {
        this.name = name;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }
}

