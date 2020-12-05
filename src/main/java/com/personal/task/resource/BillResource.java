package com.personal.task.resource;

import com.personal.task.domain.Bill;
import com.personal.task.domain.dto.BillDTO;
import com.personal.task.service.BillService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class BillResource {

    private BillService billService;

    BillResource(BillService billService) {
        this.billService = billService;
    }

    @PostMapping("/calculate")
    public ResponseEntity<Bill> calculate(@RequestBody BillDTO billDTO) {
        Bill bill = billService.save(billDTO);
        return ResponseEntity.ok(bill);
    }

}
