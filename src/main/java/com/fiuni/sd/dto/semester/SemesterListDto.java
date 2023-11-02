package com.fiuni.sd.dto.semester;

import com.fiuni.sd.dto.base.BaseListDto;
import java.util.List;

public class SemesterListDto extends BaseListDto<SemesterDto> {
    private static final long serialVersionUID = 1L;

    public List<SemesterDto> getSemesters() {
        return getList();
    }

    public void setSemesters(List<SemesterDto> dtos) {
        setList(dtos);
    }
}
