package com.personal.task.domain;

public class Every100DollarDiscount implements PercentageDiscount {

    static final Integer DISCOUNT_PER_N_DOLLARS = 100;
    static final Integer DISCOUNT_AMOUNT = 5;

    @Override
    public Double calculate(Double amount) {
        return (double) ((int) (amount / DISCOUNT_PER_N_DOLLARS) * DISCOUNT_AMOUNT);
    }
}
