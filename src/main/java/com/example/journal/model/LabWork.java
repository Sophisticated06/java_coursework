package com.example.journal.model;

public class LabWork {
  
    private Long id;
    private String title;
    private int grade;
    private boolean isAttended;
    private Long studentId;

    public LabWork(){}

    public LabWork(Long id, String title, int grade, boolean isAttended, Long studentId) {
        this.id = id;
        this.title = title;
        this.grade = grade;
        this.isAttended = isAttended;
        this.studentId = studentId;
    }

    public LabWork(String title, int grade, boolean isAttended, Long studentId) {
        this.title = title;
        this.grade = grade;
        this.isAttended = isAttended;
        this.studentId = studentId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public boolean isAttended() {
        return isAttended;
    }

    public void setAttended(boolean attended) {
        isAttended = attended;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }
}
