package goznauk.pl_in_java.week4_sorting.sortings;

/**
 * Created by goznauk on 2014. 8. 5..
 */
public class InsertionSort implements ISort {
    @Override
    public void sort(int[] data) {
        for(int i = 1; i<data.length; i++) {
            int tmp = data[i];
            int pos;

            for(pos = i-1; pos>=0 && tmp>data[pos]; pos--) {
                data[pos + 1] = data[pos];
            }
            data[pos + 1] = tmp;
        }
    }
}
