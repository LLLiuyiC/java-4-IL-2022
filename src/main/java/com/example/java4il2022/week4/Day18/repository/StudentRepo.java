package com.example.java4il2022.week4.Day18.repository;

import com.example.java4il2022.week4.Day18.domain.Student;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class StudentRepo {
    private final Map<String, Student> studentMap = new HashMap<>();

    public StudentRepo() {
        studentMap.put("1", new Student("1", "Tom", true));
        studentMap.put("2", new Student("2", "Alex", true));
    }

    public Student getStudentById(String id) {
        return studentMap.get(id);
    }

    public Collection<Student> getAllStudents() {
        return studentMap.values();
    }
}
