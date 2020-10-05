package com.dchristofolli.finalgrades.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.http.HttpStatus;

import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
class ErrorModel {
    @ApiModelProperty(notes = "Mensagem que será exibida no corpo da resposta, em caso de erro",
        example = "Invalid form")
    String message;

    @ApiModelProperty(notes = "Classe da exceção que foi chamada",
        example = "org.springframework.web.bind.MethodArgumentNotValidException")
    String error;

    @ApiModelProperty(notes = "Status http da resposta",
        example = "BAD_REQUEST")
    HttpStatus status;

    @ApiModelProperty(notes = "Status http da resposta",
        example = "\"formErrors\": {\n" +
            "    \"description\": \"O campo deve ser preenchido\"\n" +
            "  }")
    Map<String, String> formErrors;

    public ErrorModel(String message, String error, HttpStatus status, Map<String, String> formErrors) {
        this.message = message;
        this.error = error;
        this.status = status;
        this.formErrors = formErrors;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public Map<String, String> getFormErrors() {
        return formErrors;
    }

    public void setFormErrors(Map<String, String> formErrors) {
        this.formErrors = formErrors;
    }

    @Override
    public String toString() {
        return "ErrorModel{" +
            "message='" + message + '\'' +
            ", error='" + error + '\'' +
            ", status=" + status +
            ", formErrors=" + formErrors +
            '}';
    }
}
