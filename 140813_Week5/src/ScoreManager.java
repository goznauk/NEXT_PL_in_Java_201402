import java.util.Map;
import java.util.TreeMap;

/**
 * Created by goznauk on 2014. 8. 26..
 */
public class ScoreManager {
    TreeMap<Student, Score> studentList = new TreeMap<Student, Score>();

    public void addNode(Student student, Score score) {
        student.setScore(score);
        studentList.put(student, score);
    }

    public void display() {
        System.out.println("ID\t : NAME\t : KOR\t : MATH\t : TOTAL");


        for(Map.Entry<Student, Score> node : studentList.descendingMap().entrySet()) {
            String result = node.getKey().getId() + "\t : " +
                        node.getKey().getName() + "\t : " +
                        node.getValue().getKor() + "\t : " +
                        node.getValue().getMath() + "\t : " +
                        node.getValue().getTotal();
            System.out.println(result);

        }
    }
}
