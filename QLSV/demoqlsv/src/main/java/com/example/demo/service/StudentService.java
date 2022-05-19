package com.example.demo.service;

import com.example.demo.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudent();

    Student getStudentById(int id);

    Student addStudent(Student student);

    Student updateStudent(Student student, int id);

    void deleteStudent(int id);

    List<Student> getStudentOfKhoa(int khoa_id);

}
