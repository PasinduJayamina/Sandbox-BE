package com.example.test_project.controller;

import com.example.test_project.model.Student;
import com.example.test_project.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    //get all std
    @Operation(summary = "Get all students")
    @GetMapping
    public List<Student> getAllStudents(){
        return studentService.getAllStudent();
    }

    //get std by id
    @Operation(summary = "Get a student by ID")
    @GetMapping("/{id}")
    public Optional<Student> getStudentById(@PathVariable Long id){
        return studentService.getStudentById(id);
    }

    @GetMapping("/hello")
    public String getHello(){
        return "Hello AWS";
    }
    //add std
    @Operation(summary = "Add a students")
    @PostMapping
    public Student addStudent(@RequestBody Student student){
        return studentService.saveStudent(student);
    }

    //delete std
    @Operation(summary = "Delete a students")
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
    }
}
