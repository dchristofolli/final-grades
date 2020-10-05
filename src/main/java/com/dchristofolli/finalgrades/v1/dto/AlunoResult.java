package com.dchristofolli.finalgrades.v1.dto;

import io.swagger.annotations.ApiModelProperty;

public class AlunoResult {
    @ApiModelProperty(notes = "Identificador único do aluno",
        example = "1")
    private Long id;

    @ApiModelProperty(notes = "Nome completo do aluno",
        example = "João Silva")
    private String nome;

    @ApiModelProperty(notes = "Nota final do aluno, formada por (Prova1 * Peso1 + Prova2 * Peso2 + Prova3 * Peso3) / 3",
    example = "8.5")
    private double notaFinal;

    public AlunoResult() {
    }

    public AlunoResult(Long id, String nome, double notaFinal) {
        this.id = id;
        this.nome = nome;
        this.notaFinal = notaFinal;
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

    public double getNotaFinal() {
        return notaFinal;
    }

    public void setNotaFinal(double notaFinal) {
        this.notaFinal = notaFinal;
    }
}
