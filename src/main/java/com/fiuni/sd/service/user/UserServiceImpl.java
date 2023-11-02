package com.fiuni.sd.service.user;

import java.util.List;
import java.util.ArrayList;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;

import com.fiuni.sd.dao.IUserDao;
import com.fiuni.sd.dto.role.RoleDto;
import com.fiuni.sd.dto.user.UserDto;
import com.fiuni.sd.domain.RoleDomain;
import com.fiuni.sd.domain.UserDomain;
import com.fiuni.sd.dto.user.UserListDto;
import com.fiuni.sd.exception.ResourceNotFoundException;
import com.fiuni.sd.service.base.BaseServiceImpl;

@Service
public class UserServiceImpl extends BaseServiceImpl<UserDto, UserDomain, UserListDto> implements IUserService {

	@Autowired
	private IUserDao userDao;

	@Override
	public UserListDto get(Pageable pageable) {
		UserListDto result = new UserListDto();
		List<UserDto> list = new ArrayList<>();
		Page<UserDomain> pages = userDao.findAll(pageable);
		pages.forEach(user -> {
			UserDto dto = convertDomainToDto(user);
			list.add(dto);
		});
		result.setUsers(list);
		result.setPage(pages.getNumber());
		result.setTotalPages(pages.getTotalPages());
		result.setTotal((int) userDao.count());
		result.set_hasPrev(pages.hasPrevious());
		result.set_hasNext(pages.hasNext());
		return result;
	}

	@Override
	public UserDto getById(Integer id) {
        return userDao.findById(id).map(this::convertDomainToDto).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
	}

    @Override
    public UserDto create(final UserDto dto) {
		return convertDomainToDto(userDao.save(convertDtoToDomain(dto)));
	}

	@Override
	public UserDto update(Integer id, UserDto dto) {
		UserDto currentUser = userDao.findById(id).map(this::convertDomainToDto).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
        UserDto modifiedUser = new UserDto();
        modifiedUser.setId(id);
        modifiedUser.setEmail(dto.getEmail() == null? currentUser.getEmail() : dto.getEmail() );
        return convertDomainToDto(userDao.save(convertDtoToDomain(modifiedUser)));
	}

    @Override
    public UserDto delete(Integer id) {
        UserDto dto = userDao.findById(id).map(this::convertDomainToDto).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
        userDao.deleteById(id);
        return dto;
    }

    @Override
    public UserDto convertDomainToDto(UserDomain domain) {
        UserDto dto = new UserDto();
        dto.setId(domain.getId());
        dto.setEmail(domain.getEmail());
        dto.setRole(new RoleDto(domain.getRole().getId(), domain.getRole().getRoleKey(), domain.getRole().getName()));
        return dto;
    }

    @Override
    public UserDomain convertDtoToDomain(UserDto dto) {
        UserDomain domain = new UserDomain();
        domain.setId(dto.getId());
        domain.setEmail(dto.getEmail());
        if (dto.getRole() != null) {
            RoleDomain roleDomain = new RoleDomain();
            roleDomain.setId(dto.getRole().getId());
            roleDomain.setName(dto.getRole().getName());
            domain.setRole(roleDomain);
        }
        return domain;
    }

}