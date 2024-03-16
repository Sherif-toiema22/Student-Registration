package com.Toiema.StudentRegistration.repository;

import com.Toiema.StudentRegistration.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;


public interface studentRepository extends JpaRepository<Student,Long> {

    // no coding here
}
