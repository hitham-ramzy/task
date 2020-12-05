package com.personal.task.mapper;

import com.personal.task.domain.User;
import com.personal.task.domain.dto.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ResourceMapper {

    ResourceMapper INSTANCE = Mappers.getMapper(ResourceMapper.class);
    public User mapToUser(UserDTO userDTO);
}
