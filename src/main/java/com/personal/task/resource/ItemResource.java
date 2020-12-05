package com.personal.task.resource;

import com.personal.task.domain.Item;
import com.personal.task.domain.dto.ItemDTO;
import com.personal.task.mapper.ResourceMapper;
import com.personal.task.service.ItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController("/api")
public class ItemResource {

    private ItemService itemService;

    ItemResource(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping("/item")
    public ResponseEntity<Item> saveItem(@Valid @RequestBody ItemDTO itemDTO) {
        Item item = ResourceMapper.INSTANCE.mapToItem(itemDTO);
        return ResponseEntity.ok(itemService.save(item));
    }
}
