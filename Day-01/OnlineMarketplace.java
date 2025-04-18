import java.util.ArrayList;
import java.util.List;

enum BookCategory {
    FICTION, NONFICTION, SCIENCE, HISTORY
}

enum ClothingCategory {
    MEN, WOMEN, CHILDREN
}

enum GadgetCategory {
    MOBILE, LAPTOP, ACCESSORY
}

abstract class Product {
    String name;
    double price;

    Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    abstract void displayInfo();
}

class Book extends Product {
    BookCategory category;

    Book(String name, double price, BookCategory category) {
        super(name, price);
        this.category = category;
    }

    void displayInfo() {
        System.out.println("Book: " + name + ", Price: $" + price + ", Category: " + category);
    }
}

class Clothing extends Product {
    ClothingCategory category;

    Clothing(String name, double price, ClothingCategory category) {
        super(name, price);
        this.category = category;
    }

    void displayInfo() {
        System.out.println("Clothing: " + name + ", Price: $" + price + ", Category: " + category);
    }
}

class Gadget extends Product {
    GadgetCategory category;

    Gadget(String name, double price, GadgetCategory category) {
        super(name, price);
        this.category = category;
    }

    void displayInfo() {
        System.out.println("Gadget: " + name + ", Price: $" + price + ", Category: " + category);
    }
}

class ProductCatalog<T extends Product> {
    private List<T> products = new ArrayList<>();

    void addProduct(T product) {
        products.add(product);
    }

    List<T> getAllProducts() {
        return products;
    }
}

class DiscountUtil {
    static <T extends Product> void applyDiscount(T product, double percentage) {
        double discountAmount = (percentage / 100.0) * product.price;
        product.price -= discountAmount;
    }
}

public class OnlineMarketplace {
    public static void main(String[] args) {
        ProductCatalog<Book> bookCatalog = new ProductCatalog<>();
        ProductCatalog<Clothing> clothingCatalog = new ProductCatalog<>();
        ProductCatalog<Gadget> gadgetCatalog = new ProductCatalog<>();

        Book b1 = new Book("Time Machine", 200, BookCategory.FICTION);
        Clothing c1 = new Clothing("Jeans", 1500, ClothingCategory.MEN);
        Gadget g1 = new Gadget("Smartphone", 25000, GadgetCategory.MOBILE);

        bookCatalog.addProduct(b1);
        clothingCatalog.addProduct(c1);
        gadgetCatalog.addProduct(g1);

        System.out.println("Before Discount:");
        b1.displayInfo();
        c1.displayInfo();
        g1.displayInfo();

        DiscountUtil.applyDiscount(b1, 10);
        DiscountUtil.applyDiscount(c1, 20);
        DiscountUtil.applyDiscount(g1, 15);

        System.out.println("\nAfter Discount:");
        b1.displayInfo();
        c1.displayInfo();
        g1.displayInfo();
    }
}
