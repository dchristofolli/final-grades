package com.dchristofolli.finalgrades.v1.service;

import com.dchristofolli.finalgrades.domain.StudentRepository;
import com.dchristofolli.finalgrades.domain.SubjectRepository;
import com.dchristofolli.finalgrades.v1.dto.Disciplina;
import com.dchristofolli.finalgrades.v1.dto.StudentList;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final SubjectRepository subjectRepository;

    public StudentService(StudentRepository studentRepository, SubjectRepository subjectRepository) {
        this.studentRepository = studentRepository;
        this.subjectRepository = subjectRepository;
    }

    public StudentList findAllStudent() {
        return new StudentList(new ArrayList<>(studentRepository.findAll()));
    }
    public List<Disciplina> findAllSubjects(){
        return subjectRepository.findAll();
    }
}
