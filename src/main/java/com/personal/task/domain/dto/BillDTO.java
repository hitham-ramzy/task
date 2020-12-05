package com.personal.task.domain.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class BillDTO {

    private List<BillItemDTO> items = new ArrayList<>();

    private Long UserId;
}
