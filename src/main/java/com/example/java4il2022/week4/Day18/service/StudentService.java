package com.example.java4il2022.week4.Day18.service;

import com.example.java4il2022.week4.Day18.domain.Student;
import com.example.java4il2022.week4.Day18.domain.StudentDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
    StudentDTO getStudentById(String id);
    List<StudentDTO> getAllStudents(boolean reverse);
}
