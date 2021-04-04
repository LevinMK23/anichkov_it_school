package sort;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class ProductSort {
    public static void main(String[] args) throws IOException {
        List<Product> products = Files.lines(Path.of("products.txt"))
                .map(line -> {
                            String[] data = line.split(" ");
                            String title = data[0];
                            int price = Integer.parseInt(data[1]);
                            int count = Integer.parseInt(data[2]);
                            return new Product(title, price, count);
                        })
                .sorted((o1, o2) -> {
                    int title = o1.getTitle().compareTo(o2.getTitle());
                    if (title == 0) {
                        int price = o2.getPrice() - o1.getPrice();
                        if (price == 0) {
                            return o1.getCount() - o2.getCount();
                        }
                        return price;
                    }
                    return title;
                })
                .collect(Collectors.toList());

        // products.sort();

        System.out.println(products);

    }
}
