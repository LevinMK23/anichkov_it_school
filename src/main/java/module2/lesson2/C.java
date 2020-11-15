package module2.lesson2;

public class C extends A {

    private int c;

    public C(int a, int c) {
        super(a);
        this.c = c;
    }

    @Override
    public int calculateAndGet() {
        return super.calculateAndGet() * ++c;
    }

    @Override
    public void print() {
        System.out.println("C: a=" + a + ", c=" + c);
    }
}
