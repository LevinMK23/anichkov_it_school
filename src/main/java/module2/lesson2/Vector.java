package module2.lesson2;

public class Vector {

    private double x;
    private double y;

    // alt + insert
    public Vector(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Vector(Vector vector) {
        this.x = vector.x;
        this.y = vector.y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void print() {
        System.out.println("Vector: (" + x + ", " + y + ")");
    }

    public double getLength() {
        return Math.sqrt(x * x + y * y);
    }

    public double getAngleX() {
        return (Math.asin(y / getLength()) * 180) / Math.PI;
    }

    public double getAngleY() {
        return (Math.asin(x / getLength()) * 180) / Math.PI;
    }

    // emplace
    // overloading
    public Vector add(Vector vector) {
        x += vector.x;
        y += vector.y;
        return this;
    }

    public Vector add(double x, double y) {
        this.x += x;
        this.y += y;
        return this;
    }

    public Vector scale(double k) {
        x *= k;
        y *= k;
        return this;
    }

    public Vector negate() {
        x = -x;
        y = -y;
        return this;
    }

    public Vector subtract(Vector vector) {
        return add(vector.negate());
    }

    public double scalarMultiply(Vector vector) {
        return x * vector.x + y * vector.y;
    }

    @Override
    public String toString() {
        return "Vector{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
