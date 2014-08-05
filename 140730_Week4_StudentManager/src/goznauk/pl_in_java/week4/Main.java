package goznauk.pl_in_java.week4;

import goznauk.pl_in_java.week4.model.CsvReader;
import goznauk.pl_in_java.week4.model.Student;
import goznauk.pl_in_java.week4.view.ViewMaker;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<Student>();
        studentList = CsvReader.getStudentFromCsv("scores.csv");
        ViewMaker.getView(studentList);
    }
}