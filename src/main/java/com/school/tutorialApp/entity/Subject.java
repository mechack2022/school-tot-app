package com.school.tutorialApp.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.NonNull;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "subjects",
   uniqueConstraints = {
        @UniqueConstraint(columnNames = "name"),
           @UniqueConstraint(columnNames = "code")
   }
)
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    @Column(unique = true,nullable = false)
    private String name;

    @NotBlank
    @Column(unique = true,nullable = false)
    private String code;

    private String description;

    @Column(nullable = false)
    private LocalDateTime CreatedAt;

    @Column(nullable = false)
    private LocalDateTime UpdatedAt;

}
