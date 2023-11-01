package com.fiuni.sd.dto.presence;

import com.fiuni.sd.dto.base.BaseListDto;
import java.util.List;

public class PresenceListDto extends BaseListDto<PresenceDto> {

    private static final long serialVersionUID = 1L;

    public List<PresenceDto> getPresences() {
        return getList();
    }

    public void setPresences(List<PresenceDto> dtos) {
        setList(dtos);
    }
}
