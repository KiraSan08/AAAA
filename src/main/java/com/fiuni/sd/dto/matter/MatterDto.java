package com.fiuni.sd.dto.matter;

import com.fiuni.sd.dto.base.BaseDto;
import com.fiuni.sd.dto.semester.SemesterDto;
import lombok.Getter;
import lombok.Setter;

public class MatterDto extends BaseDto {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private String name;

    
    @Getter
    @Setter
    private Integer id;

    @Getter @Setter
    private SemesterDto semester;

    public MatterDto() {
    }

    public MatterDto(Integer id, String name) {
        this.setId(id);
        this.name = name;
        // this.semester = semester;
        
    }
}
