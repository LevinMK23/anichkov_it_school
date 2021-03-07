package hash;

import java.util.HashSet;

public class HashUtils {
    String s;


    public static void main(String[] args) {
        HashTable<String> table = new HashTable<>();

        table.add("124");
        table.add("1222");
        table.add("12");
        table.add("235235");
        table.show();

        HashSet<String> set = new HashSet<>();

    }
}
