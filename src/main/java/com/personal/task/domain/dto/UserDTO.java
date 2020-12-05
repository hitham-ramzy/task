package com.personal.task.domain.dto;

import com.personal.task.domain.UserType;
import lombok.Data;

@Data
public class UserDTO {

    String name;

    String address;

    String mobile;

    String country;

    UserType userType;
}
