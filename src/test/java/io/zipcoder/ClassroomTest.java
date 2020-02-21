package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClassroomTest {
    private static final Logger LOGGER = Logger.getLogger(Student.class.getName());

    @Test
    public void getAverageExamScoreTest(){
        // : Given
        Double[] s1Scores = { 100.0, 150.0 };
        Double[] s2Scores = { 225.0, 25.0 };

        Student s1 = new Student("student", "one", s1Scores);
        Student s2 = new Student("student", "two", s2Scores);

        Student[] students = {s1,s2};
        Classroom classroom = new Classroom(students);

        // When
        double output = classroom.getAverageExamScore();

        // Then
        //LOGGER.log(Level.INFO, output+"");
        System.out.println(output+"");
    }

    @Test
    public void addStudentTest(){
        // : Given
        int maxNumberOfStudents = 1;
        Classroom classroom = new Classroom(maxNumberOfStudents);
        Double[] examScores = { 100.0, 150.0, 250.0, 0.0 };
        Student s1 = new Student("Leon", "Hunter", examScores);

        // When
        String[] preEnrollment = classroom.getStudentsData();
        classroom.addStudent(s1);
        String[] postEnrollment = classroom.getStudentsData();

        // Then
        String preEnrollmentAsString = Arrays.toString(preEnrollment);
        String postEnrollmentAsString = Arrays.toString(postEnrollment);


        System.out.println("===========================");
        System.out.println(preEnrollmentAsString);
        System.out.println("===========================");
        System.out.println(postEnrollmentAsString);
        System.out.println("===========================");
    }

    @Test
    public void removeStudentTest(){
        // : Given
        Double[] s1Scores = { 100.0, 150.0 };
        Double[] s2Scores = { 225.0, 25.0 };

        Student s1 = new Student("student", "one", s1Scores);
        Student s2 = new Student("student", "two", s2Scores);

        Student[] students = {s1,s2};
        Classroom classroom = new Classroom(students);

        // When
        classroom.removeStudent("student","one");
        String output = Arrays.toString(classroom.getStudentsData());

        // Then
        //LOGGER.log(Level.INFO,output);
        System.out.println(output);
    }

    @Test
    public void getStudentsByScore(){
        // : Given
        Double[] s1Scores = { 100.0, 150.0 };
        Double[] s2Scores = { 225.0, 100.0 };
        Double[] s3Scores = { 100.0, 25.0 };
        Double[] s4Scores = { 225.0, 250.0 };
        Double[] s5Scores = { 100.0, 25.0 };
        Double[] s6Scores = { 100.0, 25.0 };


        Student s1 = new Student("Matt", "one", s1Scores);
        Student s2 = new Student("Matt", "two", s2Scores);
        Student s3 = new Student("John", "three", s3Scores);
        Student s4 = new Student("Lisa", "four", s4Scores);
        Student s5 = new Student("May", "five", s5Scores);
        Student s6 = new Student("Lia", "six", s6Scores);


        Student[] students = {s1,s2,s3,s4,s5,s6};
        Classroom classroom = new Classroom(students);

        // When
        Student[] actualStudents = classroom.getStudentsByScore();

        // Then
        for(Student s : actualStudents)
            System.out.println( s.getAverageExamScore()+" "+s.getFirstName()+ " "+s.getLastName());
    }

    @Test
    public void getGradeBookTest(){
        // : Given
        Double[] s1Scores = { 100.0, 150.0 };
        Double[] s2Scores = { 225.0, 100.0 };
        Double[] s3Scores = { 100.0, 25.0 };
        Double[] s4Scores = { 225.0, 250.0 };
        Double[] s5Scores = { 100.0, 25.0 };
        Double[] s6Scores = { 100.0, 25.0 };


        Student s1 = new Student("Matt", "one", s1Scores);
        Student s2 = new Student("Matt", "two", s2Scores);
        Student s3 = new Student("John", "three", s3Scores);
        Student s4 = new Student("Lisa", "four", s4Scores);
        Student s5 = new Student("May", "five", s5Scores);
        Student s6 = new Student("Lia", "six", s6Scores);


        Student[] students = {s1,s2,s3,s4,s5,s6};
        Classroom classroom = new Classroom(students);

        // When
        Map<Student,Character> actualMap = classroom.getGradeBook();

        // Then
        System.out.println("========================");
        for(Map.Entry<Student,Character> e:actualMap.entrySet()){
            System.out.println(String.format("     %-13s%s", e.getKey().getFirstName()+" "+e.getKey().getLastName(), e.getValue()));
        }
        System.out.println("========================");

    }

}
