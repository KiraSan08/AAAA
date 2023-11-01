package com.fiuni.sd.dto.presencePerMAtter;

import com.fiuni.sd.dto.base.BaseListDto;
import java.util.List;

public class PresencePerMatterListDto extends BaseListDto<PresencePerMatterDto> {

    private static final long serialVersionUID = 1L;

    public List<PresencePerMatterDto> getPresencePerMatters() {
        return getList();
    }

    public void setPresencePerMatters(List<PresencePerMatterDto> dtos) {
        setList(dtos);
    }
}
