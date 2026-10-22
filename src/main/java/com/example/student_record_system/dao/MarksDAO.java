package com.example.student_record_system.dao;

import com.example.student_record_system.DBConnection;
import com.example.student_record_system.model.Marks;
import com.example.student_record_system.util.GradeCalculator;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MarksDAO {

    // Insert new marks or update existing marks
    public void saveMarks(Marks marks) {

        String sql = "INSERT INTO marks (roll_no, tamil, english, maths, science, social) " +
                     "VALUES (?, ?, ?, ?, ?, ?) " +
                     "ON DUPLICATE KEY UPDATE " +
                     "tamil=?, english=?, maths=?, science=?, social=?";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            // Insert values
            ps.setInt(1, marks.getRollNo());
            ps.setInt(2, marks.getTamil());
            ps.setInt(3, marks.getEnglish());
            ps.setInt(4, marks.getMaths());
            ps.setInt(5, marks.getScience());
            ps.setInt(6, marks.getSocial());

            // Update values
            ps.setInt(7, marks.getTamil());
            ps.setInt(8, marks.getEnglish());
            ps.setInt(9, marks.getMaths());
            ps.setInt(10, marks.getScience());
            ps.setInt(11, marks.getSocial());

            ps.executeUpdate();

            con.close();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    // Get all students with marks
    public List<Marks> getAllMarks() {

        List<Marks> list = new ArrayList<>();

        String sql =
                "SELECT s.roll_no, s.student_name, " +
                "m.tamil, m.english, m.maths, m.science, m.social " +
                "FROM students s " +
                "INNER JOIN marks m ON s.roll_no = m.roll_no " +
                "ORDER BY s.roll_no";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Marks marks = new Marks();

                marks.setRollNo(rs.getInt("roll_no"));
                marks.setName(rs.getString("student_name"));

                marks.setTamil(rs.getInt("tamil"));
                marks.setEnglish(rs.getInt("english"));
                marks.setMaths(rs.getInt("maths"));
                marks.setScience(rs.getInt("science"));
                marks.setSocial(rs.getInt("social"));

                String grade = GradeCalculator.calculateGrade(
                        marks.getTamil(),
                        marks.getEnglish(),
                        marks.getMaths(),
                        marks.getScience(),
                        marks.getSocial()
                );

                marks.setGrade(grade);

                list.add(marks);

            }

            con.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

        return list;
    }

}