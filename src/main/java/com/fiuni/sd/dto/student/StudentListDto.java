package com.fiuni.sd.dto.student;

import com.fiuni.sd.dto.base.BaseListDto;

import java.util.List;

public class StudentListDto extends BaseListDto<StudentDto> {

    private static final long serialVersionUID = 1L;

    public List<StudentDto> getStudents() {
        return getList();
    }

    public void setStudents(List<StudentDto> dtos) {
        setList(dtos);
    }
}
