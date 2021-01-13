package com.example.testSpringBoot.student;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Component
public class StudentService {

    @GetMapping
    public List<Student> getStudents() {
        return List.of(
            new Student(
                    1L,
                    "Etienne",
                    "Crespi",
                    LocalDate.of(1997, Month.SEPTEMBER, 18),
                    "etienne.crespi@laposte.net"
            )
        );
    }
}
