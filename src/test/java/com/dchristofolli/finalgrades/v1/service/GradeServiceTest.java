//package com.dchristofolli.finalgrades.v1.service;
//
//import com.dchristofolli.finalgrades.v1.dto.Disciplina;
//import com.dchristofolli.finalgrades.v1.dto.StudentList;
//import com.dchristofolli.finalgrades.v1.stub.Stub;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.BDDMockito;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import java.util.List;
//
//@ExtendWith(SpringExtension.class)
//class GradeServiceTest {
//    @Mock
//    JsonReader jsonReader;
//
//    @InjectMocks
//    GradeService gradeService;
//
//    static String tempJson, json;
//    static StudentList studentList;
//
//    @BeforeEach
//    void setup() {
//        BDDMockito.when(jsonReader.readJsonFile()).thenCallRealMethod();
//    }
//
//    @Test
//    void findAllStudents() {
//        gradeService.findAllStudent();
//        Assertions.assertEquals(1, gradeService.findAllStudent().getAlunos().size());
//    }
//
//    @Test
//    void findAllClasses() {
//        List<Disciplina> disciplinaList = Stub.classesStub();
//        gradeService.findAllClasses();
//        Assertions.assertEquals(disciplinaList, );
//    }
//
//    @Test
//    void getResultsByClass() {
//    }
//}