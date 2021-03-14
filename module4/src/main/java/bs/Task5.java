package bs;

import java.util.Scanner;

public class Task5 {

    static double f(double a, double b, double c, double d, double x) {
        return a * x * x * x + b * x * x + c * x + d;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double a = in.nextInt(), b = in.nextInt(), c = in.nextInt(), d = in.nextInt();
        double l = -1e9, r = 1e9, eps = 1e-7;
        while (r - l > eps) {
            double x = (l + r) / 2;
            if (a * f(a, b, c, d, x) > 0) {
                r = x;
            } else {
                l = x;
            }
        }
        System.out.println(l);
    }
}
