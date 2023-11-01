package com.fiuni.sd.dto.user;

import java.util.List;
import com.fiuni.sd.dto.base.BaseListDto;

public class UserListDto extends BaseListDto<UserDto> {

	private static final long serialVersionUID = 1L;
	
	public List<UserDto> getUsers() {
		return getList();
	}

	public void setUsers(List<UserDto> dtos) {
		setList(dtos);
	}

}