package com.personal.task.resource;

import com.personal.task.domain.User;
import com.personal.task.domain.dto.UserDTO;
import com.personal.task.mapper.ResourceMapper;
import com.personal.task.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/api")
public class UserResource {

    final UserService userService;

    public UserResource(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/user")
    public ResponseEntity<User> createUser(@RequestBody UserDTO userDTO){
        User user = ResourceMapper.INSTANCE.mapToUser(userDTO);
        return ResponseEntity.ok(userService.save(user));
    }

    @PostMapping("/user-test")
    public ResponseEntity<String> createUser2(@RequestBody String userDTO){
        return ResponseEntity.ok(userDTO);
    }
}
