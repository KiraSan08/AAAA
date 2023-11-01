package com.fiuni.sd.domain;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "sale_points", uniqueConstraints = {
        @UniqueConstraint(columnNames = { "prefix", "establishment_number" })
})
public class SalePointDomain implements BaseDomain {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter @Column(name = "id", nullable = false, unique = true)
    private Integer id;

    @Getter @Setter @Column(name = "invoice_stamp_number", nullable = false, unique = true)
    private String invoiceStampNumber;

    @Getter @Setter @Column(name = "invoice_stamp_init_date", nullable = false)
    private Date invoiceStampInitDate;

    @Getter @Setter @Column(name = "invoice_stamp_due_date", nullable = false)
    private Date invoiceStampDueDate;

    @Getter @Setter @Column(name = "last_invoice_number", nullable = false)
    private Integer lastInvoiceNumber;

    @Getter @Setter @Column(name = "prefix", nullable = false)
    private String prefix;

    @Getter @Setter @Column(name = "establishment_number", nullable = false)
    private String establishmentNumber;

}
