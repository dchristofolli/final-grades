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

import java.util.List;

@RestController
@Api(value = "PUC Final Grades")
@RequestMapping(path = "/v1/final-grades")
public class AppController {
    private final GradeService gradeService;

    public AppController(GradeService gradeService) {
        this.gradeService = gradeService;
    }

    @ApiOperation("Find all students")
    @ApiResponses({
        @ApiResponse(code = 200, message = "Sessions found"),
        @ApiResponse(code = 500, message = "Bad server")
    })
    @GetMapping("/students")
    public StudentList findAllStudents() {
        return gradeService.findAllStudents();
    }

    @ApiOperation("Find all classes")
    @ApiResponses({
        @ApiResponse(code = 200, message = "Classes found"),
        @ApiResponse(code = 500, message = "Bad server")
    })
    @GetMapping("/classes")
    public List<Disciplina> findAllClasses() {
        return gradeService.findAllClasses();
    }

    @ApiOperation("Get results")
    @ApiResponses({
        @ApiResponse(code = 200, message = "Results found"),
        @ApiResponse(code = 500, message = "Bad server")
    })
    @GetMapping("/results")
    public GradeResult getResultsByClass(GradeRequest gradeRequest) {
        return gradeService.getResultsByClass(gradeRequest);
    }
}
