package goznauk.pl_in_java.week4_sorting.sortings;

/**
 * Created by goznauk on 2014. 8. 5..
 */
public class QuickSort implements ISort {
    @Override
    public void sort(int[] data) {
        quickSort(data, 0, data.length-1);
    }

    public void quickSort(int[] data, int left, int right) {
        if(left>=right) {
            return;
        }
        int mid = left + ((right-left)/2);
        int pivot = data[mid];

        int i = left;
        int j = right;

        while (i<=j) {
            while (data[i]>pivot) {
                i++;
            }

            while (data[j]<pivot) {
                j--;
            }

            if(i>j) { break; }

            int tmp = data[i];
            data[i] = data[j];
            data[j] = tmp;

            i++;
            j--;
        }

        if(left<j) {
            quickSort(data, left, j);
        }

        if(right>i) {
            quickSort(data, i, right);
        }
    }
}
