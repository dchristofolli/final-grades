package com.dchristofolli.finalgrades.v1.dto;

import java.util.List;

public class Disciplina {
    Long id;
    String nome;
    List<Nota> notas;

    public Disciplina(Long id, String nome, List<Nota> notas) {
        this.id = id;
        this.nome = nome;
        this.notas = notas;
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

    public List<Nota> getNotas() {
        return notas;
    }

    public void setNotas(List<Nota> notas) {
        this.notas = notas;
    }

    @Override
    public String toString() {
        return "Disciplina{" +
            "id=" + id +
            ", nome='" + nome + '\'' +
            ", notas=" + notas +
            '}';
    }
}
