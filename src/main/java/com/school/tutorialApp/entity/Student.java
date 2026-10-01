package com.school.tutorialApp.entity;

import java.time.LocalDate;
import java.util.UUID;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Table(name = "student") 
@Entity 
@Setter 
@Getter 
@AllArgsConstructor 
@NoArgsConstructor 
public class Student {

    @Id 
    @GeneratedValue 
    private UUID id;
    
     @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;
   
    private String gender;

    private String email;

    private long phoneNumber;
    
    private String address;

   @ManyToOne
@JoinColumn(
    name = "class_id",
    referencedColumnName = "id"
)
private SchoolClass schoolClass;

     private LocalDateTime createdAt;

     private LocalDateTime updatedAt;









}
