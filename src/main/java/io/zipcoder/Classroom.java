package io.zipcoder;

import java.util.*;

public class Classroom {
    private int maxCapacity = 0;
    private ArrayList<Student> students;

    public Classroom(int maxCapacity) {
        this.students = new ArrayList<>();
        this.maxCapacity = maxCapacity;
    }

    public Classroom(Student[] students) {
        this.students = new ArrayList<>();
        if(students.length != 0)
            Collections.addAll(this.students,students);
    }

    public Classroom() {
        this.students = new ArrayList<>();
        maxCapacity = 30;
    }

    public Student[] getStudents() {
        if (students.size() !=0){
            return students.toArray(new Student[0]);
        }
        return null;
    }

    public String[] getStudentsData() {
        String[] array = new String[students.size()];
        int i = 0;
        for(Student s: students){
            array[i] = s.toString();
            i++;
        }
        return array;
    }

    public double getAverageExamScore(){
        double sum = 0;
        for(Student s : students){
            sum += s.getAverageExamScore();
        }
        return sum/students.size();
    }

    public void addStudent(Student student){
        if(students.size()<maxCapacity)
            students.add(student);
    }
    public void removeStudent(String firstName, String lastName){
        Student toRemove = new Student("","", new Double[]{0.0});
        if(students.size()>0) {
            for(Student s : students){
                if(s.getFirstName().equals(firstName) && s.getLastName().equals(lastName)){
                    toRemove = s;
                }
            }
            students.remove(toRemove) ;
        }
    }
    public Student[] getStudentsByScore(){
        ArrayList<Student> array = (ArrayList<Student>) students.clone();

        Comparator<Student> compareByAveScoreThenName = Comparator
                .comparing(Student::getAverageExamScore, (a,b)->(int)(b-a))
                .thenComparing(Student::getFirstName);

        //array.sort((Student s1, Student s2) -> (int) (s2.getAverageExamScore() - s1.getAverageExamScore()));
        array.sort(compareByAveScoreThenName);

        return array.toArray(new Student[0]);
    }

    public Character giveGrade(double rank){
        Character grade = ' ';
        if(rank/students.size() < 0.1 ){
            grade = 'A';
        }else if(rank/students.size() < 0.29){
            grade = 'B';
        }else if(rank/students.size() < 0.5){
            grade = 'C';
        }else if(rank/students.size() < 0.89){
            grade = 'D';
        }else{
            grade = 'F';
        }
        return grade;

    }

    public Map<Student,Character> getGradeBook(){

        //It is said that hash map will not keep the order
        //but some how this one still maintained the correct order
        Map<Student,Character> map = new HashMap<>();
        Student[] array = getStudentsByScore();
        Character grade = ' ';

        int rankCounter = 1;
        double tempS = array[0].getAverageExamScore();
        map.put(array[0],giveGrade(0));

        for(int i=1; i<students.size(); i++){

            if(tempS == array[i].getAverageExamScore()) {
                grade = giveGrade(rankCounter-1);
            }else{
                grade = giveGrade(i);
                tempS = array[i].getAverageExamScore();
                rankCounter++;
            }
            map.put(array[i],grade);
        }

        return map;
    }
}
