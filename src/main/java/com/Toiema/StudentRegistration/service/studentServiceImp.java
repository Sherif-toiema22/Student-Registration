package com.Toiema.StudentRegistration.service;

import com.Toiema.StudentRegistration.entity.Student;
import com.Toiema.StudentRegistration.repository.studentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class studentServiceImp implements studentService{

    private studentRepository studentRepository;

    @Autowired
    studentServiceImp(studentRepository thestudentRepository){
        this.studentRepository=thestudentRepository;
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> findById(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void delete(Long id) {
        studentRepository.deleteById(id);
    }
}
