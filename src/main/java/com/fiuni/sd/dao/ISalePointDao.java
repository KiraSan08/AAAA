package com.fiuni.sd.dao;

import com.fiuni.sd.domain.SalePointDomain;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISalePointDao extends JpaRepository<SalePointDomain, Integer> {

    public Page<SalePointDomain> findAll(Pageable pageable);

}
