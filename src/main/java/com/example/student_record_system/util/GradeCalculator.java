package com.example.student_record_system.util;

public class GradeCalculator {

    public static String calculateGrade(int tamil,
                                        int english,
                                        int maths,
                                        int science,
                                        int social){

        int total =
                tamil +
                english +
                maths +
                science +
                social;

        double average = total / 5.0;

        if(average>=90)
            return "A+";

        if(average>=80)
            return "A";

        if(average>=70)
            return "B";

        if(average>=60)
            return "C";

        if(average>=50)
            return "D";

        return "F";

    }

}