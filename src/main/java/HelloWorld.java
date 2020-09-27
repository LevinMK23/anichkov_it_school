import java.util.Scanner;

public class HelloWorld {
    //psvm
    public static void main(String[] args) {
        // ctrl + alt + l
        int x = 5;
        System.out.println(x / 10 + "" + x % 10);
        Scanner in = new Scanner(System.in);
        int a = in.nextInt(), b = in.nextInt();
        System.out.println("a + b = " + (a + b));
        System.out.println(a + " + " + b + " = " + (a + b));
        System.out.printf("%d + %d = %d\n", a, b, a + b);
    }
}
