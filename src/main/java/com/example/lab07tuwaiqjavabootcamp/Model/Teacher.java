package com.example.lab07tuwaiqjavabootcamp.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Teacher {

    //- id : String
    //- name : String
    //- age : int
    //- hours : int
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
    @Min(value = 25,message = "Teacher age should be at least 25 years old")
    @Max(value = 60,message = "teachers age more than 60 are not allowed")
    private int age;
    @NotNull(message = "Shouldn't be null")
    @Min(value = 6,message = "minimum hours is 6h/week")
    @Max(value = 20,message = "maximum hours is 20h/week")
    private int hours;
    @NotEmpty(message = "Shouldn't be empty")
    @Email
    private String email;
}
