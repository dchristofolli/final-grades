//package com.dchristofolli.finalgrades.v1.controller;
//
//import com.dchristofolli.finalgrades.v1.dto.StudentList;
//import com.dchristofolli.finalgrades.v1.service.GradeService;
//import com.dchristofolli.finalgrades.v1.service.JsonText;
//import com.google.gson.Gson;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.BDDMockito;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
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
//    Gson.class
//})
//@AutoConfigureMockMvc
//class AppControllerTest {
//    @Autowired
//    MockMvc mockMvc;
//
//    @MockBean
//    Gson gson;
//
//    @InjectMocks
//    AppController controller;
//
//    @Value("${file.path}")
//    String jsonFilePath;
//
//    @Test
//    void findAllStudents() throws Exception {
//        String tempJson = String.join(" ", JsonText.jsonString());
//        String json = tempJson.replace("Prova", "prova");
//        StudentList studentList = gson.fromJson(json, StudentList.class);
//        BDDMockito.when(gson.fromJson(json, StudentList.class)).thenReturn(studentList);
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