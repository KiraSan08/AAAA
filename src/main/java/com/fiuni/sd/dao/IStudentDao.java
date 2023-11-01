package com.fiuni.sd.dao;

import com.fiuni.sd.domain.StudentDomain;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStudentDao extends JpaRepository<StudentDomain, Integer> {

    Page<StudentDomain> findAll(Pageable pageable);

    // Puedes agregar otras consultas personalizadas si es necesario
}
