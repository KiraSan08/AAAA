package com.fiuni.sd.dao;

import com.fiuni.sd.domain.UserDomain;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserDao extends JpaRepository<UserDomain, Integer> {

	public Page<UserDomain> findAll(Pageable pageable);
	public UserDomain findByEmail(String email);
    
}
