package tree;

import java.util.Scanner;
import java.util.TreeMap;

public class Task3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            int key = in.nextInt();
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        int k = in.nextInt();
        for (int i = 0; i < k; i++) {
            Integer count = map.get(in.nextInt());
            System.out.println(count == null ? 0 : count + " ");
        }
    }
}
