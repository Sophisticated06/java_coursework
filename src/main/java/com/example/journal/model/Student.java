package com.example.journal.model;

public class Student{
    private Long id;
    private String fullName;
    private String groupName;
    private String cardId;

    public Student(){} // Конструктор по умолчанию. Нужен для SQL-запросов к БД

    public Student(Long id, String fullName, String groupName, String cardId) {
        this.id = id;
        this.fullName = fullName;
        this.groupName = groupName;
        this.cardId = cardId;
    }

    public Student(String fullName, String groupName, String cardId) {
        this.fullName = fullName;
        this.groupName = groupName;
        this.cardId = cardId;}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

}