package com.dchristofolli.finalgrades.v1.dto;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Nota {
    private Long id;
    @JsonProperty("Prova1")
    private Double test1;
    @JsonProperty("Prova2")
    private Double test2;
    @JsonProperty("Prova3")
    private Double test3;

    public Nota(Long id, Double test1, Double test2, Double test3) {
        this.id = id;
        this.test1 = test1;
        this.test2 = test2;
        this.test3 = test3;
    }

    @Override
    public String toString() {
        return "Nota{" +
            "id=" + id +
            ", Prova1=" + test1 +
            ", Prova2=" + test2 +
            ", Prova3=" + test3 +
            '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @JsonGetter("Prova1")
    public Double getTest1() {
        return test1;
    }

    @JsonSetter("Prova1")
    public void setTest1(Double test1) {
        this.test1 = test1;
    }

    @JsonGetter("Prova2")
    public Double getTest2() {
        return test2;
    }

    @JsonSetter("Prova2")
    public void setTest2(Double test2) {
        this.test2 = test2;
    }

    @JsonGetter("Prova3")
    public Double getTest3() {
        return test3;
    }

    @JsonSetter("Prova3")
    public void setTest3(Double test3) {
        this.test3 = test3;
    }
}
