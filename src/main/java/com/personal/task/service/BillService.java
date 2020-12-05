package com.personal.task.service;

import com.personal.task.domain.AffiliateDiscount;
import com.personal.task.domain.Bill;
import com.personal.task.domain.BillItem;
import com.personal.task.domain.Discount;
import com.personal.task.domain.EmployeeDiscount;
import com.personal.task.domain.Every100DollarDiscount;
import com.personal.task.domain.Item;
import com.personal.task.domain.User;
import com.personal.task.domain.dto.BillDTO;
import com.personal.task.repository.BillRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
        User user = userService.findById(billDTO.getUserId());
        if (user == null) {
            // TODO :: handle error
            throw new RuntimeException();
        }

        Bill bill = new Bill();
        bill.setCustomer(user);

        List<BillItem> billItems = getBillItems(billDTO);
        bill.setItems(billItems);

        Double priceBeforeDiscount = calculateBillPrice(billItems);
        bill.setPriceBeforeDiscount(priceBeforeDiscount);

        Discount userDiscount = getUserDiscount(user);
        if (userDiscount != null) {
            Double percentageDiscount = userDiscount.calculate(bill.getPriceBeforeDiscount());
            bill.setPercentageDiscount(percentageDiscount);
        }

        Discount amountDiscount = getAmountDiscount(bill.getPriceBeforeDiscount());
        if (amountDiscount != null) {
            Double discount = amountDiscount.calculate(bill.getPriceBeforeDiscount());
            bill.setAmountDiscount(discount);
        }

        bill.setTotalPrice(priceBeforeDiscount - bill.getPercentageDiscount() - bill.getAmountDiscount());
        return billRepository.save(bill);
    }


    private Discount getUserDiscount(User user) {
        switch (user.getUserType()) {
            case EMPLOYEE:
                return new EmployeeDiscount();
            case AFFILIATE:
                return new AffiliateDiscount();
        }
        return null;
    }

    private Discount getAmountDiscount(Double priceBeforeDiscount){
        if (priceBeforeDiscount > 100){
            return new Every100DollarDiscount();
        }
        return null;
    }

    private List<BillItem> getBillItems(BillDTO billDTO) {
        return billDTO.getItems().stream().map(billItemDTO -> {
            Item item = itemService.findById(billItemDTO.getItemId());
            if (item == null) {
                // TODO :: handle error
                throw new RuntimeException();
            }
            BillItem billItem = new BillItem();
            billItem.setAmount(billItemDTO.getAmount());
            billItem.setItem(item);
            return billItem;
        }).collect(Collectors.toList());
    }

    private Double calculateBillPrice(List<BillItem> billItems) {
        return billItems.stream().mapToDouble(billItem -> billItem.getItem().getPrice() * billItem.getAmount()).sum();
    }
}
