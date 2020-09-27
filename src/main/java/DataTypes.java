public class DataTypes {
    public static void main(String[] args) {
        class Point {
            int x, y;
            void printInfo() {
                System.out.printf("x = %d, y = %d", x,  y);
            }
        }
        String s = "14124";
        Point p = new Point();
        p.x = 3;
        p.y = 4;
        p.printInfo();
        // types
        byte b = 12; // 1b [-128; 127]
        short a = 32000; //2b [-32000; 32000]
        int i = 2000000000; //4b
        long l = 1000000000000000000L; // 8b

        float f = (float)0.5; // 4b 8
        double d = 0.5; // 8b 16

        boolean bool = true; // false 1b
        char c = 'a';
        System.out.printf("\nfloat: %.20f\ndouble: %.20f\n", 1 / 3f, 1. / 3);

        byte x = 127;
        x = (byte) (x + 1);
        System.out.println(x);
    }
}
