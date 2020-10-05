package com.dchristofolli.finalgrades.v1.dto;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

public class Aluno {
    @ApiModelProperty(notes = "Identificador único do aluno",
    example = "1")
    Long id;
    @ApiModelProperty(notes = "Nome completo do aluno",
    example = "João Silva")
    String nome;
    @ApiModelProperty(notes = "Disciplinas que o aluno está matriculado",
    example =
        "[\n" +
        "    Alpro-II,\n" +
        "    Calculo-A\n" +
        "]")
    List<Disciplina> disciplinas;

    public Aluno(Long id, String nome, List<Disciplina> disciplinas) {
        this.id = id;
        this.nome = nome;
        this.disciplinas = disciplinas;
    }

    public Aluno() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    @Override
    public String toString() {
        return "Aluno{" +
            "id=" + id +
            ", nome='" + nome + '\'' +
            ", disciplinas=" + disciplinas +
            '}';
    }
}
