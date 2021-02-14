package lists;

import java.util.stream.IntStream;

public class BinarySearch {

    public static double sqrt(double x) {
        double l = 0, r = x, eps = 0.0000000000001;
        while (r - l > eps) {
            double m = (l + r) / 2;
            if (m * m > x) {
                r = m;
            } else {
                l = m;
            }
        }
        return l;
    }

    public static int binarySearch(int[] array, int key) {
        int l = -1, r = array.length;
        while (r - l > 1) {
            int m = (l + r) / 2;
            if (array[m] == key) {
                return m;
            } else if (array[m] > key) {
                r = m;
            } else {
                l = m;
            }
        }
        return -1;
    }

    private static int[] getArray(int limit) {
        int[] a = new int[limit];
        for (int i = 0; i < a.length; i++) {
            a[i] = i + 1;
        }
        return a;
    }

    public static void test1() {
        int[] a = getArray(10000000);
        int[] b = getArray(10000);
        int cnt = 0;
        for (int i = 0; i < 10000; i++) {
            for (int j = 10000000-1; j >= 0; j--) {
                if (a[j] == b[i]) {
                    cnt++;
                    break;
                }
            }
        }
        System.out.println(cnt);
    }

    static public void test2() {
        int[] a = getArray(10000000);
        int[] b = getArray(10000);
        int cnt = 0;
        for (int i = 0; i < 10000; i++) {
            int idx = binarySearch(a, b[i]);
            if (idx != -1) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    public static void main(String[] args) {
//        System.out.println(sqrt(2));
//        int[] a = new int[]{1, 2, 3, 4, 5};
//        System.out.println(binarySearch(a, 2));
//        System.out.println(binarySearch(a, 3));
//        System.out.println(binarySearch(a, 1));
//        System.out.println(binarySearch(a, 5));
//        System.out.println(binarySearch(a, -2));
//        System.out.println(binarySearch(a, 22));
        test2();
    }
}
