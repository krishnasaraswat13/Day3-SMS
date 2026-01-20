package com.example.day3.controller;

import com.example.day3.model.StudentModel;
import com.example.day3.service.StudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
//    @GetMapping("/")
//    public String student(){
//        return "This is home page for student management system";
//    }
//
    private final StudentService service;
    public StudentController(StudentService service){
        this.service=service;
    }

    @PostMapping("/add-student")
    public StudentModel addStudent(@RequestBody StudentModel student){
        return service.addStudent(student);
    }



}
