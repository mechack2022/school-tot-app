package com.school.tutorialApp.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Table (name = "subject")
@Entity 
@Setter 
@Getter 
@AllArgsConstructor 
@NoArgsConstructor 
public class Subject {

    @Id 
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
   
    @Column (unique = true)
    private String name;
    
    @Column( unique = true)
    private String code;

    private String description;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;




}
