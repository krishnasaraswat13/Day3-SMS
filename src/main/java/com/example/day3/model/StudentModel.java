package com.example.day3.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.lang.annotation.Documented;

//@Data  //we are not using data bcz it also giving unnecessary functions but we only need getters and setters
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "students")
public class StudentModel {
   // @Id  //means primary key //we are not requiresd to make id bcz it is auto generated in mongodb
    //private String id;

    @NotBlank(message="Name cannot be blank")
    private String name;
    @Min(value=5,message ="Age cannot be less than 5")
    @Max(value=90, message ="Age cannot be more than 90")
    private int age;

    @Email(message="Email should be valid")
    @NotBlank(message="email cannot be blank")
    private String email;

}
