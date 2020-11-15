package module2.lesson2;

public class A {

    protected int a;

    public A(int a) {
        this.a = a;
        System.out.println("A was created");
    }

    public int calculateAndGet() {
        System.out.println("Calculation in class A");
        return ++a;
    }

    public int getA() {
        return a;
    }

    public void print() {
        System.out.println("A: a=" + a);
    }
}
