/**
 * Created by goznauk on 2014. 8. 26..
 */
public class Student implements Comparable<Student> {
    private String name, id;
    private Score score;

    public Student(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }

    @Override
    public int compareTo(Student s) {
        if(s.getScore().getTotal() < this.score.getTotal()) {
            return 1;
        } else if(s.getScore().getTotal() == this.score.getTotal()) {
            return 0;
        } else {
            return -1;
        }
    }


}
