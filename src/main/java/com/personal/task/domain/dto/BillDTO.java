package com.personal.task.domain.dto;

import lombok.Data;

import java.util.List;

@Data
public class BillDTO {

    private List<BillItemDTO> items;

    private Long UserId;
}
