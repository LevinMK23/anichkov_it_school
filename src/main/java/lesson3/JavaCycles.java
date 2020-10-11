package lesson3;

public class JavaCycles {
    public static void main(String[] args) {
        // ()(())((()))(((())))((((())))) N
        int n = 17, start = 1;
        lab:
        while (true) {
            for (int i = 0; i < start; i++) {
                System.out.print("(");
                n--;
                if (n == 0) {
                    break lab;
                }
            }
            for (int i = 0; i < start; i++) {
                System.out.print(")");
                n--;
                if (n == 0) {
                    break lab;
                }
            }
            start++;
        }

        System.out.println();
        n = 124251; // 6
        int len = 0;
        while (n > 0) {
            n /= 10;
            len++;
        }
        System.out.println(len);
        int dec = 12; // 1111111
        int bin = 0, base = 1;
        while (dec > 0) {
            bin += (dec % 2) * base;
            base *= 10;
            dec /= 2;
        }
        System.out.println(bin);
        bin = 1100110; // 102
        dec = 0;
        base = 1;
        while (bin > 0) {
            dec += (bin % 10) * base;
            base *= 2;
            bin /= 10;
        }
        System.out.println(dec);
        n = 12345; //54321
        dec = 0;
        while (n > 0) {
            dec = (dec + n % 10) * 10;
            n /= 10;
        }
        dec /= 10;
        System.out.println(dec);
    }
}
