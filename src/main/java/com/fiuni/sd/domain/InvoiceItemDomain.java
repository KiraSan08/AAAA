package com.fiuni.sd.domain;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "invoice_items")
public class InvoiceItemDomain implements BaseDomain {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    @Column(name = "id", nullable = false, unique = true)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "invoice_id", nullable = false)
    @Getter
    @Setter
    private InvoiceDomain invoice;

    @ManyToOne
    @JoinColumn(name = "service_id", nullable = false)
    @Getter
    @Setter
    private ServiceDomain service;

    @Getter
    @Setter
    @Column(name = "price")
    private Double price;

    @Getter
    @Setter
    @Column(name = "quantity")
    private Double quantity;

}