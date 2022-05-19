package com.example.demo.service;

import com.example.demo.entity.Student;
import com.example.demo.exception.NotFoundException;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudent() {
        List<Student> listStudent = studentRepository.findAll();
        return listStudent;
    }

    @Override
    public Student getStudentById(int id) {
        Optional<Student> student = studentRepository.findById(id);
        if (student.isPresent()) {
            return student.get();
        } else
            throw new NotFoundException("No student found by Id: " + id);
    }


    @Override
    public Student addStudent(Student student) {
        if (student == null) {
            throw new NotFoundException("Can not create student");
        }
        return studentRepository.save(student);
    }

    @Override
    public Student updateStudent(Student student, int id) {
        Optional<Student> std = studentRepository.findById(id);
        if (std.isPresent()) {
            std.get().setName(student.getName());
            std.get().setBirthday(student.getBirthday());
            std.get().setGender(student.getGender());
        } else
            throw new NotFoundException("No student found ID: " + id);

        try {
            studentRepository.save(student);
            return student;
        } catch (Exception ex) {
            throw new IllegalArgumentException("Database error. Can't update user");
        }
    }

    @Override
    public void deleteStudent(int id) {
        Optional<Student> std = studentRepository.findById(id);
        if (std.isPresent()) {
            studentRepository.deleteById(id);
        } else
            throw new NotFoundException("No student found ID: " + id);

    }

    @Override
    public List<Student> getStudentOfKhoa(int khoa_id) {
        List<Student> listStd = studentRepository.getStudentKhoa(khoa_id);
        return listStd;
    }
}
