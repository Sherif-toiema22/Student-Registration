package com.Toiema.StudentRegistration.controller;

import com.Toiema.StudentRegistration.entity.Student;
import com.Toiema.StudentRegistration.service.studentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("students")
public class studentController {

    private final studentService studentService;

    @Autowired
    studentController(studentService thestudentService){
        this.studentService=thestudentService;
    }

//@GetMapping("/lists")
//    public List<Student> listObjectStudent() {
//        return studentService.findAll();
//    }
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
//    @PostMapping("/save")
//    public String addStudent(@ModelAttribute("student")  Student student) {
////        student.setId(0L);
//        studentService.save(student);
//        return "list-students";
//    }
    @PostMapping("/save")
    public Student addStudent(@RequestBody  Student student) {
        student.setId(0);

        return studentService.save(student);
    }

    @PutMapping("/update")
    public Student updateStudent(@RequestBody Student theStudent) {

        return studentService.save(theStudent);
    }

    // add mapping for DELETE /employees/{employeeId} - delete employee

    @DeleteMapping("/delete/{studentId}")
    public String deleteStudent(@PathVariable int studentId) {

        Optional<Student> tempStudent = studentService.findById(studentId);

        // throw exception if null

        if (tempStudent.isEmpty()) {
            throw new RuntimeException("Employee id not found - " + studentId);
        }

        studentService.delete(studentId);

        return null;
    }


}
