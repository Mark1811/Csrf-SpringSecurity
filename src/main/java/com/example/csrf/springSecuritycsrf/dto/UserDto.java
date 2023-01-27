package com.example.csrf.springSecuritycsrf.dto;

import lombok.*;


@Setter @Getter
@ToString
public class UserDto {

    private String username;

    private String password;

    private String email;

    public UserDto() {
    }

    public UserDto(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }
}
