package io.zipcoder;

import java.util.ArrayList;
import java.util.Collections;

public class Student {
    private String firstName = "";
    private String lastName = "";
    private ArrayList<Double> examScores = new ArrayList<>();

    public Student(String firstName, String lastName, Double[] testScores){
        this.firstName = firstName;
        this.lastName = lastName;
        if(testScores.length != 0)
            Collections.addAll(examScores,testScores);

    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getExamScores() {
        String result = "Exam Scores:\n";
        int i = 1;
        for(Double d : examScores){
            result += "   Exam "+i+" -> "+d+"\n";
            i++;
        }
        return result;
    }

    public Double getExamScores(int examNum) {
        return examScores.get(examNum-1);
    }

    public Integer getNumberOfExamsTaken() {
        return examScores.size();
    }

    public void addExamScore(double score){
        examScores.add(score);
    }

    public void setExamScore(int examNumber, double newScore){
        examScores.set(examNumber-1,newScore);
    }

    public double getAverageExamScore(){
        double sum = 0;
        for(Double d : examScores){
            sum += d;
        }
        return sum/examScores.size();
    }

    @Override
    public String toString(){
        String result = "\n";
        result += "Student Name: "+firstName+" "+lastName+"\n";
        result += "> Average score is "+getAverageExamScore()+"\n";
        result += "> "+getExamScores();
        return result;
    }
}
