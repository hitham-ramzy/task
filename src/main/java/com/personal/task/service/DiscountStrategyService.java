package com.personal.task.service;

import com.personal.task.domain.AffiliateDiscount;
import com.personal.task.domain.Discount;
import com.personal.task.domain.EmployeeDiscount;
import com.personal.task.domain.Every100DollarDiscount;
import com.personal.task.domain.User;

public class DiscountStrategyService {

    public static Discount getUserDiscount(User user) {
        switch (user.getUserType()) {
            case EMPLOYEE:
                return new EmployeeDiscount();
            case AFFILIATE:
                return new AffiliateDiscount();
        }
        return null;
    }

    public static Discount getAmountDiscount(Double priceBeforeDiscount){
        if (priceBeforeDiscount > 100){
            return new Every100DollarDiscount();
        }
        return null;
    }
}
