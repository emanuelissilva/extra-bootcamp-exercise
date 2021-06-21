package com.bootcamp.sortition.controller;

import com.bootcamp.sortition.model.Student;
import com.bootcamp.sortition.service.StudentServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    private final StudentServiceImpl studentService;

    public StudentController(StudentServiceImpl studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Student>> getStudent() {
        List<Student> student1 = studentService.randomStudents();
        return new ResponseEntity<>(student1, HttpStatus.OK);
    }
}
