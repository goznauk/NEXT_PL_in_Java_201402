/**
 * Created by goznauk on 2014. 8. 26..
 */
public class Score {
    private String id;
    private int kor, math;


    public Score(String id, int kor, int math) {
        this.id = id;
        this.kor = kor;
        this.math = math;
    }

    public String getId() {
        return id;
    }

    public int getKor() {
        return kor;
    }

    public int getMath() {
        return math;
    }

    public int getTotal() {
        return kor + math;
    }
}
