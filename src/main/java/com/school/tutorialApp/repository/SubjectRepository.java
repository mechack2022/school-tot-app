package com.school.tutorialApp.repository;

import com.school.tutorialApp.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SubjectRepository extends JpaRepository<Subject,Long> {
    Optional<Subject> findByName(String name);
    Optional<Subject> findByCode(String code);
}
