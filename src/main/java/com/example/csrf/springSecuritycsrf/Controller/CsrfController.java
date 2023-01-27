package com.example.csrf.springSecuritycsrf.Controller;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CsrfController {

    //Retorna el token CSRF
    @GetMapping("/csrf")
    public CsrfToken getCsrfToken(CsrfToken token) {
        System.out.println(token.getToken());
        return token;
    }
}
