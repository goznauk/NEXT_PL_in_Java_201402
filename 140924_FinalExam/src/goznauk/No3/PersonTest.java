package goznauk.No3;

/**
 * Created by goznauk on 2014. 9. 24..
 */

public class PersonTest {

    public void main() {
        Person p1 = new Person("박찬진", 85, 183, 12345);
        Person p2 = new Person("경규일", 85, 183, 12345);
        Person p3 = new Person("박찬호", 100, 160, 12345);

        System.out.println(p1.equals(p2));
        System.out.println(p2.equals(p3));
    }
}