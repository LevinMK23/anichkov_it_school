package module2.lesson1;

public class Rectangle {

    private double width;
    private double height;

    public Rectangle() {
        width = 1;
        height = 1;
    }

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public Rectangle(Rectangle rectangle) {
        width = rectangle.width;
        height = rectangle.height;
    }

    public double getSquare() {
        return width * height;
    }

    public double getDiagonal() {
        return Math.sqrt(width * width + height * height);
    }

    public double getAngleA() {
        return Math.asin(height / getDiagonal()) * 180 / Math.PI;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + width +
                ", height=" + height +
                '}';
    }
}
