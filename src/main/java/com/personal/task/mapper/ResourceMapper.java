package com.personal.task.mapper;

import com.personal.task.domain.Item;
import com.personal.task.domain.User;
import com.personal.task.domain.dto.ItemDTO;
import com.personal.task.domain.dto.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ResourceMapper {

    ResourceMapper INSTANCE = Mappers.getMapper(ResourceMapper.class);

    User mapToUser(UserDTO userDTO);

    Item mapToItem(ItemDTO itemDTO);
}
