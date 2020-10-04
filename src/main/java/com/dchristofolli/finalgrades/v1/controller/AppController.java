package com.dchristofolli.finalgrades.v1.controller;

import com.dchristofolli.finalgrades.v1.dto.Disciplina;
import com.dchristofolli.finalgrades.v1.dto.StudentList;
import com.dchristofolli.finalgrades.v1.service.StudentService;
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
    private final StudentService studentService;

    public AppController(StudentService studentService) {
        this.studentService = studentService;
    }

    @ApiOperation("Find all students")
    @ApiResponses({
        @ApiResponse(code = 200, message = "Sessions found"),
        @ApiResponse(code = 500, message = "Bad server")
    })
    @GetMapping("/students")
    public StudentList Students() {
        return studentService.findAllStudent();
    }
    @ApiOperation("Find all subjects")
    @ApiResponses({
        @ApiResponse(code = 200, message = "Subjects found"),
        @ApiResponse(code = 500, message = "Bad server")
    })
    @GetMapping("/subjects")
    public List<Disciplina> findAllSubjects() {
        return studentService.findAllSubjects();
    }
}
