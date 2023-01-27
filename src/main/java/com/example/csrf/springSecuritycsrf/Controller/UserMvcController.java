package com.example.csrf.springSecuritycsrf.Controller;

import com.example.csrf.springSecuritycsrf.dto.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserMvcController {

    @GetMapping("/")
    public String getForm(Model model){
        model.addAttribute("user", new UserDto());
        return "user-form";
    }

    // 2º PASO: RECIBIR EL FORMULARIO CON LOS DATOS RELLENOS
    @PostMapping("/users")
    public String save(@ModelAttribute("user") UserDto user){
        System.out.println(user);
        return "mostrar";
    }
}
