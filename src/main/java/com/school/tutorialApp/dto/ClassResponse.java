package com.school.tutorialApp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ClassResponse {
    

    private UUID id;

    private String name;

    private String description;
    private UUID classUuid;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;



}