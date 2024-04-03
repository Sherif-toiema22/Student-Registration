package com.Toiema.StudentRegistration.service;

import com.Toiema.StudentRegistration.entity.Student;
import java.util.List;
import java.util.Optional;

public interface studentService {

    List<Student> findAll();
    Optional<Student> findById(int id);
    Student save(Student student);
    void delete(int id);

}
