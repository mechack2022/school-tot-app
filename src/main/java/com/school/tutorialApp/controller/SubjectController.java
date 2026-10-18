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
import org.springframework.web.bind.annotation.RestController;

import com.school.tutorialApp.dto.StudentResponse;
import com.school.tutorialApp.dto.SubjectRequest;
import com.school.tutorialApp.dto.SubjectResponse;
import com.school.tutorialApp.exception.ApiResponse;
import com.school.tutorialApp.service.SubjectService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController 
@RequestMapping("api/subjects")
@RequiredArgsConstructor 
public class SubjectController {

    private final SubjectService subjectService;

    @PostMapping (value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse<SubjectResponse> createSubject(@Valid  @RequestBody SubjectRequest request){
         System.out.println("Creating subject...");
        SubjectResponse response = subjectService.createSubject(request);
        
        return ApiResponse.<SubjectResponse>builder()
                .message("Subject created successfully")
                .data(response)
                .success(true)
                .status(201)
                .build();
        

    }
    @GetMapping()
    public ApiResponse<List<SubjectResponse>> getAllSubjects(){
        //  ApiResponse<List<SubjectResponse>>  res = new ApiResponse<List<SubjectResponse>>();
        //   res.setMessage("get all subjects succsesfull");
        //   res.setData(subjectService.getAllSubjects());
        //   res.setSuccess(true);
        //   res.setStatus(200);
        //   return res;
        
        ApiResponse<List<SubjectResponse>> res = ApiResponse.<List<SubjectResponse>>builder()
        .message("get all subjects successfully")
        .data(subjectService.getAllSubjects())
        .success(true)
        .status(200)
        .build();

return res;
    }
    @GetMapping("{id}")
    public ApiResponse <SubjectResponse> getSubjectById(@PathVariable UUID id){
        return ApiResponse.<SubjectResponse>builder()
                .message("subjects retrieved successfully")
                .data(subjectService.getSubjectById(id))
                .success(true)
                .status(200)
                .build();

    }
    @PutMapping("{id}")
    public ApiResponse <SubjectResponse>  updateSubject(@PathVariable UUID id,@Valid @RequestBody SubjectRequest request){
        return ApiResponse.<SubjectResponse>builder()
                .message("Student updated successfully")
                .data(subjectService.updateSubject(id, request))
                .success(true)
                .status(200)
                .build();
    }
    @DeleteMapping("{id}")
    public ApiResponse <String> deleteSubject(@PathVariable UUID id){
        String message = subjectService.deleteSubject(id);
        
        return ApiResponse.<String>builder()
                .message(message)
                .data(message )
                .success(true)
                .status(204)
                .build();

    }



    }





