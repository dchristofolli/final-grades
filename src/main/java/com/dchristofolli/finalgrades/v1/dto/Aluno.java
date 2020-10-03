package com.dchristofolli.finalgrades.v1.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class Aluno {
    @Id
    Long id;
    String nome;
    List<Disciplina> disciplinas;

    public Aluno(Long id, String nome, List<Disciplina> disciplinas) {
        this.id = id;
        this.nome = nome;
        this.disciplinas = disciplinas;
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
