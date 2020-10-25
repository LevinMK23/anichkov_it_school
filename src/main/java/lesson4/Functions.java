package lesson4;

public class Functions {

    static void printRec(int n) {
        if (n == 0) {
            return;
        }
        printRec(n - 1);
        System.out.print(n + " ");
        // -> return;
    }

    static long[] mem = new long[101];

    static long fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1L;
        }
        if (mem[n] > 0) {
            return mem[n];
        }
        mem[n] = fib(n - 1) + fib(n - 2); // 2 ^ 100
        return mem[n];
    }


    static int[][] cache = new int[1001][5000];

    static int pack(int pos, int w, int[] item, int W) {
        if (w > W) {
            return -1;
        }
        if (pos == item.length) {
            return w;
        }
        if (cache[pos][w] > 0) {
            return cache[pos][w];
        }
        cache[pos][w] = Math.max(
                pack(pos + 1, w, item, W),
                pack(pos + 1, w + item[pos], item, W)
        );
        return cache[pos][w];
    }

    public static void main(String[] args) {
        int[] weights = new int[100];
        randomFill(weights);
        System.out.println(pack(0, 0, weights, 4999));
    }

    private static void randomFill(int[] weights) {
        for (int i = 0; i < weights.length; i++) {
            weights[i] = (int) (Math.random() * 100);
        }
    }

}
