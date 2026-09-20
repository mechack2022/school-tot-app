package com.school.tutorialApp.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.school.tutorialApp.entity.Student;


@Repository
public interface StudentRepository extends JpaRepository<Student, UUID>{

}
