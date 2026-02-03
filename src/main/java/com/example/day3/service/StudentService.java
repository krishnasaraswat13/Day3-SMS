package com.example.day3.service;

import com.example.day3.dto.StudentRequestDto;
import com.example.day3.dto.StudentResponseDto;
import com.example.day3.model.StudentModel;
import com.example.day3.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
   private StudentRepository repository;
//
//    public StudentService(StudentRepository repository) {
//        this.repository = repository;
//    }
//
//    //create
//    public StudentModel addStudent(StudentModel student){
//       return  repository.save(student);
//    }
//    //display
//    public List<StudentModel> getStudents(){
//        return repository.findAll();
//    }
//    //update
//    public StudentModel updateStudent(String id, StudentModel student){
//        StudentModel existingStudent=repository.findById(id)
//                .orElseThrow(()-> new RuntimeException("No Student found"));
//
//        existingStudent.setName(student.getName());
//        existingStudent.setAge(student.getAge());
//        existingStudent.setEmail(student.getEmail());
//
//        return repository.save(existingStudent);
//    }
//
//    //delete
//    public void deleteStudent(String id){
//       if(!repository.existsById(id)){
//           throw new RuntimeException("Student Not Found");
//       }
//       repository.deleteById(id);

    public StudentResponseDto addStudent(StudentRequestDto dto){
        StudentModel student=new StudentModel();
        student.setName(dto.getName());
        student.setAge(dto.getAge());
        student.setEmail(dto.getEmail());

        StudentModel saved = repository.save(student);
         return new StudentResponseDto(
                 saved.getId(),
                 saved.getName(),
                 saved.getAge(),
                 saved.getEmail()
         );
    }
    public List<StudentResponseDto> getAllStudents(){
        return repository.findAll()
                .stream()
                .map(StudentModel s-> new StudentResponseDto(
                        s.getId(),
                        s.getName(),
                        s.getAge(),
                        s.getEmail()
                )).toList();
    }
}
