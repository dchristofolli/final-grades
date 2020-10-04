package com.dchristofolli.finalgrades.v1.dto;

public class GradeRequest {
    private Long diciplinaId;
    private Integer peso1;
    private Integer peso2;
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
