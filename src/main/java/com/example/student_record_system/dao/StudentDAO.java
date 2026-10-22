package com.example.student_record_system.dao;

import com.example.student_record_system.DBConnection;
import com.example.student_record_system.model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    // Get total number of students
    public int getStudentCount() {

        int count = 0;

        String sql = "SELECT COUNT(*) FROM students";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            if(rs.next()){

                count = rs.getInt(1);

            }

            con.close();

        }
        catch(Exception e){

            e.printStackTrace();

        }

        return count;

    }

    // Get all students
    public List<Student> getAllStudents(){

        List<Student> list = new ArrayList<>();

        String sql = "SELECT * FROM students ORDER BY roll_no";

        try{

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){

                Student student = new Student();

                student.setRollNo(rs.getInt("roll_no"));
                student.setName(rs.getString("student_name"));
                student.setDepartment(rs.getString("department"));

                list.add(student);

            }

            con.close();

        }
        catch(Exception e){

            e.printStackTrace();

        }

        return list;

    }

    // Search student by roll number
    public Student getStudentByRollNo(int rollNo){

        Student student = null;

        String sql = "SELECT * FROM students WHERE roll_no=?";

        try{

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, rollNo);

            ResultSet rs = ps.executeQuery();

            if(rs.next()){

                student = new Student();

                student.setRollNo(rs.getInt("roll_no"));
                student.setName(rs.getString("student_name"));
                student.setDepartment(rs.getString("department"));

            }

            con.close();

        }
        catch(Exception e){

            e.printStackTrace();

        }

        return student;

    }

}