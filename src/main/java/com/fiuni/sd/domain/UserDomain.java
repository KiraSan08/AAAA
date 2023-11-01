package com.fiuni.sd.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.*;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "users")
@ToString @EqualsAndHashCode
public class UserDomain implements BaseDomain {

    private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter @Setter @Column(name = "id", nullable = false, unique = true)
	private Integer id;

    @Getter @Setter @Column(name = "email")
    private String email;

    @Getter @Setter @Column(name = "password")
    private String password;

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    @Getter @Setter
    private RoleDomain role;

}
