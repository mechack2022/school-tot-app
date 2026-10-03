package com.school.tutorialApp.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.school.tutorialApp.entity.SchoolClass;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter 
@Getter 
@AllArgsConstructor 
@NoArgsConstructor 
public class StudentResponse {


    private String firstName;

    private String lastName;

    private LocalDate dateOfBirth;

    private String gender;

    private String email;

    private long phoneNumber;
    
    private String address;

    private SchoolClass schoolClass;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;



}
