package com.personal.task.domain;

public class OldUserDiscount implements PercentageDiscount {

    static final Integer PERCENTAGE = 5;

    @Override
    public Double calculate(Double amount) {
        return amount * PERCENTAGE / 100;
    }
}
