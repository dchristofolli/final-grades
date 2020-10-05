package com.dchristofolli.finalgrades.v1.controller;

import com.dchristofolli.finalgrades.v1.dto.Disciplina;
import com.dchristofolli.finalgrades.v1.dto.GradeRequest;
import com.dchristofolli.finalgrades.v1.dto.GradeResult;
import com.dchristofolli.finalgrades.v1.dto.StudentList;
import com.dchristofolli.finalgrades.v1.service.GradeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@Api(value = "PUC Final Grades")
@RequestMapping(path = "/v1/final-grades")
public class AppController {
    private final GradeService gradeService;

    public AppController(GradeService gradeService) {
        this.gradeService = gradeService;
    }

    @ApiOperation("Lista todos os alunos com as disciplinas nas quais estão matriculados e as notas obtidas nas provas")
    @ApiResponses({
        @ApiResponse(code = 200, message = "Informações exibidas com sucesso"),
        @ApiResponse(code = 500, message = "Erro inesperado")
    })
    @GetMapping("/students")
    public StudentList findAllStudents() {
        return gradeService.findAllStudent();
    }

    @ApiOperation("Lista todas as disciplinas")
    @ApiResponses({
        @ApiResponse(code = 200, message = "Disciplinas listadas com sucesso"),
        @ApiResponse(code = 500, message = "Ocorreu um erro inesperado")
    })
    @GetMapping("/classes")
    public List<Disciplina> findAllClasses() {
        return gradeService.findAllClasses();
    }

    @ApiOperation("Calcula e exibe as notas finais dos alunos matriculados por disciplina")
    @ApiResponses({
        @ApiResponse(code = 200, message = "Notas finais exibidas com sucesso"),
        @ApiResponse(code = 500, message = "Ocorreu um erro inesperado")
    })
    @GetMapping("/results")
    public GradeResult getResultsByClass(@Valid GradeRequest gradeRequest) {
        return gradeService.getResultsByClass(gradeRequest);
    }
}
