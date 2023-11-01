package com.fiuni.sd.domain;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "roles")
public class RoleDomain implements BaseDomain {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter @Column(name = "id", nullable = false, unique = true)
    private Integer id;

    @Getter @Setter @Column(name = "role_key")
    private String roleKey;

    @Getter @Setter @Column(name = "name")
    private String name;

}
