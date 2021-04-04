package sort;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BubbleSort {

    static int iter = 0;

    static void sort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n; i++) {
            int swaps = 0;
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                    swaps++;
                }
                iter++;
            }
            if (swaps == 0) {
                return;
            }
        }
    }

    static Integer[] getRandom(int n) {
        Integer[] a = new Integer[n];
        for (int i = 0; i < n; i++) {
            a[i] = (int) (Math.random() * 1000);
        }
        return a;
    }

    public static void main(String[] args) {
        Integer[] a = getRandom(10000);

        List<Integer> list = MergeSort.mergeSort(Arrays.asList(a));
        //System.out.println(list);
        System.out.println(MergeSort.iter);
        System.out.println(MergeSort.timeSplit);
        System.out.println(MergeSort.timeMerge);
    }

}
