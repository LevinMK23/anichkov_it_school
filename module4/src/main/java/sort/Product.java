package sort;

public class Product {

    private final String title;
    private final int price;
    private final int count;

    public Product(String title, int price, int count) {
        this.title = title;
        this.price = price;
        this.count = count;
    }

    public String getTitle() {
        return title;
    }

    public int getPrice() {
        return price;
    }

    public int getCount() {
        return count;
    }

    @Override
    public String toString() {
        return "{" +
                "" + title + '\'' +
                ", " + price +
                ", " + count +
                '}';
    }
}
