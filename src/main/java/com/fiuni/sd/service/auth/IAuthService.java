package com.fiuni.sd.service.auth;

import com.fiuni.sd.dto.user.UserDto;
import com.fiuni.sd.dto.auth.AuthLoginDto;
import com.fiuni.sd.dto.auth.AuthRegisterDto;

public interface IAuthService {
    UserDto register(AuthRegisterDto authRegisterDto);
    UserDto login(AuthLoginDto authLoginDto);
}
