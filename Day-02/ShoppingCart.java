import java.util.*;

public class ShoppingCart {
    HashMap<String, Double> productPrices = new HashMap<>();
    LinkedHashMap<String, Double> cartOrder = new LinkedHashMap<>();
    TreeMap<Double, List<String>> sortedCart = new TreeMap<>();

    public void addProduct(String product, double price) {
        productPrices.put(product, price);
        cartOrder.put(product, price);
    }

    public void displayCartOrder() {
        System.out.println("Cart items in order added:");
        for (Map.Entry<String, Double> entry : cartOrder.entrySet()) {
            System.out.println(entry.getKey() + ": $" + entry.getValue());
        }
    }

    public void displayCartSortedByPrice() {
        sortedCart.clear();
        for (Map.Entry<String, Double> entry : cartOrder.entrySet()) {
            sortedCart.putIfAbsent(entry.getValue(), new ArrayList<>());
            sortedCart.get(entry.getValue()).add(entry.getKey());
        }
        System.out.println("Cart items sorted by price:");
        for (Map.Entry<Double, List<String>> entry : sortedCart.entrySet()) {
            for (String product : entry.getValue()) {
                System.out.println(product + ": $" + entry.getKey());
            }
        }
    }

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.addProduct("Laptop", 1200.0);
        cart.addProduct("Phone", 800.0);
        cart.addProduct("Mouse", 20.0);
        cart.addProduct("Keyboard", 50.0);

        cart.displayCartOrder();
        System.out.println();
        cart.displayCartSortedByPrice();
    }
}
