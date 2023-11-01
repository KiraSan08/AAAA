package com.fiuni.sd.dto.role;

import java.util.List;
import com.fiuni.sd.dto.base.BaseListDto;

public class RoleListDto extends BaseListDto<RoleDto> {

	private static final long serialVersionUID = 1L;
	
	public List<RoleDto> getRoles() {
		return getList();
	}

	public void setRoles(List<RoleDto> dtos) {
		setList(dtos);
	}

}