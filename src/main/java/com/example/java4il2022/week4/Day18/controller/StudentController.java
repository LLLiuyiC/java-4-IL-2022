package com.example.java4il2022.week4.Day18.controller;

import com.example.java4il2022.week4.Day18.domain.Student;
import com.example.java4il2022.week4.Day18.domain.StudentDTO;
import com.example.java4il2022.week4.Day18.exception.StudentNotFoundException;
import com.example.java4il2022.week4.Day18.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  What is MVC ?
 *
 *  database < - > server
 *                 Repository layer +  Service layer + Controller Layer
 */
@RestController
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/student")
    public ResponseEntity<List<StudentDTO>> getAllStudents(@RequestParam(required = false) boolean reverse) {
        return new ResponseEntity<>(studentService.getAllStudents(reverse), HttpStatus.OK);
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<StudentDTO> getStudentById(@PathVariable String id) {
        return new ResponseEntity<>(studentService.getStudentById(id), HttpStatus.OK);
    }

    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<?> custmoizedExceptionHandler() {
        return new ResponseEntity<>("this is customized msg", HttpStatus.NOT_FOUND);
    }
}
