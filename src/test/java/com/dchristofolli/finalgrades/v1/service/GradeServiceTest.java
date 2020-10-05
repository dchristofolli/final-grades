package com.dchristofolli.finalgrades.v1.service;

import com.dchristofolli.finalgrades.v1.dto.StudentList;
import com.google.gson.Gson;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
class GradeServiceTest {
    @Mock
    Gson gson;

    GradeService gradeService;

    public GradeServiceTest(GradeService gradeService) {
        this.gradeService = gradeService;
    }

    @Value("${file.path}")
    static String jsonFilePath;

    static String tempJson, json;
    static StudentList studentList;

    @BeforeAll
    static void setup() throws IOException {
        Gson gson = new Gson();
        tempJson = String.join(" ",
            Files.readAllLines(Paths.get(jsonFilePath),
                StandardCharsets.UTF_8));
        String json = tempJson.replace("Prova", "prova");
        studentList = new StudentList(gson.fromJson(json, StudentList.class).getAlunos());
//        BDDMockito.when(gson.fromJson(json, StudentList.class)).thenReturn(studentList);
    }

//    @Test
//    void findAllStudents() {
//        gradeService.readJsonFile();
//        Assertions.assertEquals(studentList, gson.fromJson(json, StudentList.class));
//    }

//    @Test
//    void findAllClasses() {
//        List<Disciplina> disciplinaList = Stub.classesStub();
//        gradeService.findAllClasses();
//        Assertions.assertEquals(disciplinaList, );
//    }

    @Test
    void getResultsByClass() {
    }
}