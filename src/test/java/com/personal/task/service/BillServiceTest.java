package com.personal.task.service;


import com.personal.task.domain.Bill;
import com.personal.task.domain.Item;
import com.personal.task.domain.User;
import com.personal.task.domain.UserType;
import com.personal.task.repository.BillRepository;
import com.personal.task.service.util.TestUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BillServiceTest {

    @Mock
    private UserService userService;

    @Mock
    private ItemService itemService;

    @Mock
    private BillRepository billRepository;

    @InjectMocks
    private BillService testee;


    @Test
    public void saveBill_bestCase() {
        User user = TestUtils.buildUser(1L, UserType.NORMAL);
        when(userService.findById(any(Long.class))).thenReturn(user);

        Item item = TestUtils.buildItem(20L, 10D);
        when(itemService.findById(any(Long.class))).thenReturn(item);

        Bill bill = testee.save(TestUtils.buildBillDTO());
        verify(billRepository, times(1)).save(any(Bill.class));
    }

    @Test(expected = RuntimeException.class)
    public void saveBill_notFoundUser() {
        when(userService.findById(any(Long.class))).thenReturn(null);
        testee.save(TestUtils.buildBillDTO());
        verify(billRepository, never()).save(any(Bill.class));
    }

    @Test(expected = RuntimeException.class)
    public void saveBill_notFoundItem() {
        User user = TestUtils.buildUser(1L, UserType.NORMAL);
        when(userService.findById(any(Long.class))).thenReturn(user);

        when(itemService.findById(any(Long.class))).thenReturn(null);
        testee.save(TestUtils.buildBillDTO());
        verify(billRepository, never()).save(any(Bill.class));
    }


}
