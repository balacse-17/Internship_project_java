package com.example.student_record_system.model;

public class Student {

    private int rollNo;
    private String name;
    private String department;

    public Student() {

    }

    public Student(int rollNo, String name, String department) {

        this.rollNo = rollNo;
        this.name = name;
        this.department = department;

    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String studentName) {
        this.name = studentName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

}