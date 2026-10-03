package com.school.tutorialApp.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.school.tutorialApp.entity.Student;
import java.util.List;
import java.util.Optional;


@Repository 
public interface StudentRepository extends JpaRepository<Student, UUID>{
 
     Optional<Student> findByFirstNameIgnoreCase(String firstName);
     List<Student> findBySchoolClassId(UUID classUuid);
}