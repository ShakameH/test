package com.polytech.polywebproj.service;

import com.polytech.polywebproj.model.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    Student createStudent(Student student);

    List<Student> getStudents();

    Optional<Student> getStudentById(Long id);

    Student modifyStudent(Long id, Student student);

    String deleteStudent(Long id);
}
