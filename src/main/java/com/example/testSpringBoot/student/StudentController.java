package com.example.testSpringBoot.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public void add(@RequestBody Student student) {
        studentService.add(student);
    }

    @GetMapping
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    @DeleteMapping(path = "{studentId}")
    public void delete(@PathVariable("studentId") Long studentId) {
        studentService.deleteStudent(studentId);
    }
}
