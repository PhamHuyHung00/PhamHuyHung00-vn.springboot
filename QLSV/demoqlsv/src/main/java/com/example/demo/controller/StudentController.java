package com.example.demo.controller;

import com.example.demo.entity.Student;
import com.example.demo.exception.NotFoundException;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/student/all")
    public ResponseEntity<List<Student>> getAll() {
        List<Student> listStudent = studentService.getAllStudent();
        return new ResponseEntity<List<Student>>(listStudent, HttpStatus.OK);
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<?> getStudent(@PathVariable("id") int id) {
        Student std = studentService.getStudentById(id);
        return ResponseEntity.ok(std);
    }


    @GetMapping("/student/khoa/{id}")
    public ResponseEntity<?> getStudentOfKhoa(@PathVariable("id") int id) {
        List<Student> listStd = studentService.getStudentOfKhoa(id);
        if (listStd.size() > 0) {
            return ResponseEntity.ok(listStd);
        } else {
            throw new NotFoundException("Not Found Student of Khoa: " + id);
        }
    }

    @PostMapping("/student/add")
    public ResponseEntity<?> addStudent(@RequestBody Student std) {
        Student dataStd = studentService.addStudent(std);
        return ResponseEntity.ok(dataStd);
    }

    @PutMapping("/student/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable("id") int id, @RequestBody Student std) {
        studentService.updateStudent(std, id);
        return ResponseEntity.ok(std);
    }

    @DeleteMapping("/student/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable("id") int id) {
        studentService.deleteStudent(id);
        return ResponseEntity.ok("Delete success !!!");

    }


}
