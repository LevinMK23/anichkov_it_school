package tree;

import java.util.Scanner;
import java.util.TreeSet;

public class Task1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            set.add(in.nextInt());
        }
        for (int i = 0; i < k; i++) {
            System.out.println(set.contains(in.nextInt()) ? "YES" : "NO");
        }
    }
}
