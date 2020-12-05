package com.personal.task.domain;

public class EmployeeDiscount implements PercentageDiscount {

    static final Integer PERCENTAGE = 30;

    @Override
    public Double calculate(Double amount) {
        return amount * PERCENTAGE / 100;
    }
}
