package com.example.lab07tuwaiqjavabootcamp.Controller;


import com.example.lab07tuwaiqjavabootcamp.ApiResponse.ApiResponse;
import com.example.lab07tuwaiqjavabootcamp.Model.Teacher;
import com.example.lab07tuwaiqjavabootcamp.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/teacher")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;

    @GetMapping("/get")
    public ResponseEntity getAllTeacher(){
        if (teacherService.getAllTeachers().isEmpty())
            return ResponseEntity.status(400).body(new ApiResponse("there no teachers"));
        return ResponseEntity.status(200).body(teacherService.getAllTeachers());
    }

    @PostMapping("/add")
    public ResponseEntity addTeacher(@RequestBody@Valid Teacher teacher, Errors errors){
        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        if (teacherService.addTeacher(teacher))
            return ResponseEntity.status(200).body(new ApiResponse("teacher added"));
        return ResponseEntity.status(400).body(new ApiResponse("already exist"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateTeacher(@PathVariable String id,@RequestBody@Valid Teacher teacher,Errors errors){
        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        if (teacherService.updateTeacher(id, teacher))
            return ResponseEntity.status(200).body(new ApiResponse("Teacher is updated"));
        return ResponseEntity.status(400).body(new ApiResponse("Not found"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTeacher(@PathVariable String id){
        if (teacherService.deleteTeacher(id))
            return ResponseEntity.status(200).body(new ApiResponse("teacher is deleted"));
        return ResponseEntity.status(400).body(new ApiResponse("Not found"));
    }

    @PutMapping("/bonus/{id},{percent}")
    public ResponseEntity salaryBonus(@PathVariable String id,@PathVariable double percent){
        if (teacherService.salaryBonus(id, percent)){
            return ResponseEntity.status(200).body(new ApiResponse("you have get "+percent+"% bonus"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("Not found or Bonus doesn't allowed"));
    }

    @PutMapping("/special/{id}")
    public ResponseEntity salarySpecialBonus(@PathVariable String id){
        if (teacherService.salarySpecialBonus(id)){
            return ResponseEntity.status(200).body(new ApiResponse("You've got 7.5% bonus"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("Not Found or not compatible"));
    }

}
