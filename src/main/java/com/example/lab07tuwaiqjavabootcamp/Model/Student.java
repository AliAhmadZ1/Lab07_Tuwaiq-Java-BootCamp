package com.example.lab07tuwaiqjavabootcamp.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {

    //- id : String
    //- name : String
    //- age : int
    //- GPA : double
    //- level : String
    //- email : String

    @NotEmpty(message = "Shouldn't be empty")
    @Size(min = 2,max = 8,message = "size should be from 2 to 8 characters")
    private String id;
    @NotEmpty(message = "Shouldn't be empty")
    @Size(min = 4,max = 10,message = "size should be from 4 to 10 characters")
    @Pattern(regexp = "^([a-z]|[A-Z])+$",message = "should be letters only")
    private String name;
    @NotNull(message = "Shouldn't be null")
    @Positive(message = "The age is always positive and not zero")
    @Max(value = 60,message = "students age more than 60 are not allowed")
    private int age;
    @NotNull(message = "Shouldn't be null")
    @PositiveOrZero(message = "GPA cannot be negative")
    @Max(value = 100,message = "The GPA is up to 100")
    private double gpa;
    @NotEmpty(message = "Shouldn't be empty")
    @Pattern(regexp = "^(active|withdrawn|graduated)$",message = "must be active, withdrawn or graduated")
    private String status;
    @NotNull(message = "Shouldn't be null")
    @Min(value = 12,message = "minimum courses is 12")
    @Max(value = 25,message = "maximum courses is 25")
    private int numberOfRequiredCourses;
    @NotNull(message = "Shouldn't be null")
    @Max(value = 25,message = "maximum courses is 25")
    private int numberOfCoursesPassing;
    @NotEmpty(message = "Shouldn't be empty")
    @Email
    private String email;

}
