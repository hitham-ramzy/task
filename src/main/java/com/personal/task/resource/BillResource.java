package com.personal.task.resource;

import com.personal.task.domain.dto.BillDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class BillResource {

    @PostMapping("/calculate")
    public ResponseEntity calculate(@RequestBody BillDTO billDTO){
        return ResponseEntity.ok("{}");
    }

}
