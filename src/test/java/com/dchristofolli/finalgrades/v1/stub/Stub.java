package com.dchristofolli.finalgrades.v1.stub;

import com.dchristofolli.finalgrades.v1.dto.Aluno;
import com.dchristofolli.finalgrades.v1.dto.Disciplina;
import com.dchristofolli.finalgrades.v1.dto.Nota;
import com.dchristofolli.finalgrades.v1.dto.StudentList;

import java.util.Collections;
import java.util.List;

public class Stub {
    public static StudentList studentListStub(){
        Nota nota = new Nota(8.0, 7.5, 9.7);
        Disciplina disciplina = new Disciplina(1L, "AlproII", Collections.singletonList(nota));
        List<Disciplina> disciplinaList = Collections.singletonList(disciplina);
        return new StudentList(Collections.singletonList(
            new Aluno(
                1L,
                "Daniel Christofolli",
                disciplinaList
                )));
    }

    public static List<Disciplina> classesStub(){
        Nota nota = new Nota(8.0, 7.5, 9.7);
        Disciplina disciplina = new Disciplina(1L, "AlproII", Collections.singletonList(nota));
        return Collections.singletonList(disciplina);
    }
}
