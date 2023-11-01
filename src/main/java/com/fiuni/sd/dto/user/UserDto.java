package com.fiuni.sd.dto.user;

import lombok.Getter;
import lombok.Setter;
import com.fiuni.sd.dto.base.BaseDto;
import com.fiuni.sd.dto.role.RoleDto;

public class UserDto extends BaseDto {

	private static final long serialVersionUID = 1L;

    @Getter @Setter
	private String email;

    @Getter @Setter
    private RoleDto role;
	
}