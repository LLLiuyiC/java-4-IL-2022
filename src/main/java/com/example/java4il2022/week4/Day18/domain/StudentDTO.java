package com.example.java4il2022.week4.Day18.domain;

import lombok.Data;

import java.util.Date;

@Data
public class StudentDTO {
    private String id;
    private String full_name;
    private Date date;

    public StudentDTO(Student stu) {
        this.id = stu.getId();
        this.full_name = stu.getName();
        this.date = new Date();
    }
}
