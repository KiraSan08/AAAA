package com.fiuni.sd.domain;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "students")
public class StudentDomain implements BaseDomain {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    @Column(name = "id", nullable = false, unique = true)
    private Integer id; // Cambiado a Integer

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    @Getter
    @Setter
    private UserDomain user;

    @Getter
    @Setter
    @Column(name = "name")
    private String name;

    @Getter
    @Setter
    @Column(name = "ci")
    private String ci;

    @Getter
    @Setter
    @Column(name = "email")
    private String email;

    @OneToMany(mappedBy = "matter")
    @Getter
    @Setter
    private List<StudentPerMatterDomain> matters;

    // Resto de la clase
}
