package com.school.tutorialApp.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter 
@Getter 
@AllArgsConstructor 
@NoArgsConstructor 
public class SubjectResponse {

    private UUID id;

    private String name;

    private String code;

    private String description;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

}
