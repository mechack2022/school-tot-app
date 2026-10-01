package com.school.tutorialApp.dto;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
@Setter 
@Getter 
public class StudentRequest {

    static final String FIRSTNAME_REQUIRED_MESSAGE = "The firstName field is required";
    static final String LASTNAME_REQUIRED_MESSAGE = "The lastName field is required";
    static  final String GENDER_REQUIRED_MESSAGE = "The gender field is compulsory";


    @NotBlank(message =  FIRSTNAME_REQUIRED_MESSAGE)
    private String firstName;
   
    @NotBlank(message = LASTNAME_REQUIRED_MESSAGE)
    private String lastName;

    private LocalDate dateOfBirth;
    
    @NotBlank (message = GENDER_REQUIRED_MESSAGE )
    private String gender;

    private String email;

    private Long phoneNumber;
    
    private String address;
    @NotNull(message = "the feild class can not be null") 
    private UUID classUuid;


}
