package com.fiuni.sd.service.base;

import com.fiuni.sd.dto.base.BaseDto;
import com.fiuni.sd.dto.base.BaseListDto;

import org.springframework.data.domain.Pageable;

public interface IBaseService<DTO extends BaseDto, LIST_DTO extends BaseListDto<DTO>> {

	public LIST_DTO get(final Pageable pageable);
	public DTO getById(final Integer id);
	public DTO create(final DTO dto);
	public DTO update(final Integer id, final DTO dto);
	public DTO delete(final Integer id);

}
