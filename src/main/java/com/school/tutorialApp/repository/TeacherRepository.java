package com.school.tutorialApp.repository;

import com.school.tutorialApp.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    @Query("SELECT t FROM Teacher t WHERE t.firstName = :firstName")
    List<Teacher> searchByFirstName(@Param("firstName") String firstName);

    @Query("SELECT t FROM Teacher t WHERE t.lastName = :lastName")
    List<Teacher> searchByLastName(@Param("lastName") String lastName);
}
