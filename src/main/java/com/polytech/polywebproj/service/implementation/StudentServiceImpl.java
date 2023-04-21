package com.polytech.polywebproj.service.implementation;

import com.polytech.polywebproj.model.Account;
import com.polytech.polywebproj.model.Prom;
import com.polytech.polywebproj.model.Speciality;
import com.polytech.polywebproj.model.Student;
import com.polytech.polywebproj.repository.StudentRepository;
import com.polytech.polywebproj.service.StudentService;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public Student modifyStudent(Long id, Student student) {
        return studentRepository.findById(id)
                .map(p-> {
                    p.setFirstName(student.getFirstName());
                    p.setLastName(student.getLastName());
                    p.setStudentNumber(student.getStudentNumber());
                    p.setEmail(student.getEmail());
                    p.setProm(student.getProm());
                    p.setSpeciality(student.getSpeciality());
                    p.setAccount(student.getAccount());
                    return studentRepository.save(p);
                }).orElseThrow(() -> new RuntimeException("Student not found"));
    }

    @Override
    public String deleteStudent(Long id) {
        studentRepository.deleteById(id);
        return "Student deleted";
    }
}
