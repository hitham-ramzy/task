package com.personal.task.util;

import com.personal.task.domain.BillItem;

import java.util.List;

public class ApplicationUtils {

    public static final Integer DISCOUNT_NUMBER_OF_YEARS = 2;

    public static Double calculateBillPrice(List<BillItem> billItems) {
        return billItems.stream().mapToDouble(billItem -> billItem.getItem().getPrice() * billItem.getAmount()).sum();
    }
}
