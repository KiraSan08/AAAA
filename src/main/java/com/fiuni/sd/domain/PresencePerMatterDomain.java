package com.fiuni.sd.domain;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "presence_per_matter")
public class PresencePerMatterDomain implements BaseDomain {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    @Column(name = "id", nullable = false, unique = true)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    @Getter @Setter
    private StudentDomain student; // Cambiado de Integer a StudentDomain

    @ManyToOne
    @JoinColumn(name = "presence_id", nullable = false)
    @Getter @Setter
    private PresenceDomain presence; // Cambiado de Integer a PresenceDomain

    @Getter @Setter
    @Column(name = "is_present", nullable = false)
    private Boolean isPresent;

    @Getter @Setter
    @Column(name = "notes")
    private String notes;
}
