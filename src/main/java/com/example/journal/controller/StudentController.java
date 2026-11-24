package com.example.journal.controller;

import java.sql.SQLException;
import java.util.List;

import com.example.journal.dao.StudentDao;
import com.example.journal.model.Student;

public class StudentController {

    private final StudentDao studentDao;

    public StudentController(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public void addStudent(String fullName, String groupName, String cardId) throws SQLException {
        if (fullName == null || fullName.isBlank()) {
            throw new IllegalArgumentException("ФИО студента не может быть пустым");
        }
        if (groupName == null || groupName.isBlank()) {
            throw new IllegalArgumentException("Название группы не может быть пустым");
        }

        Student student = new Student(fullName.trim(), groupName.trim(), cardId);
        studentDao.save(student);
    }

    public List<Student> getAllStudents() throws SQLException {
        return studentDao.findAll();
    }
}