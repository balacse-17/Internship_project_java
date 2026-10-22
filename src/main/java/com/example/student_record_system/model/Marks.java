package com.example.student_record_system.model;

public class Marks {

    private int rollNo;

    private int tamil;

    private int english;

    private int maths;

    private int science;

    private int social;

    private String name;

    private String grade;

    public Marks() {

    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public int getTamil() {
        return tamil;
    }

    public void setTamil(int tamil) {
        this.tamil = tamil;
    }

    public int getEnglish() {
        return english;
    }

    public void setEnglish(int english) {
        this.english = english;
    }

    public int getMaths() {
        return maths;
    }

    public void setMaths(int maths) {
        this.maths = maths;
    }

    public int getScience() {
        return science;
    }

    public void setScience(int science) {
        this.science = science;
    }

    public int getSocial() {
        return social;
    }

    public void setSocial(int social) {
        this.social = social;
    }

    public String getName() {
        return name;
    }

    public void setName(String studentName) {
        this.name = studentName;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

}