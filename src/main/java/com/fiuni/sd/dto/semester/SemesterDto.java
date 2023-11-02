package com.fiuni.sd.dto.semester;

import com.fiuni.sd.dto.base.BaseDto;
import lombok.Getter;
import lombok.Setter;

public class SemesterDto extends BaseDto {
    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    private Integer id;

    @Getter
    @Setter
    private String name;
}
