package com.dchristofolli.finalgrades.v1.dto;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

public class GradeResult {
    @ApiModelProperty(notes = "Identificador único da disciplina",
        example = "1")
    private Long idDisciplina;

    @ApiModelProperty(notes = "Nome da disciplina",
        example = "Alpro-II")
    private String nomeDisciplina;

    @ApiModelProperty(notes = "Lista com as notas finais dos alunos")
    private List<AlunoResult> alunoResults;

    public GradeResult() {
    }

    public GradeResult(Long idDisciplina, String nomeDisciplina, List<AlunoResult> alunoResults) {
        this.idDisciplina = idDisciplina;
        this.nomeDisciplina = nomeDisciplina;
        this.alunoResults = alunoResults;
    }

    public Long getIdDisciplina() {
        return idDisciplina;
    }

    public void setIdDisciplina(Long idDisciplina) {
        this.idDisciplina = idDisciplina;
    }

    public String getNomeDisciplina() {
        return nomeDisciplina;
    }

    public void setNomeDisciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
    }

    public List<AlunoResult> getAlunoResults() {
        return alunoResults;
    }

    public void setAlunoResults(List<AlunoResult> alunoResults) {
        this.alunoResults = alunoResults;
    }

    @Override
    public String toString() {
        return "GradeResult{" +
            "idDisciplina=" + idDisciplina +
            ", nomeDisciplina='" + nomeDisciplina + '\'' +
            ", alunoResults=" + alunoResults +
            '}';
    }
}
