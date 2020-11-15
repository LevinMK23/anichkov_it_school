package module2.lesson2;

import java.io.IOException;

public class Test {

    public static int getResult(A a) {
        return a.calculateAndGet();
    }

    public static void write(Writable writable, String msg) throws IOException {
        writable.write(msg);
    }

    public static void main(String[] args) throws IOException {
        Vector v1 = new Vector(1.75, 3);
        System.out.println(v1.getLength());
        System.out.println(v1.getAngleX());
        System.out.println(v1.getAngleY());
        Vector v2 = new Vector(v1);
        System.out.println(v2);
        v2.scale(0.5).negate().add(1, 4);
        System.out.println(v2);
        System.out.println(v1.add(v2));

        A a = new A(1);
        A b = new B(1, 2);
        System.out.println(a.calculateAndGet());
        System.out.println(b.calculateAndGet());

        System.out.println(getResult(new A(5)));      // 6
        System.out.println(getResult(new B(1, 1))); // 4
        System.out.println(getResult(new C(2, 3))); // 12

        FileManager manager = new FileManager("output.txt");

        write(manager, "New message");

        System.out.println(manager.read());
    }
}
