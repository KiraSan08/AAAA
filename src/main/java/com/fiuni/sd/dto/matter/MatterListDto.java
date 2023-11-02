package com.fiuni.sd.dto.matter;

import java.util.List;
import com.fiuni.sd.dto.base.BaseListDto;

public class MatterListDto extends BaseListDto<MatterDto> {
    
    private static final long serialVersionUID = 1L;
    
    public List<MatterDto> getMatters() {
        return getList();
    }
    
    public void setMatters(List<MatterDto> dtos) {
        setList(dtos);
    }
}
