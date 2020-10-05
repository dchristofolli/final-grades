package com.dchristofolli.finalgrades.v1.controller;

import com.dchristofolli.finalgrades.domain.ClassRepository;
import com.dchristofolli.finalgrades.domain.StudentRepository;
import com.dchristofolli.finalgrades.v1.dto.Aluno;
import com.dchristofolli.finalgrades.v1.dto.Disciplina;
import com.dchristofolli.finalgrades.v1.dto.GradeRequest;
import com.dchristofolli.finalgrades.v1.dto.GradeResult;
import com.dchristofolli.finalgrades.v1.service.GradeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = AppController.class)
@ContextConfiguration(classes = {
    AppController.class,
    GradeService.class
})
@AutoConfigureMockMvc
class AppControllerTest {
    @Autowired
    MockMvc mockMvc;
    @Mock
    GradeService gradeService;
    @MockBean
    StudentRepository studentRepository;
    @MockBean
    ClassRepository classRepository;

    @Test
    void findAllStudents_shouldListAllStudents_whenOk() throws Exception {
        List<Aluno> alunos = Stub.studentListStub().getAlunos();
        BDDMockito.when(studentRepository.findAll()).thenReturn(alunos);
        mockMvc.perform(MockMvcRequestBuilders.get("/v1/final-grades/students"))
            .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void findAllClasses() throws Exception {
        List<Disciplina> disciplinas = Stub.disciplinaListStub();
        BDDMockito.when(classRepository.findAll()).thenReturn(disciplinas);
        mockMvc.perform(MockMvcRequestBuilders.get("/v1/final-grades/classes"))
            .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void getResultsByClass() throws Exception {
        GradeRequest request = Stub.gradeRequestStub();
        GradeResult gradeResult = Stub.gradeResultStub();
        BDDMockito.when(gradeService.getResultsByClass(request)).thenReturn(gradeResult);
        mockMvc.perform(MockMvcRequestBuilders.get("/v1/final-grades/classes"))
            .andExpect(MockMvcResultMatchers.status().isOk());
    }
}