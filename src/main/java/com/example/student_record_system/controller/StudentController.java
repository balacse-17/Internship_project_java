package com.example.student_record_system.controller;

import com.example.student_record_system.dao.MarksDAO;
import com.example.student_record_system.dao.StudentDAO;
import com.example.student_record_system.model.Marks;
import com.example.student_record_system.model.Student;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class StudentController {

    private StudentDAO studentDAO = new StudentDAO();
    private MarksDAO marksDAO = new MarksDAO();

    // Dashboard - Total Students
    @GetMapping("/students/count")
    public int getStudentCount() {
        return studentDAO.getStudentCount();
    }

    // Get All Students
    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return studentDAO.getAllStudents();
    }

    // Search Student by Roll Number
    @GetMapping("/students/{rollNo}")
    public Student getStudent(@PathVariable int rollNo) {
        return studentDAO.getStudentByRollNo(rollNo);
    }

    // Save or Update Student Marks
    @PostMapping("/marks")
    public String saveMarks(@RequestBody Marks marks) {

        marksDAO.saveMarks(marks);

        return "Marks Saved Successfully";
    }

    // Get All Marks
    @GetMapping("/marks")
    public List<Marks> getAllMarks() {
        return marksDAO.getAllMarks();
    }

}