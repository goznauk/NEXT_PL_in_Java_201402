package goznauk.pl_in_java.week4.model;

import java.util.HashMap;

/**
 * Created by goznauk on 2014. 8. 2..
 */
public class Student {
    private String name;
    private int id;
    // Subject Number is static and only have 2, so making class 'subject' or enumeration is waste
    // major can be "수학" or "영어"
    private String major;
    // Subject Number is static and only have 2, so HashMap or other collections are not good
    private int mathScore, englishScore;

    // if Subject can be added or sth else happens, make enum "SUBJECT" and give them subject id just as MATH(1001), ENGLISH(1002), SCIENCE(2003).....

    public Student(String name, int id, String major, int mathScore, int englishScore) {
        this.name = name;
        this.id = id;
        this.major = major;
        this.mathScore = mathScore;
        this.englishScore = englishScore;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getMajor() {
        return major;
    }

    public int getMathScore() { return mathScore; }

    public int getEnglishScore() { return englishScore; }
}
