package com.dchristofolli.finalgrades.v1.service;

import com.dchristofolli.finalgrades.domain.ClassRepository;
import com.dchristofolli.finalgrades.domain.StudentRepository;
import com.dchristofolli.finalgrades.v1.Stub;
import com.dchristofolli.finalgrades.v1.dto.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

@ExtendWith(SpringExtension.class)
class GradeServiceTest {
    @Mock
    StudentRepository studentRepository;
    @Mock
    ClassRepository classRepository;
    @InjectMocks
    GradeService gradeService;

    @Test
    void findAllStudent() {
        List<Aluno> alunos = Stub.studentListStub().getAlunos();
        StudentList studentList = new StudentList(alunos);
        BDDMockito.when(studentRepository.findAll()).thenReturn(alunos);
        gradeService.findAllStudent();
        Assertions.assertEquals(studentList.getAlunos(), gradeService.findAllStudent().getAlunos());
    }

    @Test
    void findAllClasses() {
        List<Disciplina> disciplinaList = Stub.disciplinaListStub();
        BDDMockito.when(classRepository.findAll()).thenReturn(disciplinaList);
        Assertions.assertEquals(disciplinaList, gradeService.findAllClasses());
    }

    @Test
    void getResultsByClass() {
        GradeRequest request = Stub.gradeRequestStub();
        GradeResult result = Stub.gradeResultStub();
        BDDMockito.when(classRepository.findAll()).thenReturn(Stub.disciplinaListStub());
        Assertions.assertEquals(result.getIdDisciplina(),
            gradeService.getResultsByClass(request).getIdDisciplina());
    }
}