package tree;

import java.util.Scanner;

public class Task6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), k = in.nextInt();
        int[] x = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = in.nextInt();
        }
        long left = 0, right = 1000000000;
        while (right - left > 1) {
            long mid = (left + right) / 2;
            if (can(x, mid, k)) {
                left = mid;
            } else {
                right = mid;
            }
        }
        System.out.println(left);
    }

    public static boolean can(int[] a, long dis, int count) {
        int c = 1;
        int start = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] - start >= dis) {
                start = a[i];
                c++;
            }
        }
        return c >= count;
    }
}
