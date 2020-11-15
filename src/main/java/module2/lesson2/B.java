package module2.lesson2;

// alt + enter
public class B extends A {

    private int b;

    // super - ссылка на экземпляр класса родителя
    public B(int a, int b) {
        super(a);
        this.b = b;
        System.out.println("B was created");
    }

    // ctrl + O
    @Override
    public void print() {
        System.out.println("B: a=" + a + ", b=" + b);
    }

    @Override
    public int calculateAndGet() {
        System.out.println("Calculation in class B");
        return super.calculateAndGet() + ++b;
    }
}
