package sort;

import java.util.Arrays;

public class SortTest {

    static int[] getRandom(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = (int) (Math.random() * 1000);
        }
        return a;
    }

    public static void main(String[] args) {
        int[] a = getRandom(500000);
        //System.out.println(Arrays.toString(a));
        QuickSort.sort(a);
        //System.out.println(Arrays.toString(a));
        System.out.println(QuickSort.cnt);
    }
}
