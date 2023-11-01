package com.fiuni.sd.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Entity
@Table(name = "studentPerMatter")
public class StudentPerMatterDomain implements BaseDomain{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    @Getter @Setter
    private StudentDomain student;

    @ManyToOne
    @JoinColumn(name = "matter_id", nullable = false)
    @Getter @Setter
    private MatterDomain matter;
}
