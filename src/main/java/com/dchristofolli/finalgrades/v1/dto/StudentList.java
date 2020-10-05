package com.dchristofolli.finalgrades.v1.dto;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

public class StudentList {
    @ApiModelProperty(notes = "Lista com os dados de todos os alunos")
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
