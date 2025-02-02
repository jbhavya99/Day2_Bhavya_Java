package com.example.studentUtil;

import java.util.ArrayList;

public class StudentUtil {

    public static int getGradePoints(char grade){
        switch(grade){
            case 'A': return 4;
            case 'B': return 3;
            case 'C': return 2;
            default: throw new IllegalArgumentException("Invalid grade: " + grade);
        }
    }

    public static double[] calculateGPA (int[] studentIdList, char[][] studentsGrades){
        int n = studentIdList.length;
        double[] gpaArray = new double[n];

        for(int i=0; i<n; i++){
            double totalPoints = 0;
            int numCourses = studentsGrades[i].length;

            for(char grade: studentsGrades[i]){
                totalPoints += getGradePoints(grade);
            }

            gpaArray[i] = totalPoints/numCourses;
        }
        return gpaArray;
    }

    public static int[] getStudentsByGPA(double lower, double higher, int[] studentIdList, char [][] studentsGrades){
        if(lower < 0 || higher < 0 || lower > higher){
            return null;
        }

        double[] gpaArray = calculateGPA(studentIdList, studentsGrades);
        ArrayList<Integer> filteredStudents = new ArrayList<>();

        for(int i=0; i<gpaArray.length; i++){
            if(gpaArray[i] >= lower && gpaArray[i] <= higher){
                filteredStudents.add(studentIdList[i]);
            }
        }
        return filteredStudents.stream().mapToInt(i -> i).toArray();
    }
}