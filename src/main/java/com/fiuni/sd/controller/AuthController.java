package com.fiuni.sd.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fiuni.sd.dto.user.UserDto;
import com.fiuni.sd.dto.auth.AuthLoginDto;
import com.fiuni.sd.dto.auth.AuthRegisterDto;

import com.fiuni.sd.service.auth.IAuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private IAuthService authService;

    @PostMapping("/login")
    public ResponseEntity<UserDto> login(@RequestBody AuthLoginDto authLoginDto) {
        return ResponseEntity.ok(authService.login(authLoginDto));
    }

    @PostMapping("/register")
    public ResponseEntity<UserDto> register(@RequestBody AuthRegisterDto authRegisterDto) {
        return ResponseEntity.ok(authService.register(authRegisterDto));
    }
}
