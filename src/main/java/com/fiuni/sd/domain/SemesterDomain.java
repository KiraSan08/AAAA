package com.fiuni.sd.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "semesters")
public class SemesterDomain implements BaseDomain{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Getter @Setter @Column(name = "name")
    private String name;

    @OneToMany(mappedBy="semester")
    @Getter @Setter
    private List<MatterDomain> matters;


}
