package com.example.jpastudies.repositories;

import com.example.jpastudies.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
