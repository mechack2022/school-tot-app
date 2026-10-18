package com.school.tutorialApp.controller;

import com.school.tutorialApp.dto.ClassRequest;
import com.school.tutorialApp.dto.ClassResponse;
import com.school.tutorialApp.entity.SchoolClass;
import com.school.tutorialApp.exception.ApiResponse;
import com.school.tutorialApp.service.ClassService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("api/schoolclass/")
@RequiredArgsConstructor


public class ClassController {

    private final ClassService classService;

    @PostMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse<ClassResponse> createClass(@Valid @RequestBody ClassRequest request){
        ApiResponse apiResponse = ApiResponse.builder()
                .message(" class created succesfully")
                .data(classService.createClass(request))
                .success(true)
                .build();
         return apiResponse;
    }
    



    @GetMapping("{id}")
    public ApiResponse <ClassResponse> getClassById(@Valid @PathVariable UUID id){
        ApiResponse apiResponse = ApiResponse.builder()
        .message("class get sucessfully")
        .data(classService.getClassById(id))
        .success(true)
        .build();
         return apiResponse;
    }

    @PutMapping({"{id}"})
    public  ApiResponse <ClassResponse> updateclass(@PathVariable UUID id, @RequestBody ClassRequest request){
        ApiResponse apiResponse = ApiResponse.builder()
        .message("class updated sucessfully")
        .data(classService.updateclass(id, request))
        .success(true)
        .build();
         return  apiResponse;

    }
    @DeleteMapping("{id}")
    public ApiResponse<String> deleteClass(@PathVariable UUID id){
       ApiResponse apiResponse = new ApiResponse<>();
       
       apiResponse.setData(classService.deleteClass(id));
        apiResponse.setMessage("Record deleted sucessfully");
        apiResponse.setStatus(200);
        apiResponse.setSuccess(true);
    
        return apiResponse;
    }

      
     @GetMapping()
    public  ApiResponse<List<ClassResponse>> getAllclass(){
        ApiResponse apiResponse = ApiResponse.builder()
        .message("class retrieved sucessfully")
        .data(classService.getAllClass())
        .success(true)
        .build();
         return  apiResponse;

    }
    
   

    }


    
    


