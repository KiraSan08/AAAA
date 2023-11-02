package com.fiuni.sd.dao;

import com.fiuni.sd.domain.MatterDomain;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMatterDao extends JpaRepository<MatterDomain, Integer> {

    public Page<MatterDomain> findAll(Pageable pageable);

}

