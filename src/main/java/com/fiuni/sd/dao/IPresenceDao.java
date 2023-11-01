package com.fiuni.sd.dao;

import com.fiuni.sd.domain.PresenceDomain;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPresenceDao extends JpaRepository<PresenceDomain, Integer> {

    public Page<PresenceDomain> findAll(Pageable pageable);

}

