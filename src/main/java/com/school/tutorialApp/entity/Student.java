package com.school.tutorialApp.entity;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "students")
@Entity
@Setter
@Getter
//@AllArgsConstructor
//@NoArgsConstructor
public class Student {
	@Id
	@GeneratedValue
	@Column(name = "id", updatable = false, nullable = false)
	private UUID id;
	private String firstName;
	private String lastName;
	private LocalDate dateOfBirth;
	private Gender gender;
	private String email;
	private long phoneNumber;
	private String address;
	@ManyToOne
	@JoinColumn(name = "class_id")
	private SchoolClass classId;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;

}
