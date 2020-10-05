package com.dchristofolli.finalgrades.v1.controller;

import com.dchristofolli.finalgrades.v1.dto.*;

import java.util.Collections;
import java.util.List;

public class Stub {
    public static StudentList studentListStub() {
        return new StudentList(Collections.singletonList(studentStub()));
    }

    public static Aluno studentStub() {
        return new Aluno(
            1L,
            "João da Silva",
            Collections.singletonList(disciplinaStub())
        );
    }

    public static Disciplina disciplinaStub() {
        return new Disciplina(
            1L,
            "Alpro-II",
            Collections.singletonList(gradeStub())
        );
    }

    public static Nota gradeStub() {
        return new Nota(
            7.5,
            7.9,
            8.2
        );
    }

    public static List<Disciplina> disciplinaListStub() {
        Disciplina build = DisciplinaBuilder.aDisciplina()
            .withId(disciplinaStub().getId())
            .withNome(disciplinaStub().getNome())
            .build();
        return Collections.singletonList(build);
    }

    public static GradeRequest gradeRequestStub() {
        return new GradeRequest(
            1L, 1, 1, 1);
    }

    public static GradeResult gradeResultStub() {
        return new GradeResult(
            1L,
            "AlproII",
            Collections.singletonList(new AlunoResult(
                1L,
                "José da Silva",
                8.8
            ))
        );
    }
}
