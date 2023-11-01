package com.fiuni.sd.dto.presence;
import com.fiuni.sd.dto.base.BaseDto;
import com.fiuni.sd.dto.student.StudentDto;

import lombok.Getter;
import lombok.Setter;

public class PresenceDto extends BaseDto {
    private static final long serialVersionUID = 1L;
    
    @Getter
    @Setter
    private Integer id;
    
    @Getter
    @Setter
    private Integer presenceId;

    @Getter
    @Setter
    private String attendanceDate;

    @Getter
    @Setter
    private Boolean isPresent;

    @Getter
    @Setter
    private String notes;

    @Getter
    @Setter
    private StudentDto student; // Agregamos la propiedad student para mapear la relación con StudentDto

    @Getter
    @Setter
    private Integer studentId;
    
  }

  // @Getter
    // @Setter
    // private MatterDto matter;

    // Otros campos relacionados con la asistencia, como el estado (presente, ausente, etc.)




  