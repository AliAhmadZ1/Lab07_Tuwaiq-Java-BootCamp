package com.example.lab07tuwaiqjavabootcamp.Controller;

import com.example.lab07tuwaiqjavabootcamp.ApiResponse.ApiResponse;
import com.example.lab07tuwaiqjavabootcamp.Model.Student;
import com.example.lab07tuwaiqjavabootcamp.Service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/get")
    public ResponseEntity getAllStudent(){
        if (studentService.getAllStudent().isEmpty())
            return ResponseEntity.status(400).body(new ApiResponse("there are no students"));
        return ResponseEntity.status(200).body(studentService.getAllStudent());
    }

    @PostMapping("/add")
    public ResponseEntity addStudent(@RequestBody@Valid Student student, Errors errors){
        if (errors.hasErrors()){
            String message= errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message));
        }
        if (studentService.addStudent(student))
            return ResponseEntity.status(200).body(new ApiResponse("new student added"));
        return ResponseEntity.status(400).body(new ApiResponse("student is already exist or number of required courses are less than passing courses"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateStudent(@PathVariable String id,@RequestBody@Valid Student student,Errors errors){
        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        if (studentService.updateStudent(id, student))
            return ResponseEntity.status(200).body(new ApiResponse("student is updated"));
        return  ResponseEntity.status(400).body(new ApiResponse("Not found or number of required courses are less than passing courses"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteStudent(@PathVariable String id){
        if (studentService.deleteStudent(id))
            return ResponseEntity.status(200).body(new ApiResponse("student is deleted"));
        return ResponseEntity.status(400).body(new ApiResponse("Not found"));
    }

    @PutMapping("/pass/{id},{courses}")
    public ResponseEntity passCourses(@PathVariable String id,@PathVariable int courses){
        if (studentService.passCourses(id,courses)){
            return ResponseEntity.status(200).body(new ApiResponse("Congratulation you passed "+courses+" courses"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("Not found or number of courses are exceeding the required"));
    }





}
