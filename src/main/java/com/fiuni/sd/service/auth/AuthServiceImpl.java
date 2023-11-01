package com.fiuni.sd.service.auth;

import com.fiuni.sd.dao.IRoleDao;
import com.fiuni.sd.dao.IUserDao;
import com.fiuni.sd.dto.role.RoleDto;
import com.fiuni.sd.dto.user.UserDto;
import com.fiuni.sd.exception.ResourceNotFoundException;
import com.fiuni.sd.domain.RoleDomain;
import com.fiuni.sd.domain.UserDomain;
import com.fiuni.sd.dto.auth.AuthLoginDto;
import com.fiuni.sd.dto.auth.AuthRegisterDto;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class AuthServiceImpl implements IAuthService {

    @Autowired
    private IUserDao userDao;

    @Autowired
    private IRoleDao roleDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDto register(AuthRegisterDto authRegisterDto) {
        // Buscar el rol en la base de datos
        RoleDomain role = roleDao.findByRoleKey(authRegisterDto.getRoleKey())
                    .orElseThrow(() -> new RuntimeException("Role not found"));
    
        // Crear un nuevo usuario
        UserDomain newUser = new UserDomain();
        newUser.setEmail(authRegisterDto.getEmail());
        newUser.setPassword(passwordEncoder.encode(authRegisterDto.getPassword()));
        newUser.setRole(role);
    
        // Guardar el usuario en la base de datos
        userDao.save(newUser);
    
        // Convertir el usuario a UserDto
        UserDto userDto = new UserDto();
        userDto.setId(newUser.getId());
        userDto.setEmail(newUser.getEmail());
        userDto.setRole(new RoleDto(role.getId(), role.getRoleKey(), role.getName()));
    
        return userDto;
    }

    @Override
    public UserDto login(AuthLoginDto authLoginDto) {
        // Buscar el usuario por su email
        UserDomain userDomain = userDao.findByEmail(authLoginDto.getEmail());
        if (userDomain != null && BCrypt.checkpw(authLoginDto.getPassword(), userDomain.getPassword())) {
            UserDto userDto = new UserDto();
            userDto.setId(userDomain.getId());
            userDto.setEmail(userDomain.getEmail());
            userDto.setRole(new RoleDto(userDomain.getRole().getId(), userDomain.getRole().getRoleKey(), userDomain.getRole().getName()));
            return userDto;
        } else {
            throw new ResourceNotFoundException("User", "email", authLoginDto.getEmail());
        }
    }

};
