package com.dchristofolli.finalgrades.v1.service;

import com.dchristofolli.finalgrades.v1.dto.*;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class GradeService {
    private final Logger logger = LoggerFactory.getLogger(GradeService.class);
    private final Gson gson;
    @Value("${file.path}")
    private String jsonFilePath;

    public GradeService(Gson gson) {
        this.gson = gson;
    }

    public StudentList studentListReader() {
        String tempJson = null;
        try {
            tempJson = String.join(" ",
                Files.readAllLines(Paths.get(jsonFilePath),
                    StandardCharsets.UTF_8));
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
        String json = Objects.requireNonNull(tempJson).replace("Prova", "prova");
        return gson.fromJson(json, StudentList.class);
    }

    public List<Disciplina> findAllClasses() {
        List<Disciplina> disciplinaList = new ArrayList<>();
        studentListReader().getAlunos().stream()
            .map(Aluno::getDisciplinas)
            .forEach(disciplinas -> disciplinas
                .forEach(disciplina -> {
                    if (disciplinaList.stream().noneMatch(disc -> disc.getId().equals(disciplina.getId())))
                        disciplinaList.add(DisciplinaBuilder.aDisciplina()
                            .withId(disciplina.getId())
                            .withNome(disciplina.getNome())
                            .build());
                }));
        return disciplinaList;
    }

    public GradeResult getResultsByClass(GradeRequest gradeRequest) {
        Disciplina disciplina = findAllClasses().stream()
            .filter(disc -> disc.getId().equals(gradeRequest.getDiciplinaId()))
            .findFirst().orElseThrow(RuntimeException::new);
        List<AlunoResult> alunoResultList = new ArrayList<>();
        AlunoResult tempAluno = new AlunoResult();
        studentListReader().getAlunos()
            .forEach(aluno -> {
                tempAluno.setId(aluno.getId());
                tempAluno.setNome(aluno.getNome());
                aluno.getDisciplinas().stream()
                    .filter(disciplina1 -> disciplina1.getId().equals(disciplina.getId()))
                    .map(Disciplina::getNotas)
                    .forEach(notas -> {
                        notas.forEach(nota -> {
                            double average = ((nota.getProva1() * gradeRequest.getPeso1()) +
                                (nota.getProva2() * gradeRequest.getPeso2()) +
                                (nota.getProva3() * gradeRequest.getPeso3()));
                            tempAluno.setNotaFinal(average);
                        });
                        alunoResultList.add(tempAluno);
                    });
            });
        return new GradeResult(disciplina.getId(),
            disciplina.getNome(),
            alunoResultList);
    }
}
