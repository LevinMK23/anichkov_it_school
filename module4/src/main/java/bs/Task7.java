package bs;

import java.util.Scanner;

public class Task7 {

    static boolean isCanCut(int[] a, int k, int len) {
        int count = 0;
        for (int i : a) {
            count += i / len;
            if (count >= k) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), k = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        int l = 0, r = 1_000_000_000;
        while (r - l > 1) {
            int len = (l + r) / 2;
            if (isCanCut(a, k, len)) {
                l = len;
            } else {
                r = len;
            }
        }
        System.out.println(l);
    }
}
