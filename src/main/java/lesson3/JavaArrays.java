package lesson3;

import java.util.Arrays;
import java.util.Comparator;

public class JavaArrays {
    public static void main(String[] args) {
        int n = 5;
        int[] a = new int[n];
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < a.length; i++) {
            a[i] = i + 1;
        }
        for (int i : a) {
            System.out.print(i + " ");
        }
        //ctrl + alt + l
        int[] b = {1, 2, 3, 7, 9, 10}; // 8 Math.abs - module
        int maxDiff = 0;
        for (int i = 0; i < b.length - 1; i++) {
            if (Math.abs(b[i] - b[i + 1]) > maxDiff) {
                maxDiff = Math.abs(b[i] - b[i + 1]);
            }
        }
        System.out.println();
        System.out.println(maxDiff);

        Integer[] c = {1, 7, 1, 5, 7, 1}; // 1 1 1 5 7 7
        Arrays.sort(c);
        System.out.println(Arrays.toString(c));

        int[][] m = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }
        int mainSum = 0, passiveSum = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == j) {
                    mainSum += m[i][j];
                }
                if (i + j == 2) {
                    passiveSum += m[i][j];
                }
            }
        }
        System.out.println(Math.abs(mainSum - passiveSum));

        n = 12;
        int w = 2 * n - 1, start = 0;
        char[][] t = new char[n][w];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < w; j++) {
                t[i][j] = '_';
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = start; j < w - start; j++) {
                t[i][j] = '*';
            }
            start++;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < w; j++) {
                System.out.print(t[i][j]);
            }
            System.out.println();
        }
    }
}
