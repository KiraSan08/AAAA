package com.fiuni.sd.service.role;

import java.util.List;
import java.util.ArrayList;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;

import com.fiuni.sd.dao.IRoleDao;
import com.fiuni.sd.dto.role.RoleDto;
import com.fiuni.sd.dto.role.RoleListDto;
import com.fiuni.sd.exception.ResourceNotFoundException;
import com.fiuni.sd.domain.RoleDomain;
import com.fiuni.sd.service.base.BaseServiceImpl;

@Service
public class RoleServiceImpl extends BaseServiceImpl<RoleDto, RoleDomain, RoleListDto> implements IRoleService {

	@Autowired
	private IRoleDao roleDao;

	@Override
	public RoleListDto get(Pageable pageable) {
		RoleListDto result = new RoleListDto();
		List<RoleDto> list = new ArrayList<>();
		Page<RoleDomain> pages = roleDao.findAll(pageable);
		pages.forEach(role -> {
			RoleDto dto = convertDomainToDto(role);
			list.add(dto);
		});
		result.setRoles(list);
		result.setPage(pages.getNumber());
		result.setTotalPages(pages.getTotalPages());
		result.setTotal((int) roleDao.count());
		result.set_hasPrev(pages.hasPrevious());
		result.set_hasNext(pages.hasNext());
		return result;
	}

	@Override
	public RoleDto getById(Integer id) {
        return roleDao.findById(id).map(this::convertDomainToDto).orElseThrow(() -> new ResourceNotFoundException("Role", "id", id));
	}

    @Override
    public RoleDto create(final RoleDto dto) {
		return convertDomainToDto(roleDao.save(convertDtoToDomain(dto)));
	}

	@Override
    public RoleDto update(Integer id, RoleDto dto) {
        RoleDto currentRole = roleDao.findById(id).map(this::convertDomainToDto).orElseThrow(() -> new ResourceNotFoundException("Role", "id", id));
        RoleDto modifiedRole = new RoleDto();
        modifiedRole.setId(id);
        modifiedRole.setName(dto.getName() == null? currentRole.getName() : dto.getName());
        modifiedRole.setRoleKey(dto.getRoleKey() == null? currentRole.getRoleKey() : dto.getRoleKey());
        return convertDomainToDto(roleDao.save(convertDtoToDomain(modifiedRole)));
    }

    @Override
    public RoleDto delete(Integer id) {
        RoleDto dto = roleDao.findById(id).map(this::convertDomainToDto).orElseThrow(() -> new ResourceNotFoundException("Role", "id", id));
        roleDao.deleteById(id);
        return dto;
    }

    @Override
    protected RoleDto convertDomainToDto(RoleDomain domain) {
        RoleDto dto = new RoleDto();
        dto.setId(domain.getId());
        dto.setName(domain.getName());
        dto.setRoleKey(domain.getRoleKey());
        return dto;
    }

    @Override
    protected RoleDomain convertDtoToDomain(RoleDto dto) {
        RoleDomain domain = new RoleDomain();
        domain.setId(dto.getId());
        domain.setName(dto.getName());
        domain.setRoleKey(dto.getRoleKey());
        return domain;
    }

}
