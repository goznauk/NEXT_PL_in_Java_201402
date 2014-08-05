package goznauk.pl_in_java.week4_sorting;

public class Main {

    public static void main(String[] args) {
        int[] data = new int[]{3,7,2,-4,6,3,0,30,24,13};

        DataManager d = new DataManager('I', data.clone());
        System.out.println("Insertion Sort");
        d.print();
        d.sort();
        d.print();

        System.out.println("Quick Sort");
        d.setType('Q');
        d.setData(data.clone());
        d.print();
        d.sort();
        d.print();


        System.out.println("Bubble Sort");
        d.setType('B');
        d.setData(data.clone());
        d.print();
        d.sort();
        d.print();
    }
}
