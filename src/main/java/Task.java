import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Task {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(
                new InputStreamReader(System.in));
        String[] nk = in.readLine().split(" ");
        int n = Integer.parseInt(nk[0]), k = Integer.parseInt(nk[1]);
        HashMap<String, String> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String line = in.readLine();
            String[] data = line.split(" : ");
            String category = data[0];
            String[] objects = data[1].split(", ");
            for (String object : objects) {
                map.put(object, category);
            }
        }
        String[] words = in.readLine().split(" ");
        for (String word : words) {
            System.out.print(map.getOrDefault(word, "ХЗ") + " ");
        }
    }
}
