package com.fiuni.sd.dto.sale_point;

import com.fiuni.sd.dto.base.BaseListDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SalePointListDto extends BaseListDto<SalePointDto> {

    private static final long serialVersionUID = 1L;

    private List<SalePointDto> salePoints;
}
