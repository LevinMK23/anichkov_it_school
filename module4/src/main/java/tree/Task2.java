package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

public class Task2 {

    public static void main(String[] args) {
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        for (int i = 0; i < n; i++) {
            int tmp = in.nextInt();
            if (!map.containsKey(tmp)) {
                map.put(tmp, new ArrayList<>());
            }
            map.get(tmp).add(i + 1);
        }
        for (int i = 0; i < k; i++) {
            int key = in.nextInt();
            List<Integer> interval = map.get(key);
            int firstIdx = interval.get(0);
            int lastIdx = interval.get(interval.size() - 1);
            System.out.println(firstIdx + " " + lastIdx);
        }
    }
}
