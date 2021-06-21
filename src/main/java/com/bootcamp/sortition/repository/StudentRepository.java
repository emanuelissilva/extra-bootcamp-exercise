package com.bootcamp.sortition.repository;

import com.bootcamp.sortition.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
