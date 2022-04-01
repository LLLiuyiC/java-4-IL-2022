package com.example.java4il2022.week4.Day18.service.impl;

import com.example.java4il2022.week4.Day18.domain.Student;
import com.example.java4il2022.week4.Day18.domain.StudentDTO;
import com.example.java4il2022.week4.Day18.exception.StudentNotFoundException;
import com.example.java4il2022.week4.Day18.repository.StudentRepo;
import com.example.java4il2022.week4.Day18.service.StudentService;
import com.example.java4il2022.week4.Day18.utility.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepo studentRepo;

    @Autowired
    public StudentServiceImpl(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    @Override
    public List<StudentDTO> getAllStudents(boolean reverse) {
        List<StudentDTO> students = studentRepo.getAllStudents()
                .stream()
                .map(s -> new StudentDTO(s))
                .map(s -> {
                    if(reverse) {
                        s.setFull_name(StringUtil.reverseString(s.getFull_name()));
                    }
                    return s;
                })
                .collect(Collectors.toList());
        return students;
    }

    @Override
    public StudentDTO getStudentById(String id) {
        Student stu = studentRepo.getStudentById(id);
        if(stu == null) {
            throw new StudentNotFoundException("we cannot find id " + id);
        }
        return new StudentDTO(stu);
    }
}
