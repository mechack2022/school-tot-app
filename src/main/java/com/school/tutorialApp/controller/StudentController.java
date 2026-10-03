package com.school.tutorialApp.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.school.tutorialApp.dto.StudentRequest;
import com.school.tutorialApp.dto.StudentResponse;
import com.school.tutorialApp.exception.ApiResponse;
import com.school.tutorialApp.service.StudentService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController 
// 1. Removed the trailing slash here for cleaner mapping
@RequestMapping("api/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
     public ApiResponse<StudentResponse> createStudent(@Valid @RequestBody StudentRequest request) {
        System.out.println("Creating student...");
        StudentResponse response = studentService.createStudent(request);
        
        return ApiResponse.<StudentResponse>builder()
                .message("Student created successfully")
                .data(response)
                .success(true)
                .build();
    }

    // 2. This now clearly maps to GET /api/students
    @GetMapping
     public ApiResponse<List<StudentResponse>> getAllStudents() {
        return ApiResponse.<List<StudentResponse>>builder()
                .message("Students retrieved successfully")
                .data(studentService.getAllStudents())
                .success(true)
                .build();
   }
   
   @GetMapping("{id}")
    public ApiResponse <StudentResponse> getStudentById(@PathVariable UUID id){
         return ApiResponse.<StudentResponse>builder()
                .message("Student retrieved successfully")
                .data(studentService.getStudentById(id))
                .success(true)
                .build();
    }

    @PutMapping("{id}")
    public ApiResponse <StudentResponse> updateStudent(@PathVariable UUID id,@Valid @RequestBody StudentRequest request){
        return ApiResponse.<StudentResponse>builder()
                .message("Student updated successfully")
                .data(studentService.updateStudent(id, request))
                .success(true)
                .build();
    }

    @DeleteMapping("{id}")
    public ApiResponse<String> deleteStudent(@PathVariable UUID id){
       String message = studentService.deleteStudent(id);
        
        return ApiResponse.<String>builder()
                .message(message)
                .data(message)
                .success(true)
                .build();
    }

    
    @GetMapping("/name")
    public ApiResponse<StudentResponse> getStudentByFirstName(@RequestParam String firstName) {
        return ApiResponse.<StudentResponse>builder()
                .message("Student retrieved successfully")
                .data(studentService.getStudentByName(firstName))
                .success(true)
                .build();
    }

    @GetMapping("/class/{classId}")
public ApiResponse<List<StudentResponse>> getStudentByClassId(
        @PathVariable UUID classId) {
    
    return ApiResponse.<List<StudentResponse>>builder()
            .message("Students retrieved successfully for class")
            .data(studentService.getStudentByClassId(classId))
            .success(true)
            .build();
}
}