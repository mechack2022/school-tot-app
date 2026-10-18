package com.school.tutorialApp.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.school.tutorialApp.dto.SubjectRequest;
import com.school.tutorialApp.dto.SubjectResponse;
import com.school.tutorialApp.entity.Student;
import com.school.tutorialApp.entity.Subject;
import com.school.tutorialApp.exception.ResourceNotFoundException;
import com.school.tutorialApp.repository.SubjectRepository;

import lombok.RequiredArgsConstructor;

@Service 
@RequiredArgsConstructor 
public class SubjectService {

    private final SubjectRepository subjectRepository;



    public SubjectResponse createSubject(SubjectRequest request){
        if (request ==  null) {
            throw new ResourceNotFoundException("Your request is empty");
        }
        Subject subject = new Subject();
        
        subject.setName(request.getName());
        subject.setCode(request.getCode());
        subject.setDescription(request.getDescription());
        subject.setCreatedAt(LocalDateTime.now());
        subject.setUpdatedAt(LocalDateTime.now());

        Subject savedSubject = subjectRepository.save(subject);
        return convertSubjectToSubjectResponse(savedSubject);



    }

    private SubjectResponse convertSubjectToSubjectResponse(Subject subject){
        SubjectResponse subjectResponse = new SubjectResponse();
        subjectResponse.setId(subject.getId());
        subjectResponse.setName(subject.getName());
        subjectResponse.setCode(subject.getCode());
        subjectResponse.setDescription(subject.getDescription());
        subjectResponse.setCreatedAt(subject.getCreatedAt());
        subjectResponse.setUpdatedAt(subject.getUpdatedAt());

        return subjectResponse;


    }
    public  List <SubjectResponse> getAllSubjects(){
        List <Subject> subjects = subjectRepository.findAll();
        List <SubjectResponse> subjectResponses = new ArrayList<>();
        for(Subject subject : subjects){
            subjectResponses.add(convertSubjectToSubjectResponse(subject));

        }
        return subjectResponses;

        
       
    }
    public SubjectResponse getSubjectById(UUID id){
        Optional <Subject> subject = subjectRepository.findById(id);
        if (subject.isEmpty()) {
        throw new ResourceNotFoundException("subject not found");
    }

    return convertSubjectToSubjectResponse(subject.get());
}

    public SubjectResponse updateSubject(UUID id, SubjectRequest request){
        Optional<Subject> optionalSubject = subjectRepository.findById(id);
        if (optionalSubject.isEmpty()) {
            throw new ResourceNotFoundException("Subject not found with id: " + id);

    }
    Subject subject = optionalSubject.get();
    subject.setName(request.getName());
    subject.setCode(request.getCode());
    subject.setDescription(request.getDescription());
    subject.setCreatedAt(LocalDateTime.now());
    subject.setUpdatedAt(LocalDateTime.now());
    Subject savedsubject = subjectRepository.save(subject);
    return convertSubjectToSubjectResponse(savedsubject);


    }
    public String deleteSubject(UUID id){
        Optional<Subject> subject = subjectRepository.findById(id);
        if (subject.isEmpty()) {
            throw new ResourceNotFoundException("Subject not found with id: " + id);
        }
      subjectRepository.deleteById(id);
        return "Subject record deleted successfully";
    }

    }




    

    




    


