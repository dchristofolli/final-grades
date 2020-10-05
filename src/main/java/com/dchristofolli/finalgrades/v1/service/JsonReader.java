package com.dchristofolli.finalgrades.v1.service;

import com.dchristofolli.finalgrades.exception.ApiException;
import com.dchristofolli.finalgrades.v1.dto.StudentList;
import com.google.gson.Gson;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;

@Service
public class JsonReader {
    private final Gson gson;
    private static final String DELIMITER = " ";
    private static final String JSON_PATH = "Alunos.json";

    public JsonReader(Gson gson) {
        this.gson = gson;
    }

    public StudentList readJsonFile() {
        try {
            String tempJson = String.join(DELIMITER,
                Files.readAllLines(Paths.get(JSON_PATH),
                    StandardCharsets.UTF_8));
            String json = Objects.requireNonNull(tempJson).replace("Prova", "prova");
            return new StudentList(gson.fromJson(json, StudentList.class).getAlunos());
        } catch (IOException e) {
            throw new ApiException("Não foi possível ler o arquivo.\n" + e.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
