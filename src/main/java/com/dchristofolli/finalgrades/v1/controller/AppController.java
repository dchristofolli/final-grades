package com.dchristofolli.finalgrades.v1.controller;

import com.dchristofolli.finalgrades.v1.dto.StudentList;
import com.dchristofolli.finalgrades.v1.service.GradeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        return gradeService.studentListReader();
    }

//    @ApiOperation("Find all subjects")
//    @ApiResponses({
//        @ApiResponse(code = 200, message = "Subjects found"),
//        @ApiResponse(code = 500, message = "Bad server")
//    })
//    @GetMapping("/subjects")
//    public List<Disciplina> findAllSubjects() {
//        return gradeService.findAllSubjects();
//    }

//    @ApiOperation("Get results")
//    @ApiResponses({
//        @ApiResponse(code = 200, message = "Results found"),
//        @ApiResponse(code = 500, message = "Bad server")
//    })
//    @GetMapping("/results")
//    public GradeResult getResults(@RequestBody GradeRequest gradeRequest) {
//        return null;
//    }
}
