package io.zipcoder;
import org.junit.Test;

import java.util.logging.Level;
import java.util.logging.Logger;

public class StudentTest {


    //private static final Logger LOGGER = Logger.getLogger(Student.class.getName());

    @Test
    public void getExamScoresTest(){
        // : Given
        String firstName = "Leon";
        String lastName = "Hunter";
        Double[] examScores = { 100.0, 95.0, 123.0, 96.0 };
        Student student = new Student(firstName, lastName, examScores);

        // When
        String output = student.getExamScores();

        // Then
        //LOGGER.log(Level.INFO,output);
        System.out.println(output);
    }

    @Test
    public void addExamScoreTest(){
        // : Given
        String firstName = "Leon";
        String lastName = "Hunter";
        Double[] examScores = { };
        Student student = new Student(firstName, lastName, examScores);

        // When
        student.addExamScore(100.0);
        String output = student.getExamScores();

        // Then
        //LOGGER.log(Level.INFO,output);
        System.out.println(output);
    }

    @Test
    public void setExamScoreTest(){
        // : Given
        String firstName = "Leon";
        String lastName = "Hunter";
        Double[] examScores = { 100.0 };
        Student student = new Student(firstName, lastName, examScores);

        // When
        student.setExamScore(1, 150.0);
        String output = student.getExamScores();

        // Then
        //LOGGER.log(Level.INFO,output);
        System.out.println(output);
    }
    @Test
    public void setExamScoreTest2(){
        // : Given
        String firstName = "Leon";
        String lastName = "Hunter";
        Double[] examScores = { 100.0 };
        Student student = new Student(firstName, lastName, examScores);

        // When
        student.setExamScore(1, 150.0);
        Double output = student.getExamScores(1);

        // Then
        //LOGGER.log(Level.INFO,output+"");
        System.out.println(output+"");
    }

    @Test
    public void getAverageExamScoreTest(){
        // : Given
        String firstName = "Leon";
        String lastName = "Hunter";
        Double[] examScores = { 100.0, 150.0, 250.0, 0.0 };
        Student student = new Student(firstName, lastName, examScores);

        // When
        double output = student.getAverageExamScore();

        // Then
        //LOGGER.log(Level.INFO,output+"");
        System.out.println(output+"");
    }

    @Test
    public void getNumOfExams(){
        // : Given
        String firstName = "Leon";
        String lastName = "Hunter";
        Double[] examScores = { 100.0, 150.0, 250.0, 0.0 };
        Student student = new Student(firstName, lastName, examScores);

        // When
        Integer output = student.getNumberOfExamsTaken();

        // Then
        //LOGGER.log(Level.INFO,output+"");
        System.out.println(output+"");
    }


    @Test
    public void studentToString(){
        // : Given
        String firstName = "Leon";
        String lastName = "Hunter";
        Double[] examScores = { 100.0, 150.0, 250.0, 0.0 };
        Student student = new Student(firstName, lastName, examScores);

        // When
        String output = student.toString();

        // Then
        //LOGGER.log(Level.INFO,output);
        System.out.println(output);


    }

}