package com.dchristofolli.finalgrades.v1.dto;

import java.util.List;

public class StudentList {
    private List<Aluno> alunos;

    public StudentList(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    @Override
    public String toString() {
        return "StudentList{" +
            "students=" + alunos +
            '}';
    }
}
