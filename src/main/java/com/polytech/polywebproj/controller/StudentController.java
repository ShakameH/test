package com.polytech.polywebproj.controller;

import com.polytech.polywebproj.model.Student;
import com.polytech.polywebproj.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/polywebproj/student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/create")
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    @GetMapping
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    @GetMapping(value="/{id}")
    public Optional<Student> getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    @PutMapping("/update/{id}")
    public Student modifyStudent(@PathVariable Long id, @RequestBody Student student) {
        return studentService.modifyStudent(id, student);
    }

    @DeleteMapping("/delete")
    public String deleteStudent(Long id) {
        return studentService.deleteStudent(id);
    }
}
