package com.example.jpastudies.repositories;

import com.example.jpastudies.entities.School;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolRepository extends JpaRepository<School,Long> {
}
