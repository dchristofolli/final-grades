package com.dchristofolli.finalgrades.v1.service;

import com.dchristofolli.finalgrades.domain.ClassRepository;
import com.dchristofolli.finalgrades.domain.StudentRepository;
import com.dchristofolli.finalgrades.exception.ApiException;
import com.dchristofolli.finalgrades.v1.dto.Disciplina;
import com.dchristofolli.finalgrades.v1.dto.DisciplinaBuilder;
import com.dchristofolli.finalgrades.v1.dto.StudentList;
import com.google.gson.Gson;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Component
public class DatabaseInitializer {
    private final Gson gson;
    private final StudentRepository studentRepository;
    private final ClassRepository classRepository;

    public DatabaseInitializer(Gson gson, StudentRepository studentRepository, ClassRepository classRepository) {
        this.gson = gson;
        this.studentRepository = studentRepository;
        this.classRepository = classRepository;
    }

    @PostConstruct
    private void initialize(){
        readJsonFile();
        saveAllClasses();
    }
    private void readJsonFile() {
        try {
            String tempJson = new String(Files.readAllBytes(Paths.get("Alunos.json")));
            String json = tempJson.replace("Prova", "prova");
            StudentList studentList = new StudentList(gson.fromJson(json, StudentList.class).getAlunos());
            saveAllStudent(studentList);
        } catch (IOException e) {
            throw new ApiException("Não foi possível ler o arquivo.\n" + e.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private void saveAllClasses(){
        studentRepository.findAll()
            .forEach(aluno -> aluno.getDisciplinas()
                .forEach(disciplina -> {
                    if(!classRepository.existsById(disciplina.getId()))
                        classRepository.save(DisciplinaBuilder.aDisciplina()
                            .withId(disciplina.getId())
                            .withNome(disciplina.getNome())
                            .build());
                }));
    }

    private void saveAllStudent(StudentList studentList) {
        studentRepository.saveAll(studentList.getAlunos());
    }
}
