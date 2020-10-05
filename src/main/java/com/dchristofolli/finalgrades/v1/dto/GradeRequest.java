package com.dchristofolli.finalgrades.v1.dto;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;

public class GradeRequest {
    @ApiModelProperty(
        notes = "ID da disciplina que terá as notas finais exibidas",
        required = true,
        example = "1",
    allowableValues = "1, 2, 3, 4")
    @NotBlank(message = "Campo obrigatório")
    private Long diciplinaId;

    @ApiModelProperty(notes = "Peso da prova 1. Será usado no cálculo da nota final." +
        " Caso o campo não seja preenchido, o peso da prova será definido como 1",
    example = "1")
    private Integer peso1;

    @ApiModelProperty(notes = "Peso da prova 2. Será usado no cálculo da nota final." +
        " Caso o campo não seja preenchido, o peso da prova será definido como 1",
        example = "1")
    private Integer peso2;

    @ApiModelProperty(notes = "Peso da prova 3. Será usado no cálculo da nota final." +
        " Caso o campo não seja preenchido, o peso da prova será definido como 1",
        example = "1")
    private Integer peso3;

    public GradeRequest(Long diciplinaId, Integer peso1, Integer peso2, Integer peso3) {
        this.diciplinaId = diciplinaId;
        this.peso1 = peso1;
        this.peso2 = peso2;
        this.peso3 = peso3;
    }

    public Long getDiciplinaId() {
        return diciplinaId;
    }

    public void setDiciplinaId(Long diciplinaId) {
        this.diciplinaId = diciplinaId;
    }

    public Integer getPeso1() {
        return peso1;
    }

    public void setPeso1(Integer peso1) {
        this.peso1 = peso1;
    }

    public Integer getPeso2() {
        return peso2;
    }

    public void setPeso2(Integer peso2) {
        this.peso2 = peso2;
    }

    public Integer getPeso3() {
        return peso3;
    }

    public void setPeso3(Integer peso3) {
        this.peso3 = peso3;
    }
}
