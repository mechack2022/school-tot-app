package com.school.tutorialApp.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.school.tutorialApp.entity.Subject;

@Repository 
public interface SubjectRepository  extends JpaRepository<Subject, UUID>{

    // @Query(value = "select * from subject where name = ")

}
