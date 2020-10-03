package com.dchristofolli.finalgrades.v1.service;

import com.dchristofolli.finalgrades.domain.StudentRepository;
import com.dchristofolli.finalgrades.v1.dto.StudentList;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public StudentList findAll() {
        return new StudentList(new ArrayList<>(studentRepository.findAll()));
    }
}
