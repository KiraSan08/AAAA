package com.fiuni.sd.dto.sale_point;

import com.fiuni.sd.dto.base.BaseDto;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
public class SalePointDto extends BaseDto {

    private static final long serialVersionUID = 1L;

    private String invoiceStampNumber;
    private Date invoiceStampInitDate;
    private Date invoiceStampDueDate;
    private Integer lastInvoiceNumber;
    private String prefix;
    private String establishmentNumber;
}
