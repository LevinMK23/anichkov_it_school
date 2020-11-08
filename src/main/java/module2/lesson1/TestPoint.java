package module2.lesson1;

import java.util.ArrayList;

public class TestPoint {
    public static void main(String[] args) {

        Point point = new Point(1,2);
        System.out.println(point.getX());
        System.out.println(point.getY());

        Rectangle rect = new Rectangle();
        rect.setWidth(Math.sqrt(3));
        rect.setHeight(1);
        System.out.println(rect.getDiagonal());
        System.out.println(rect.getSquare());
        System.out.println(rect.getAngleA());
        System.out.println(rect);
    }
}
