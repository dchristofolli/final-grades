package com.dchristofolli.finalgrades.v1.service;

import com.dchristofolli.finalgrades.v1.dto.StudentList;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
public class GradeService {
    private final Logger logger = LoggerFactory.getLogger(GradeService.class);
    private final Gson gson;

    public GradeService(Gson gson) {
        this.gson = gson;
    }

    @PostConstruct
    public void jsonReader() {
        String json = null;
        try {
            json = String.join(" ",
                Files.readAllLines(Paths.get("Alunos.json"),
                    StandardCharsets.UTF_8));
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
        StudentList studentList = gson.fromJson(json, StudentList.class);
        logger.info("Students found: {}", studentList);
    }
}
