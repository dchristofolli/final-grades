package com.dchristofolli.finalgrades.v1.service;

import com.dchristofolli.finalgrades.domain.StudentRepository;
import com.dchristofolli.finalgrades.domain.SubjectRepository;
import com.dchristofolli.finalgrades.v1.dto.Aluno;
import com.dchristofolli.finalgrades.v1.dto.DisciplinaBuilder;
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
    private final SubjectRepository subjectRepository;

    public GradeService(Gson gson, StudentRepository studentRepository, SubjectRepository subjectRepository) {
        this.gson = gson;
        this.studentRepository = studentRepository;
        this.subjectRepository = subjectRepository;
    }

    @PostConstruct
    private void studentListReader() {
        String json = null;
        try {
            json = String.join(" ",
                Files.readAllLines(Paths.get("Alunos.json"),
                    StandardCharsets.UTF_8));
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
        StudentList studentList = gson.fromJson(json, StudentList.class);
        studentList.getAlunos().stream()
            .map(Aluno::getDisciplinas)
        .forEach(disciplinas -> disciplinas
            .forEach(disciplina -> {
                if(!subjectRepository.existsById(disciplina.getId()))
                    subjectRepository.save(DisciplinaBuilder.aDisciplina()
                        .withId(disciplina.getId())
                        .withNome(disciplina.getNome())
                        .build());
            }));
        studentRepository.saveAll(studentList.getAlunos());
    }
}
