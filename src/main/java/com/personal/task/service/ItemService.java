package com.personal.task.service;

import com.personal.task.domain.Item;
import com.personal.task.repository.ItemRepository;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    ItemRepository itemRepository;

    ItemService(ItemRepository itemRepository){
        this.itemRepository = itemRepository;
    }

    public Item findById(Long id){
        return itemRepository.findById(id).orElse(null);
    }

    public Item save(Item item) {
        return itemRepository.save(item);
    }
}
