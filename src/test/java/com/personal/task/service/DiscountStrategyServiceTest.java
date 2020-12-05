package com.personal.task.service;

import com.personal.task.domain.AffiliateDiscount;
import com.personal.task.domain.Discount;
import com.personal.task.domain.EmployeeDiscount;
import com.personal.task.domain.Every100DollarDiscount;
import com.personal.task.domain.OldUserDiscount;
import com.personal.task.domain.User;
import com.personal.task.domain.UserType;
import com.personal.task.util.TestUtils;
import org.junit.Test;

import java.time.ZonedDateTime;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class DiscountStrategyServiceTest {

    @Test
    public void getUserDiscount_employee(){
        Discount discount = DiscountStrategyService.getUserDiscount(TestUtils.buildUser(1L, UserType.EMPLOYEE));
        assertTrue(discount instanceof EmployeeDiscount);
    }

    @Test
    public void getUserDiscount_affiliate(){
        Discount discount = DiscountStrategyService.getUserDiscount(TestUtils.buildUser(1L, UserType.AFFILIATE));
        assertTrue(discount instanceof AffiliateDiscount);
    }

    @Test
    public void getUserDiscount_normal(){
        Discount discount = DiscountStrategyService.getUserDiscount(TestUtils.buildUser(1L, UserType.NORMAL));
        assertNull(discount);
    }

    @Test
    public void getUserDiscount_OldUser(){
        User user = TestUtils.buildUser(1L, UserType.NORMAL);
        user.setJoinedAt(ZonedDateTime.now().minusYears(3));
        Discount discount = DiscountStrategyService.getUserDiscount(user);
        assertTrue(discount instanceof OldUserDiscount);
    }

    @Test
    public void getAmountDiscount_lessThan100(){
        Discount discount = DiscountStrategyService.getAmountDiscount(10D);
        assertNull(discount);
    }

    @Test
    public void getAmountDiscount_moreThan100(){
        Discount discount = DiscountStrategyService.getAmountDiscount(1000D);
        assertTrue(discount instanceof Every100DollarDiscount);
    }
}
