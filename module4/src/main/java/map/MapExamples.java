package map;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapExamples {

    public static void main(String[] args) {
        // [0,0,0,0]
        //  0 1 2 3
        TreeMap<String, String> dict = new TreeMap<>();
        dict.put("apple", "яблоко");
        dict.put("orange", "апельсин");
        dict.put("cucumber", "огурец");
        System.out.println(dict);
        System.out.println(dict.get("apple"));

        String[] words = {"a", "a", "aa", "b", "b", "b"};
        TreeMap<String, Integer> map = new TreeMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        System.out.println(map);
    }
}
