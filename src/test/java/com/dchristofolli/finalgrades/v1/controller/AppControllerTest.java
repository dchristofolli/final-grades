//package com.dchristofolli.finalgrades.v1.controller;
//
//import com.dchristofolli.finalgrades.v1.dto.StudentList;
//import com.dchristofolli.finalgrades.v1.service.GradeService;
//import com.dchristofolli.finalgrades.v1.service.JsonReader;
//import com.dchristofolli.finalgrades.v1.stub.Stub;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.BDDMockito;
//import org.mockito.InjectMocks;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.ActiveProfiles;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import org.springframework.test.web.servlet.MockMvc;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@ActiveProfiles("test")
//@ExtendWith(SpringExtension.class)
//@WebMvcTest(controllers = AppController.class)
//@ContextConfiguration(classes = {
//    AppController.class,
//    GradeService.class,
//    JsonReader.class
//})
//@AutoConfigureMockMvc
//class AppControllerTest {
//    @Autowired
//    MockMvc mockMvc;
//
//    @MockBean
//    JsonReader jsonReader;
//
//    @InjectMocks
//    AppController controller;
//
//    @Test
//    void findAllStudents() throws Exception {
//        StudentList studentList = Stub.studentListStub();
//        BDDMockito.when(jsonReader.readJsonFile()).thenReturn(studentList);
//        controller.findAllStudents();
//        mockMvc.perform(get("/v1/final-grades/students")).andExpect(status().isOk());
//    }
//
//    @Test
//    void findAllClasses() {
//
//    }
//
//    @Test
//    void getResultsByClass() {
//    }
//}