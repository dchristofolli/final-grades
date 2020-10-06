package com.dchristofolli.finalgrades.v1.service;

import com.dchristofolli.finalgrades.exception.ApiException;
import com.dchristofolli.finalgrades.v1.dto.StudentList;
import com.google.gson.Gson;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
public class JsonReader {
    private final Gson gson;

    public JsonReader(Gson gson) {
        this.gson = gson;
    }

    public StudentList readJsonFile() {
        try {
            String tempJson = new String(Files.readAllBytes(Paths.get("Alunos.json")));
            String json = tempJson.replace("Prova", "prova");
            return new StudentList(gson.fromJson(json, StudentList.class).getAlunos());
        } catch (IOException e) {
            throw new ApiException("Não foi possível ler o arquivo.\n" + e.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
