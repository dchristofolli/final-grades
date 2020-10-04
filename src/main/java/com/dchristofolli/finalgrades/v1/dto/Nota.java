package com.dchristofolli.finalgrades.v1.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSetter;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Nota {
    private Long id;
    private Double prova1;
    private Double prova2;
    private Double prova3;

    @JsonCreator
    public Nota(Long id,
                Double prova1,
                Double prova2,
                Double prova3) {
        this.id = id;
        this.prova1 = prova1;
        this.prova2 = prova2;
        this.prova3 = prova3;
    }

    @Override
    public String toString() {
        return "Nota{" +
            "id=" + id +
            ", prova1=" + prova1 +
            ", prova2=" + prova2 +
            ", prova3=" + prova3 +
            '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @JsonGetter("Prova1")
    public Double getProva1() {
        return prova1;
    }

    @JsonSetter("Prova1")
    public void setProva1(Double prova1) {
        this.prova1 = prova1;
    }

    @JsonGetter("Prova2")
    public Double getProva2() {
        return prova2;
    }

    @JsonSetter("Prova2")
    public void setProva2(Double prova2) {
        this.prova2 = prova2;
    }

    @JsonGetter("Prova3")
    public Double getProva3() {
        return prova3;
    }

    @JsonSetter("Prova3")
    public void setProva3(Double prova3) {
        this.prova3 = prova3;
    }
}
