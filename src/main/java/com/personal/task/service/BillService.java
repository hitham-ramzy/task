package com.personal.task.service;

import com.personal.task.domain.Bill;
import com.personal.task.domain.BillItem;
import com.personal.task.domain.Discount;
import com.personal.task.domain.Item;
import com.personal.task.domain.User;
import com.personal.task.domain.dto.BillDTO;
import com.personal.task.repository.BillRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.personal.task.service.DiscountStrategyService.getAmountDiscount;
import static com.personal.task.service.DiscountStrategyService.getUserDiscount;
import static com.personal.task.util.ApplicationUtils.calculateBillPrice;

@Service
public class BillService {

    private UserService userService;
    private ItemService itemService;
    private BillRepository billRepository;

    public BillService(UserService userService, ItemService itemService, BillRepository billRepository) {
        this.userService = userService;
        this.itemService = itemService;
        this.billRepository = billRepository;
    }

    public Bill save(BillDTO billDTO) {
        Bill bill = new Bill();

        User user = userService.findById(billDTO.getUserId());
        if (user == null) {
            // TODO :: handle error
            throw new RuntimeException();
        }
        List<BillItem> billItems = getBillItems(bill, billDTO);
        Double priceBeforeDiscount = calculateBillPrice(billItems);

        Double percentageDiscount = 0D;
        Discount userDiscount = getUserDiscount(user);
        if (userDiscount != null) {
            percentageDiscount = userDiscount.calculate(priceBeforeDiscount);
        }

        Double discount = 0D;
        Discount amountDiscount = getAmountDiscount(priceBeforeDiscount);
        if (amountDiscount != null) {
            discount = amountDiscount.calculate(priceBeforeDiscount);
        }

        Double totalPrice = priceBeforeDiscount - percentageDiscount - discount;

        bill.setCustomer(user);
        bill.setItems(billItems);
        bill.setPriceBeforeDiscount(priceBeforeDiscount);
        bill.setPercentageDiscount(percentageDiscount);
        bill.setAmountDiscount(discount);
        bill.setTotalPrice(totalPrice);
        return billRepository.save(bill);
    }

    private List<BillItem> getBillItems(Bill bill, BillDTO billDTO) {
        return billDTO.getItems().stream().map(billItemDTO -> {
            Item item = itemService.findById(billItemDTO.getItemId());
            if (item == null) {
                // TODO :: handle error
                throw new RuntimeException();
            }
            BillItem billItem = new BillItem();
            billItem.setAmount(billItemDTO.getAmount());
            billItem.setItem(item);
            billItem.setBill(bill);
            return billItem;
        }).collect(Collectors.toList());
    }
}
