package com.dchristofolli.finalgrades.v1.service;

import com.dchristofolli.finalgrades.domain.StudentRepository;
import com.dchristofolli.finalgrades.v1.dto.StudentList;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
public class GradeService {
    private final Logger logger = LoggerFactory.getLogger(GradeService.class);
    private final Gson gson;
    private final StudentRepository studentRepository;

    public GradeService(Gson gson, StudentRepository studentRepository) {
        this.gson = gson;
        this.studentRepository = studentRepository;
    }

    @PostConstruct
    private void jsonReader() {
        String json = null;
        try {
            json = String.join(" ",
                Files.readAllLines(Paths.get("Alunos.json"),
                    StandardCharsets.UTF_8));
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
        StudentList studentList = gson.fromJson(json, StudentList.class);
        studentRepository.saveAll(studentList.getAlunos());
    }
}
