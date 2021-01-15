package com.example.testSpringBoot.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
        return args -> {
            Student etienne = new Student(
                "Etienne",
                "Crespi",
                LocalDate.of(1997, Month.SEPTEMBER, 18),
                "etienne.crespi@gmail.com"
            );
            Student arthur = new Student(
                    "Arthur",
                    "Djikpo",
                    LocalDate.of(1997, Month.JANUARY, 13),
                    "arthur.djikpo@gmail.com"
            );

            studentRepository.saveAll(List.of(etienne, arthur));
        };
    }
}
