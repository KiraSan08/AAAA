package com.fiuni.sd.service.base;

import com.fiuni.sd.dto.base.BaseDto;
import com.fiuni.sd.domain.BaseDomain;
import com.fiuni.sd.dto.base.BaseListDto;

public abstract class BaseServiceImpl<DTO extends BaseDto, DOMAIN extends BaseDomain, LIST_DTO extends BaseListDto<DTO>> implements IBaseService<DTO, LIST_DTO> {

	public abstract DTO convertDomainToDto(final DOMAIN domain);
	public abstract DOMAIN convertDtoToDomain(final DTO dto);
    
}
