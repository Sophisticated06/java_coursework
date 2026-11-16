package com.example.journal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.journal.model.Student;

public class StudentDao {
    
// Метод сохранения нового студента в БД
    public void save(Student student) throws SQLException {
        String sql = "INSERT INTO students (full_name, group_name, card_id) VALUES (?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, student.getFullName());
            statement.setString(2, student.getGroupName());
            statement.setString(3, student.getCardId());

            statement.executeUpdate();
        }
    }
    
    
    // Возвращем список всех студентов из БД. 
    // ResultSet для построчного чтения данных через курсор
    
    public List<Student> findAll() throws SQLException {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT id, full_name, group_name, card_id FROM students";

        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                Long id = resultSet.getLong("id"); 
                String fullName = resultSet.getString("full_name");
                String groupName = resultSet.getString("group_name");
                String cardId = resultSet.getString("card_id");

                // Собираем объект Student и добавляем в общий список
                Student student = new Student(id, fullName, groupName, cardId);
                students.add(student);
            }
        }
        return students;
    }   
}
