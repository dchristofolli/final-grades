package com.dchristofolli.finalgrades.v1.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Nota {
    @ApiModelProperty(notes = "Nota da primeira prova")
    private Double prova1;

    @ApiModelProperty(notes = "Nota da segunda prova")
    private Double prova2;

    @ApiModelProperty(notes = "Nota da terceira prova")
    private Double prova3;

    public Nota(Double prova1,
                Double prova2,
                Double prova3) {
        this.prova1 = prova1;
        this.prova2 = prova2;
        this.prova3 = prova3;
    }

    @Override
    public String toString() {
        return "Nota{" +
            ", prova1=" + prova1 +
            ", prova2=" + prova2 +
            ", prova3=" + prova3 +
            '}';
    }

    public Double getProva1() {
        return prova1;
    }

    public void setProva1(Double prova1) {
        this.prova1 = prova1;
    }

    public Double getProva2() {
        return prova2;
    }

    public void setProva2(Double prova2) {
        this.prova2 = prova2;
    }

    public Double getProva3() {
        return prova3;
    }

    public void setProva3(Double prova3) {
        this.prova3 = prova3;
    }
}
