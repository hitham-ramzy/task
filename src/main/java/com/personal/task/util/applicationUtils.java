package com.personal.task.util;

import com.personal.task.domain.BillItem;

import java.util.List;

public class applicationUtils {

    public static Double calculateBillPrice(List<BillItem> billItems) {
        return billItems.stream().mapToDouble(billItem -> billItem.getItem().getPrice() * billItem.getAmount()).sum();
    }
}
