package com.personal.task.domain;

public class AffiliateDiscount implements PercentageDiscount {

    static final Integer PERCENTAGE = 10;

    @Override
    public Double calculate(Double amount) {
        return amount * PERCENTAGE / 100;
    }
}
