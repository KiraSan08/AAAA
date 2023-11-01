package com.fiuni.sd.domain;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "invoices")
public class InvoiceDomain implements BaseDomain {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter @Column(name = "id", nullable = false, unique = true)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    @Getter @Setter
    private StudentDomain student; // No necesitas @Column aquí

    @Getter @Setter @Column(name = "number")
    private String number;

    @Getter @Setter @Column(name = "stamp_number")
    private String stampNumber;

    @Getter @Setter @Column(name = "status")
    private String status;

    @Getter @Setter @Column(name = "due_date")
    private Date dueDate;

    @Getter @Setter @Column(name = "total")
    private Double total;
}
