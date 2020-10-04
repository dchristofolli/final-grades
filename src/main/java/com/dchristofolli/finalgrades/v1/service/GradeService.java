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
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class GradeService {
    private final Logger logger = LoggerFactory.getLogger(GradeService.class);
    private final Gson gson;
    @Value("${file.path}")
    private String jsonFilePath;

    public GradeService(Gson gson) {
        this.gson = gson;
    }

    public StudentList jsonReader() {
        String tempJson = null;
        try {
            tempJson = String.join(" ",
                Files.readAllLines(Paths.get(jsonFilePath),
                    StandardCharsets.UTF_8));
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
        String json = Objects.requireNonNull(tempJson).replace("Prova", "prova");
        return new StudentList(gson.fromJson(json, StudentList.class).getAlunos());
    }

    public StudentList findAllStudents() {
        return jsonReader();
    }

    public List<Disciplina> findAllClasses() {
        List<Disciplina> disciplinaList = new ArrayList<>();
        findAllStudents().getAlunos().stream()
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

    //todo lançar exception quando o usuário inserir dados inválidos
    public GradeResult getResultsByClass(GradeRequest gradeRequest) {
        Disciplina disciplina = findAllClasses().stream()
            .filter(disc -> disc.getId().equals(gradeRequest.getDiciplinaId()))
            .findFirst().orElseThrow(RuntimeException::new);
        List<AlunoResult> alunoResultList = new ArrayList<>();
        findAllStudents().getAlunos().forEach(aluno -> {
            if (aluno.getDisciplinas().stream().anyMatch(disc -> disc.getId().equals(disciplina.getId()))) {
                AlunoResult tempAluno = new AlunoResult();
                tempAluno.setId(aluno.getId());
                tempAluno.setNome(aluno.getNome());
                AtomicReference<Double> sum = new AtomicReference<>((double) 0);
                aluno.getDisciplinas().stream()
                    .filter(disciplina1 -> disciplina1.getId().equals(disciplina.getId()))
                    .map(Disciplina::getNotas)
                    .forEach(notas ->
                        notas.forEach(nota -> {
                            if (nota.getProva1() == null)
                                nota.setProva1(0.0);
                            if (nota.getProva2() == null)
                                nota.setProva2(0.0);
                            if (nota.getProva3() == null)
                                nota.setProva3(0.0);
                            sum.updateAndGet(v -> (v + (nota.getProva1() * gradeRequest.getPeso1())));
                            sum.updateAndGet(v -> (v + (nota.getProva2() * gradeRequest.getPeso2())));
                            sum.updateAndGet(v -> (v + (nota.getProva3() * gradeRequest.getPeso3())));
                        })
                    );
                tempAluno.setNotaFinal(sum.get() / 3);
                if (tempAluno.getNotaFinal() > 10)
                    tempAluno.setNotaFinal(10);
                DecimalFormat df = new DecimalFormat("#.0");
                String format = df.format(tempAluno.getNotaFinal());
                tempAluno.setNotaFinal(Double.parseDouble(format));
                alunoResultList.add(tempAluno);
            }
        });
        return new GradeResult(disciplina.getId(),
            disciplina.getNome(),
            alunoResultList);
    }
}
