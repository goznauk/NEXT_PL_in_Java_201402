package goznauk.pl_in_java.week4_sorting.sortings;

/**
 * Created by goznauk on 2014. 8. 5..
 */
public class BubbleSort implements ISort {
    @Override
    public void sort(int[] data) {
        for(int i = 0; i<data.length; i++) {
            for(int j = i+1; j<data.length; j++) {
                if(data[i]<data[j]) {
                    int tmp = data[i];
                    data[i] = data[j];
                    data[j] = tmp;
                }
            }
        }
    }
}
