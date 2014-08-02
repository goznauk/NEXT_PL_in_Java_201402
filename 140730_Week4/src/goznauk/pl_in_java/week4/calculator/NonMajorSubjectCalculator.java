package goznauk.pl_in_java.week4.calculator;

import goznauk.pl_in_java.week4.model.SCORE;

/**
 * Created by goznauk on 2014. 8. 2..
 */
public class NonMajorSubjectCalculator implements ICalculator {
    private static NonMajorSubjectCalculator instance;

    private NonMajorSubjectCalculator() { }

    static public NonMajorSubjectCalculator getInstance() {
        if(instance == null) { instance = new NonMajorSubjectCalculator(); }
        return instance;
    }
    public SCORE getGrade(int point) {
        switch (point/5) {
            case 20:case 19:case 18:
                return SCORE.A;
            case 17:case 16:
                return SCORE.B;
            case 15:case 14:
                return SCORE.C;
            case 13:case 12:case 11:
                return SCORE.D;
            default:
                return SCORE.F;
        }
    }
}
