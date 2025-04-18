import java.util.ArrayList;
import java.util.List;


abstract class WarehouseItem {
    String name;

    WarehouseItem(String name) {
        this.name = name;
    }

    abstract void displayInfo();
}


class Electronics extends WarehouseItem {
    Electronics(String name) {
        super(name);
    }

    void displayInfo() {
        System.out.println("Electronics: " + name);
    }
}


class Groceries extends WarehouseItem {
    Groceries(String name) {
        super(name);
    }

    void displayInfo() {
        System.out.println("Groceries: " + name);
    }
}


class Furniture extends WarehouseItem {
    Furniture(String name) {
        super(name);
    }

    void displayInfo() {
        System.out.println("Furniture: " + name);
    }
}


class Storage<T extends WarehouseItem> {
    private List<T> items = new ArrayList<>();

    void addItem(T item) {
        items.add(item);
    }

    T getItem(int index) {
        return items.get(index);
    }

    List<T> getAllItems() {
        return items;
    }
}


class WarehouseUtil {
    static void displayAllItems(List<? extends WarehouseItem> items) {
        for (WarehouseItem item : items) {
            item.displayInfo();
        }
    }
}


public class SmartWarehouse {
    public static void main(String[] args) {
        Storage<Electronics> electronicStorage = new Storage<>();
        electronicStorage.addItem(new Electronics("Laptop"));
        electronicStorage.addItem(new Electronics("Smartphone"));

        Storage<Groceries> groceryStorage = new Storage<>();
        groceryStorage.addItem(new Groceries("Rice"));
        groceryStorage.addItem(new Groceries("Sugar"));

        Storage<Furniture> furnitureStorage = new Storage<>();
        furnitureStorage.addItem(new Furniture("Chair"));
        furnitureStorage.addItem(new Furniture("Table"));

        System.out.println("Displaying Electronics:");
        WarehouseUtil.displayAllItems(electronicStorage.getAllItems());

        System.out.println("\nDisplaying Groceries:");
        WarehouseUtil.displayAllItems(groceryStorage.getAllItems());

        System.out.println("\nDisplaying Furniture:");
        WarehouseUtil.displayAllItems(furnitureStorage.getAllItems());
    }
}
