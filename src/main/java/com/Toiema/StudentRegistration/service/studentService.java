package com.Toiema.StudentRegistration.service;

import com.Toiema.StudentRegistration.entity.Student;
import java.util.List;
import java.util.Optional;

public interface studentService {

    List<Student> findAll();
    Optional<Student> findById(Long id);
    void save(Student student);
    void delete(Long id);

}
