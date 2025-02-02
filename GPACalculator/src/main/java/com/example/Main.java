package com.example.studentUtil;

public class Main {
    public static void main(String[] args) {
        int[] studentIdList = {1009, 1002};
        char[][] studentsGrades = {{'A','B','A','B'}, {'A','B','B','B'}};

        double[] gpaResults = com.example.studentUtil.StudentUtil.calculateGPA(studentIdList, studentsGrades);
        System.out.print("GPA Array: ");
        for(double gpa: gpaResults){
            System.out.printf("%.4f ", gpa);
        }
        System.out.println();

        int[] filteredStudents = com.example.studentUtil.StudentUtil.getStudentsByGPA(3.3, 3.5, studentIdList, studentsGrades);
        System.out.print("Filtered Students: ");
        if(filteredStudents != null){
            for(int id: filteredStudents){
                System.out.print(id + " ");
            }
        } else{
            System.out.println("null");
        }
    }
}