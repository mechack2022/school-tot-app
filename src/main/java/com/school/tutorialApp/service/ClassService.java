package com.school.tutorialApp.service;


import com.school.tutorialApp.dto.ClassRequest;
import com.school.tutorialApp.dto.ClassResponse;
import com.school.tutorialApp.entity.SchoolClass;
import com.school.tutorialApp.exception.ResourceNotFoundException;
import com.school.tutorialApp.repository.ClassRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Repository 
public class ClassService {

    private final ClassRepository classRepository;


    public ClassResponse createClass(ClassRequest request) {
        if (request == null) {
            System.out.println("Your request is null");
        }
        SchoolClass clazz = new SchoolClass();
        clazz.setName(request.getName());
        clazz.setDescription(request.getDescription());
        clazz.setCreatedAt(LocalDateTime.now());
        clazz.setUpdatedAt(LocalDateTime.now());

        SchoolClass schoolClass =  classRepository.save(clazz);

        return convertSchoolClassTOClassResponse(schoolClass);

    }

    private ClassResponse convertSchoolClassTOClassResponse(SchoolClass schoolClass){
        ClassResponse classResponse = new ClassResponse();
        classResponse.setId(schoolClass.getId());
        classResponse.setName(schoolClass.getName());
        classResponse.setDescription(schoolClass.getDescription());
        classResponse.setCreatedAt(schoolClass.getCreatedAt());
        classResponse.setUpdatedAt(schoolClass.getUpdatedAt());
        return  classResponse;
    }

    public List<ClassResponse> getAllClass() {
            List<SchoolClass> schoolClasses =   classRepository.findAll();
            List<ClassResponse> classResponses = new ArrayList<>();
            for(SchoolClass c : schoolClasses){
               ClassResponse resp =  convertSchoolClassTOClassResponse(c);
               classResponses.add(resp);
  
            }
              return  classResponses;

     }

     
    public ClassResponse getClassById(UUID id){
        if(id == null){
          throw new ResourceNotFoundException("Id is null");
        }
       Optional<SchoolClass> schoolClass = classRepository.findById(id);
        if(schoolClass.isPresent()){
            return convertSchoolClassTOClassResponse(schoolClass.get());
        }
        throw new ResourceNotFoundException("Id Not found");
    }

    public ClassResponse updateclass(UUID id, ClassRequest request){
        Optional<SchoolClass>  optionalclazz = classRepository.findById(id);
        if (optionalclazz.isPresent()) {
            SchoolClass clazz = optionalclazz.get();
            clazz.setName(request.getName());
            clazz.setDescription(request.getDescription());
            clazz.setUpdatedAt(LocalDateTime.now());
            SchoolClass schoolClass =  classRepository.save(clazz);
            return convertSchoolClassTOClassResponse(schoolClass);
          }
         
          throw new ResourceNotFoundException("class not found");
          
           
    }

     public String deleteClass(UUID id){
        if(id != null ){
            classRepository.deleteById(id);
           return "Record deleted sucessfull";
        }
        throw new ResourceNotFoundException("Record not found for the id");
     }
     
     protected SchoolClass getClassByUuid(UUID classUuid){
        if(classUuid == null){
          throw new ResourceNotFoundException("class uUID IS NULL");
        }
         Optional<SchoolClass> schoolClass =  classRepository.findById(classUuid);
         if(schoolClass.isPresent()){
            return schoolClass.get();
         }
         throw new ResourceNotFoundException("Class not found for the provided UUID");
     }


    }

     
    
        
        
        
        

    

    
//}
