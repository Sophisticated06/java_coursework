package com.example.journal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.journal.model.LabWork;

public class LabWorkDao {
    
    // Сохраняет информацию о лабораторной работе (оценку и посещаемость) в базу данных
    public void save(LabWork labWork) throws SQLException{
        String sql = "INSERT INTO lab_works (title, grade, is_attended, student_id) VALUES (?, ?, ?, ?)";

        try (Connection connection =  DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)){

                statement.setString(1, labWork.getTitle());
                statement.setInt(2, labWork.getGrade());
                statement.setBoolean(3, labWork.isAttended());
                statement.setLong(4, labWork.getStudentId());

                statement.executeUpdate();
        }

    }
// Возвращает список всех лабораторный работ для конкретного студента по его ID
public List<LabWork> findByStudentId(Long studentId) throws SQLException {
        List<LabWork> labWorks = new ArrayList<>();
        String sql = "SELECT id, title, grade, is_attended, student_id FROM lab_works WHERE student_id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setLong(1, studentId);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Long id = resultSet.getLong("id");
                    String title = resultSet.getString("title");
                    int grade = resultSet.getInt("grade");
                    boolean isAttended = resultSet.getBoolean("is_attended");
                    Long studId = resultSet.getLong("student_id");

                    LabWork labWork = new LabWork(id, title, grade, isAttended, studId);
                    labWorks.add(labWork);
                }
            }
        }
        return labWorks;
    }

}
