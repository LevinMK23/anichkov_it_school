package sort;

public class QuickSort {

    static int cnt = 0;

    static void sort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    static void quickSort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int pos = partition(array, left, right);
        quickSort(array, left, pos);
        quickSort(array, pos + 1, right);
    }

    static int partition(int[] array, int left, int right) {
        int mid = (left + right) / 2;
        int cur = array[mid];
        int i = left;
        int j = right;
        while (true) {
            while (array[i] < cur) {
                i++;
                cnt++;
            }
            while (array[j] > cur) {
                j--;
                cnt++;
            }
            if (i >= j) {
                return j;
            }
            int tmp = array[j];
            array[j] = array[i];
            array[i] = tmp;
            i++;
            j--;
        }
    }

}
