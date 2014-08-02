package goznauk.pl_in_java.week4.view;

import goznauk.pl_in_java.week4.calculator.CalculateHelper;
import goznauk.pl_in_java.week4.model.Student;

import java.util.List;

/**
 * Created by goznauk on 2014. 8. 2..
 */
public class ViewMaker {
    public static String makeStudentReport(Student s) {
        String blank = "\t|\t";
        String result = "";
        result += "| "
                + s.getName() + blank
                + s.getId() + blank
                + s.getMajor() + blank;

        CalculateHelper calculateHelper = new CalculateHelper(s);
        result += calculateHelper.getMathGrade() + "(" + s.getMathScore() + ")" + blank
                + calculateHelper.getEnglishGrade() + "(" + s.getEnglishScore() + ")" + "\t|";

        return result;
    }

    public static void getView(List<Student> studentList) {
        System.out.println("| 이름\t|\t  학번  \t|\t전공\t|\t 수학 \t|\t 영어 \t|");
        for(Student s: studentList) {
            System.out.println(makeStudentReport(s));
        }
    }
}
