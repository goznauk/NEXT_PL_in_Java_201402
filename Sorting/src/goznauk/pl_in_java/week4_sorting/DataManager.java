package goznauk.pl_in_java.week4_sorting;

import goznauk.pl_in_java.week4_sorting.sortings.BubbleSort;
import goznauk.pl_in_java.week4_sorting.sortings.ISort;
import goznauk.pl_in_java.week4_sorting.sortings.InsertionSort;
import goznauk.pl_in_java.week4_sorting.sortings.QuickSort;

/**
 * Created by goznauk on 2014. 8. 5..
 */
public class DataManager {
    private ISort sort;
    private int[] data;

    public DataManager(char type) {
        //Dummy data
        this(type, new int[]{3,7,2,4,6,3,0,30,24,13});
    }

    public DataManager(char type, int[] data) {
        this.data = data;
        setType(type);
    }

    public void setType(char type) {
        switch (type) {
            case 'B' :
                sort = new BubbleSort();
                break;
            case 'Q' :
                sort = new QuickSort();
                break;
            case 'I' :
                sort = new InsertionSort();
                break;
        }
    }

    public void setData(int[] data) {
        this.data = data;
    }

    public void print() {
        System.out.print("Data :");
        for(int i : data) {
            System.out.print(" " + i);
        }
        System.out.println();
    }

    public void sort() {
        sort.sort(data);
    }
}
