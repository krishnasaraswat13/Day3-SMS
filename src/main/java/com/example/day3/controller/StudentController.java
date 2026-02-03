package com.example.day3.controller;

import com.example.day3.dto.StudentRequestDto;
import com.example.day3.model.StudentModel;
import com.example.day3.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    private final StudentService service;
    public StudentController(StudentService service){
        this.service=service;
    }

    @PostMapping("/add-student")
    public StudentRequestDto addStudent(@Valid @RequestBody StudentRequestDto student){
        return service.addStudent(student);
    }
    

    @GetMapping("/students")
    public List<StudentRequestDto> getStudents(){
        return service.getAllStudents();
    }
    @PutMapping("/update/{id}")
    public StudentModel updateStudent(@PathVariable String id,@RequestBody StudentRequestDto student){
        return service.updateStudent(id,student);
    }
    @DeleteMapping("/delete/{id}")
    public String  deleteStudent(@PathVariable String id){
        service.deleteStudent(id);
        return "Student Deleted successfully";
    }
}
