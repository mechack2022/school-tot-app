package com.school.tutorialApp.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.school.tutorialApp.dto.StudentRequest;
import com.school.tutorialApp.dto.StudentResponse;
import com.school.tutorialApp.entity.SchoolClass;
import com.school.tutorialApp.entity.Student;
import com.school.tutorialApp.exception.ResourceNotFoundException;
import com.school.tutorialApp.repository.StudentRepository;

import lombok.RequiredArgsConstructor;

@Service 
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final ClassService classService;

    public StudentResponse createStudent(StudentRequest request){
        if (request == null  ) {
            System.out.println("your request is empty");
        }
        if(request.getClassUuid() == null){
            throw new ResourceNotFoundException("class Uuid is null");
        }
       SchoolClass schoolClass =  classService.getClassByUuid(request.getClassUuid());
        Student student = new Student();
        student.setFirstName(request.getFirstName());
        student.setLastName(request.getLastName());
        student.setDateOfBirth(request.getDateOfBirth());
        student.setGender(request.getGender());
        student.setEmail(request.getEmail());
        student.setPhoneNumber(request.getPhoneNumber());
        student.setAddress(request.getAddress());
        student.setSchoolClass(schoolClass);
        student.setCreatedAt(LocalDateTime.now());
        student.setUpdatedAt(LocalDateTime.now());
    
         Student savedStudent = studentRepository.save(student);  

        return convertSchoolToStudentResponse(savedStudent);

    }

    public StudentResponse convertSchoolToStudentResponse(Student student){
    StudentResponse studentResponse = new StudentResponse();
    
    studentResponse.setFirstName(student.getFirstName());
    studentResponse.setLastName(student.getLastName());       
    studentResponse.setDateOfBirth(student.getDateOfBirth()); 
    studentResponse.setGender(student.getGender());
    studentResponse.setEmail(student.getEmail());             
    studentResponse.setPhoneNumber(student.getPhoneNumber()); 
    studentResponse.setAddress(student.getAddress());  
    studentResponse.setSchoolClass(student.getSchoolClass());       
    studentResponse.setCreatedAt(student.getCreatedAt());        
    studentResponse.setUpdatedAt(student.getUpdatedAt());        
    
    return studentResponse;
}


 public List<StudentResponse> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        List<StudentResponse> studentResponses = new ArrayList<>();
        for (Student student : students) {
            studentResponses.add(convertSchoolToStudentResponse(student));
        }
        return studentResponses;


}
 public StudentResponse getStudentById(UUID id) {
    Optional<Student> student = studentRepository.findById(id);
    if (student.isEmpty()) {
        throw new ResourceNotFoundException("Student not found");
    }

    return convertSchoolToStudentResponse(student.get());
}

 public StudentResponse updateStudent(UUID id, StudentRequest request) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isEmpty()) {
            throw new ResourceNotFoundException("Student not found with id: " + id);
        }

        Student student = optionalStudent.get();
        student.setFirstName(request.getFirstName());
        student.setLastName(request.getLastName());
        student.setDateOfBirth(request.getDateOfBirth());
        student.setGender(request.getGender());
        student.setEmail(request.getEmail());
        student.setPhoneNumber(request.getPhoneNumber());
        student.setAddress(request.getAddress());

    
        if (request.getClassUuid() != null) {
            SchoolClass schoolClass = classService.getClassByUuid(request.getClassUuid());
            student.setSchoolClass(schoolClass);
        }
        student.setUpdatedAt(LocalDateTime.now());

        Student savedStudent = studentRepository.save(student);
        return convertSchoolToStudentResponse(savedStudent);
    }
   
 
    public String deleteStudent(UUID id) {
        Optional<Student> student = studentRepository.findById(id);
        if (student.isEmpty()) {
            throw new ResourceNotFoundException("Student not found with id: " + id);
        }
        studentRepository.deleteById(id);
        return "Student record deleted successfully";
    }

    public StudentResponse getStudentByName(String firstName) {
    if (firstName == null || firstName.trim().isEmpty()) {
        throw new ResourceNotFoundException("First name cannot be null or empty");
    }
    Student student = studentRepository.findByFirstNameIgnoreCase(firstName)
            .orElseThrow(() -> new ResourceNotFoundException("Student with first name '" + firstName + "' not found"));
            
    return convertSchoolToStudentResponse(student);
}
   public List <StudentResponse> getStudentByClassId(UUID classUuid){
    if(classUuid == null){
        throw new ResourceNotFoundException("Class ID CANNOT BE NULL");
    }
    classService.getClassByUuid(classUuid);

     List<Student> students = studentRepository.findBySchoolClassId(classUuid);
     List<StudentResponse> responses = new ArrayList<>();
     for (Student s : students) {
        responses.add(convertSchoolToStudentResponse(s));
    }
    return responses;


   }

    }
    

    



        
     




    






