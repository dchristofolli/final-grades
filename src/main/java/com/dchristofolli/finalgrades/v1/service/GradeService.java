package com.dchristofolli.finalgrades.v1.service;

import com.dchristofolli.finalgrades.domain.ClassRepository;
import com.dchristofolli.finalgrades.domain.StudentRepository;
import com.dchristofolli.finalgrades.exception.ApiException;
import com.dchristofolli.finalgrades.v1.dto.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class GradeService {
    private final StudentRepository studentRepository;
    private final ClassRepository classRepository;

    public GradeService(StudentRepository studentRepository, ClassRepository classRepository) {
        this.studentRepository = studentRepository;
        this.classRepository = classRepository;
    }

    public StudentList findAllStudent() {
        return new StudentList(studentRepository.findAll());
    }

    public List<Disciplina> findAllClasses() {
        return classRepository.findAll();
    }

    public GradeResult getResultsByClass(GradeRequest gradeRequest) {
        fillsDefaultWeight(gradeRequest);
        Disciplina disciplina = findAllClasses().stream()
            .filter(disc -> disc.getId().equals(gradeRequest.getDiciplinaId())).findFirst()
            .orElseThrow(() -> new ApiException("Nenhum aluno encontrado", HttpStatus.NOT_FOUND));
        List<AlunoResult> alunoResultList = new ArrayList<>();
        getStudentGrades(gradeRequest, disciplina, alunoResultList);
        return new GradeResult(disciplina.getId(),
            disciplina.getNome(),
            alunoResultList);
    }

    private void getStudentGrades(GradeRequest gradeRequest, Disciplina disciplina, List<AlunoResult> alunoResultList) {
        findAllStudent().getAlunos()
            .forEach(aluno -> {
                if (aluno.getDisciplinas().stream()
                    .anyMatch(disc -> disc.getId().equals(disciplina.getId()))) {
                    AlunoResult tempAluno = new AlunoResult();
                    tempAluno.setId(aluno.getId());
                    tempAluno.setNome(aluno.getNome());
                    AtomicReference<Double> sum = new AtomicReference<>((double) 0);
                    aluno.getDisciplinas().stream()
                        .filter(disciplina1 -> disciplina1.getId().equals(disciplina.getId()))
                        .map(Disciplina::getNotas)
                        .forEach(notas ->
                            calculateGrades(gradeRequest, sum, notas)
                        );
                    tempAluno.setNotaFinal(sum.get() / 3);
                    alunoResultList.add(decimalFormatter(tempAluno));
                }
            });
    }

    private void calculateGrades(GradeRequest gradeRequest, AtomicReference<Double> sum, List<Nota> notas) {
        notas.forEach(nota -> {
            Nota nt = gradesCorrector(nota);
            sum.updateAndGet(v -> (v + (nt.getProva1() * gradeRequest.getPeso1())));
            sum.updateAndGet(v -> (v + (nt.getProva2() * gradeRequest.getPeso2())));
            sum.updateAndGet(v -> (v + (nt.getProva3() * gradeRequest.getPeso3())));
        });
    }

    private void fillsDefaultWeight(GradeRequest gradeRequest) {
        if (gradeRequest.getPeso1() == null)
            gradeRequest.setPeso1(1);
        if (gradeRequest.getPeso2() == null)
            gradeRequest.setPeso2(1);
        if (gradeRequest.getPeso3() == null)
            gradeRequest.setPeso3(1);
    }

    private Nota gradesCorrector(Nota nota) {
        if (nota.getProva1() == null)
            nota.setProva1(0.0);
        if (nota.getProva2() == null)
            nota.setProva2(0.0);
        if (nota.getProva3() == null)
            nota.setProva3(0.0);
        return nota;
    }

    private AlunoResult decimalFormatter(AlunoResult tempAluno) {
        DecimalFormat df = new DecimalFormat("#.0");
        String format = df.format(tempAluno.getNotaFinal());
        double notaFinal = Double.parseDouble(format);
        if (notaFinal > 10)
            notaFinal = 10;
        tempAluno.setNotaFinal(notaFinal);
        return tempAluno;
    }
}
