import java.util.*;
import java.util.stream.*;

class Sale {
    String productId;
    int quantity;
    double price;

    Sale(String productId, int quantity, double price) {
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
    }
}

class ProductSales {
    String productId;
    double totalRevenue;

    ProductSales(String productId, double totalRevenue) {
        this.productId = productId;
        this.totalRevenue = totalRevenue;
    }

    public String toString() {
        return productId + ": $" + totalRevenue;
    }
}

public class ProductSalesAnalysis {
    public static void main(String[] args) {
        List<Sale> sales = Arrays.asList(
                new Sale("P1", 5, 100.0),
                new Sale("P2", 20, 50.0),
                new Sale("P3", 15, 200.0),
                new Sale("P4", 8, 80.0),
                new Sale("P5", 12, 300.0),
                new Sale("P6", 18, 150.0),
                new Sale("P7", 25, 70.0)
        );

        List<ProductSales> topProducts = sales.stream()
                .filter(s -> s.quantity > 10)
                .map(s -> new ProductSales(s.productId, s.quantity * s.price))
                .sorted((p1, p2) -> Double.compare(p2.totalRevenue, p1.totalRevenue))
                .limit(5)
                .collect(Collectors.toList());

        topProducts.forEach(System.out::println);
    }
}
