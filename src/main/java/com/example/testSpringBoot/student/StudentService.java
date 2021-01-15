package com.example.testSpringBoot.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void add(Student student) {
        Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());

        if (studentOptional.isPresent()) {
            throw new IllegalStateException("Email is already taken !");
        }

        studentRepository.save(student);
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    @Transactional
    public void updateStudent(Long studentId, String firstName, String lastName, LocalDate birthdate, String email) {

        Student student = studentRepository.findById(studentId).orElseThrow(() ->
            new IllegalStateException("Student ID doesn't exists")
        );

        if (firstName != null && firstName.length() > 0 && !Objects.equals(student.getFirstName(), firstName)) {
            student.setFirstName(firstName);
        }

        if (lastName != null && lastName.length() > 0 && !Objects.equals(student.getLastName(), lastName)) {
            student.setLastName(lastName);
        }

        if (birthdate != null && !Objects.equals(student.getBirthdate(), birthdate)) {
            student.setBirthdate(birthdate);
        }

        if (email != null && email.length() > 0 && !Objects.equals(student.getEmail(), email)) {
            Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);

            if (studentOptional.isPresent()) {
                throw new IllegalStateException("Email is already taken !");
            }

            student.setEmail(email);
        }
    }

    public void deleteStudent(Long studentId) {
        boolean  exists = studentRepository.existsById(studentId);

        if (!exists) {
            throw new IllegalStateException("Student ID doesn't exists");
        }

        studentRepository.deleteById(studentId);
    }
}
