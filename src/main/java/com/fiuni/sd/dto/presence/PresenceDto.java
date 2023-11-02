package com.fiuni.sd.dto.presence;
import java.util.Date;

import com.fiuni.sd.dto.base.BaseDto;
// import com.fiuni.sd.dto.matter.MatterDto;


import lombok.Getter;
import lombok.Setter;

public class PresenceDto extends BaseDto {
    private static final long serialVersionUID = 1L;
    
    @Getter
    @Setter
    private Integer id;
    
    @Getter
    @Setter
    private Integer matterId;

    @Getter
    @Setter
    private Date date;

  }



  