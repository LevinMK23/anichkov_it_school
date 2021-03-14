package map;

import com.google.gson.Gson;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.function.BiConsumer;

public class ShopCRM {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        TreeMap<String, TreeMap<String, Integer>> map = new TreeMap<>();
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            String name = in.next();
            int k = in.nextInt();
            for (int j = 0; j < k; j++) {
                String product = in.next();
                int cost = in.nextInt();
                //
                if (!map.containsKey(name)) {
                    map.put(name, new TreeMap<>());
                }
                map.get(name).put(product, map.get(name).getOrDefault(product, 0) + cost);
            }
        }
        System.out.println(map);


        map.forEach((name, productMap) -> {
            System.out.println(name + ": ");
            productMap.forEach((product, cost) -> {
                System.out.println("\t" + product + " " + cost);
            });
        });


        Gson gson;
        for (Map.Entry<String, TreeMap<String, Integer>> entry : map.entrySet()) {
            String name = entry.getKey();
            System.out.println(name + ": ");
            for (Map.Entry<String, Integer> value : entry.getValue().entrySet()) {
                String product = value.getKey();
                int cost = value.getValue();
                System.out.println("\t" + product + " " + cost);
            }
        }
        // user1:
        // p1 120
        // p2 10
        // p3 30
    }
}
