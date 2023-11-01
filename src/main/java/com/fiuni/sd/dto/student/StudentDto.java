package com.fiuni.sd.dto.student;

import com.fiuni.sd.dto.base.BaseDto;
import lombok.Getter;
import lombok.Setter;

public class StudentDto extends BaseDto {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private Integer userId;

    @Getter @Setter
    private String name;

    @Getter @Setter
    private String ci;

    @Getter @Setter
    private String email;

}
