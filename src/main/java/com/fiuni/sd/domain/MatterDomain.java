package com.fiuni.sd.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "matters")
public class MatterDomain implements BaseDomain{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter @Column(name = "id", nullable = false, unique = true)
    private Integer id;

    @Getter @Setter @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "semester_id", nullable = false)
    @Getter @Setter
    private SemesterDomain semester;

    @OneToMany(mappedBy = "student")
    @Getter @Setter
    private List<StudentPerMatterDomain> students;
}
