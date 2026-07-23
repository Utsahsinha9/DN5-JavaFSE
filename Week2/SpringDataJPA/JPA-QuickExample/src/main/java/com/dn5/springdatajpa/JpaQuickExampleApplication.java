package com.dn5.springdatajpa;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Optional;

@SpringBootApplication
public class JpaQuickExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaQuickExampleApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(StudentRepository repository) {
        return args -> {
            System.out.println("\n--- CREATE ---");
            Student s1 = repository.save(new Student("Utsah Sinha", "utsah@example.com"));
            System.out.println("Saved: " + s1);

            System.out.println("\n--- READ (findById) ---");
            Optional<Student> found = repository.findById(s1.getId());
            found.ifPresent(s -> System.out.println("Found: " + s));

            System.out.println("\n--- UPDATE ---");
            s1.setEmail("utsah.updated@example.com");
            repository.save(s1);
            System.out.println("Updated: " + repository.findById(s1.getId()).get());

            System.out.println("\n--- READ ALL ---");
            repository.findAll().forEach(System.out::println);

            System.out.println("\n--- DELETE ---");
            repository.deleteById(s1.getId());
            System.out.println("Remaining count: " + repository.count());
        };
    }
}