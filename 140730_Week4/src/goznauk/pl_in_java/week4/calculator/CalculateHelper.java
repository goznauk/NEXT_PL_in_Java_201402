package goznauk.pl_in_java.week4.calculator;

import goznauk.pl_in_java.week4.model.SCORE;
import goznauk.pl_in_java.week4.model.Student;

/**
 * Created by goznauk on 2014. 8. 2..
 */
public class CalculateHelper {
    ICalculator iCalculator;
    Student student;

    public CalculateHelper(Student student) {
        this.student = student;
    }

    private SCORE calculateMajor(int point) {
        iCalculator = MajorSubjectCalculator.getInstance();
        return iCalculator.getGrade(point);
    }

    private SCORE calculateNonMajor(int point) {
        iCalculator = NonMajorSubjectCalculator.getInstance();
        return iCalculator.getGrade(point);
    }

    public SCORE getMathGrade() {
        if(student.getMajor().equalsIgnoreCase("수학")) {
            return calculateMajor(student.getMathScore()); }
        return calculateNonMajor(student.getMathScore());
    }

    public SCORE getEnglishGrade() {
        if(student.getMajor().equalsIgnoreCase("영어")) { return calculateMajor(student.getEnglishScore()); }
        return calculateNonMajor(student.getEnglishScore());
    }
}
