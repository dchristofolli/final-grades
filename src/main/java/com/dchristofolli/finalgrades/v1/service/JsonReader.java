package com.dchristofolli.finalgrades.v1.service;

import com.dchristofolli.finalgrades.v1.dto.StudentList;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;

@Service
public class JsonReader {
    private final Logger logger = LoggerFactory.getLogger(JsonReader.class);
    private final Gson gson;
    @Value("${file.path}")
    private String jsonFilePath;

    public JsonReader(Gson gson) {
        this.gson = gson;
    }

    public StudentList readJsonFile() {
        String tempJson = null;
        try {
            tempJson = String.join(" ",
                Files.readAllLines(Paths.get(jsonFilePath),
                    StandardCharsets.UTF_8));
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
        String json = Objects.requireNonNull(tempJson).replace("Prova", "prova");
        return new StudentList(gson.fromJson(json, StudentList.class).getAlunos());
    }
}
