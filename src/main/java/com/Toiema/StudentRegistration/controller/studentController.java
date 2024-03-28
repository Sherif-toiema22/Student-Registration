package com.Toiema.StudentRegistration.controller;

import com.Toiema.StudentRegistration.entity.Student;
import com.Toiema.StudentRegistration.service.studentService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("students")
public class studentController {

    private studentService studentService;

    @Autowired
    studentController(studentService thestudentService){
        this.studentService=thestudentService;
    }

    private List<Student> theStudent;

//
//    @PostConstruct
//    private void loadData() {
//
//        // create employees
//        Student emp1 = new Student("Leslie", "Andrews", "leslie@luv2code.com");
//
//        // create the list
//        theStudent = new ArrayList<>();
//
//        // add to the list
//        theStudent.add(emp1);
//    }

    @GetMapping
    public String hello(){
        return "hi";
    }

    @GetMapping("/list")
    public String listStudents(Model theModel) {

        List<Student> theStudents=studentService.findAll();
        // add to the spring model
        theModel.addAttribute("student", theStudents);

        return "list-students";
    }
    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {

        // create model attribute to bind form data
        Student theStudent = new Student();

        theModel.addAttribute("student", theStudent);

        return "student-form";
    }
    @PostMapping("/save")
    public String addStudent(@ModelAttribute("student")  Student student) {
        student.setId(0L);
        studentService.save(student);
        return "list-students";
    }
}
