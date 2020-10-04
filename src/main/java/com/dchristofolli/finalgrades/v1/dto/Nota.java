package com.dchristofolli.finalgrades.v1.dto;

import com.fasterxml.jackson.annotation.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Nota {
    private Long id;
    private Double Prova1;
    private Double Prova2;
    private Double Prova3;

    @JsonCreator
    public Nota(Long id,
                @JsonProperty("Prova1") Double prova1,
                @JsonProperty("Prova2") Double prova2,
                @JsonProperty("Prova3") Double prova3) {
        this.id = id;
        this.Prova1 = prova1;
        this.Prova2 = prova2;
        this.Prova3 = prova3;
    }

    @Override
    public String toString() {
        return "Nota{" +
            "id=" + id +
            ", Prova1=" + Prova1 +
            ", Prova2=" + Prova2 +
            ", Prova3=" + Prova3 +
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
        return Prova1;
    }

    @JsonSetter("Prova1")
    public void setProva1(Double prova1) {
        this.Prova1 = prova1;
    }

    @JsonGetter("Prova2")
    public Double getProva2() {
        return Prova2;
    }

    @JsonSetter("Prova2")
    public void setProva2(Double prova2) {
        this.Prova2 = prova2;
    }

    @JsonGetter("Prova3")
    public Double getProva3() {
        return Prova3;
    }

    @JsonSetter("Prova3")
    public void setProva3(Double prova3) {
        this.Prova3 = prova3;
    }
}
