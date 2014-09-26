package goznauk.No3;

/**
 * Created by goznauk on 2014. 9. 24..
 */

public class Person {
    String name;
    int weight;
    int height;
    int registerNumber;

    Person(String name, int weight, int height, int registerNumber) {
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.registerNumber = registerNumber;
    }

    @Override
    public boolean equals(Object o) {
        return registerNumber == ((Person)o).registerNumber;
    }
}