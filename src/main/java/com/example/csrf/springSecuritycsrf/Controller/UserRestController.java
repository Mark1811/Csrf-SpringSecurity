package com.example.csrf.springSecuritycsrf.Controller;

import com.example.csrf.springSecuritycsrf.dto.UserDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRestController {

    @GetMapping("api/hola")
    public String hola() {
        return "hola mundo";
    }

    @PostMapping("api/users")
    public String save(@RequestBody UserDto user) {
        System.out.println(user);
        return "ok";
    }
}
