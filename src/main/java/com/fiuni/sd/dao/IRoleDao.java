package com.fiuni.sd.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fiuni.sd.domain.RoleDomain;

public interface IRoleDao extends JpaRepository<RoleDomain, Integer> {

    public Optional<RoleDomain> findByRoleKey(String name);

}