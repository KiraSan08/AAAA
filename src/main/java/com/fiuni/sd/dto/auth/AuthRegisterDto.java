package com.fiuni.sd.dto.auth;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthRegisterDto {

    private String email;
    private String password;
    private String roleKey;

}
