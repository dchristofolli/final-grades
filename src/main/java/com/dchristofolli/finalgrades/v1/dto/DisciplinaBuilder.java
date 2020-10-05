package com.dchristofolli.finalgrades.v1.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public final class DisciplinaBuilder {
    private Long id;
    private String nome;
    private List<Nota> notas;

    private DisciplinaBuilder() {
    }

    public static DisciplinaBuilder aDisciplina() {
        return new DisciplinaBuilder();
    }

    public DisciplinaBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public DisciplinaBuilder withNome(String nome) {
        this.nome = nome;
        return this;
    }

    public DisciplinaBuilder withNotas(List<Nota> notas) {
        this.notas = notas;
        return this;
    }

    public Disciplina build() {
        return new Disciplina(id, nome, notas);
    }
}
