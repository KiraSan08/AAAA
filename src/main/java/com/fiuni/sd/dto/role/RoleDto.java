package com.fiuni.sd.dto.role;

import com.fiuni.sd.dto.base.BaseDto;

import lombok.Getter;
import lombok.Setter;

public class RoleDto extends BaseDto {

    private static final long serialVersionUID = 1L;
    
    @Getter @Setter
    private String roleKey;

    @Getter @Setter
    private String name;

     // Constructor sin argumentos
     public RoleDto() {
    }

    // Constructor
    public RoleDto(Integer id, String roleKey, String name) {
        this.setId(id);
        this.roleKey = roleKey;
        this.name = name;
    }

}
