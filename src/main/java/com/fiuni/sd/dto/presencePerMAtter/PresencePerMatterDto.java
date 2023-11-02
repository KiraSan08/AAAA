package com.fiuni.sd.dto.presencePerMAtter;
import com.fiuni.sd.dto.base.BaseDto;
import lombok.Getter;
import lombok.Setter;

public class PresencePerMatterDto extends BaseDto {
    private static final long serialVersionUID = 1L;
    
    @Getter
    @Setter
    private Integer id;
    
    @Getter
    @Setter
    private Integer presenceId;


    @Getter
    @Setter
    private Boolean isPresent;

    @Getter
    @Setter
    private String notes;


    @Getter
    @Setter
    private Integer studentId;
    


    
  }



  
