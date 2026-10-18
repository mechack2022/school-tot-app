package com.school.tutorialApp.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter 
@Getter 
@AllArgsConstructor 
@NoArgsConstructor 

public class SubjectRequest {


    @NotBlank (message = "name is required")
    private String name;
     
    @NotBlank (message = "code is required")
    private String code;

    private String description;

}
