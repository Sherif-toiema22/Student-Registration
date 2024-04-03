package com.Toiema.StudentRegistration.service;

import com.Toiema.StudentRegistration.entity.Student;
import com.Toiema.StudentRegistration.repository.studentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public Optional<Student> findById(int id) {
        return studentRepository.findById((long) id);
    }

    @Transactional
    @Override
    public Student save(Student student) {
        studentRepository.save(student);

        return student;
    }

    @Transactional
    @Override
    public void delete(int id) {
        studentRepository.deleteById((long) id);
    }
}
