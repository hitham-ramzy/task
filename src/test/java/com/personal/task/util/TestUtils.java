package com.personal.task.util;

import com.personal.task.domain.Item;
import com.personal.task.domain.User;
import com.personal.task.domain.UserType;
import com.personal.task.domain.dto.BillDTO;
import com.personal.task.domain.dto.BillItemDTO;
import com.personal.task.domain.dto.ItemDTO;

public class TestUtils {

    public static BillDTO buildBillDTO(){
        BillDTO billDTO = new BillDTO();
        billDTO.setUserId(1L);

        for (int i = 1; i < 4; i++) {
            billDTO.getItems().add(buildBillItemDTO((long) i, i));
        }
        return billDTO;
    }

    public static User buildUser(Long id, UserType userType){
        User user = new User();
        user.setId(id);
        user.setUserType(userType);
        return user;
    }

    public static Item buildItem(Long id, Double price){
        Item item = new Item();
        item.setId(id);
        item.setPrice(price);
        return item;
    }

    public static ItemDTO buildItemDTO(String name, Double price){
        ItemDTO item = new ItemDTO();
        item.setName(name);
        item.setPrice(price);
        return item;
    }

    public static BillItemDTO buildBillItemDTO(Long itemId, Integer amount){
        BillItemDTO billItemDTO = new BillItemDTO();
        billItemDTO.setItemId(itemId);
        billItemDTO.setAmount(amount);
        return billItemDTO;
    }
}
