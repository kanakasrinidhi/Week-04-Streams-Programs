package Exceptions;

class DummyConnection {
    private boolean open = false;

    public void open() {
        open = true;
        System.out.println("Connection opened.");
    }

    public void use() {
        if (!open) {
            throw new IllegalStateException("Connection is not open");
        }
        System.out.println("Using connection...");
        throw new RuntimeException("Error during use");
    }

    public void close() {
        if (open) {
            System.out.println("Connection closed.");
            open = false;
        }
    }
}

public class ResourceCleanupDemo {
    public static void main(String[] args) {
        DummyConnection connection = new DummyConnection();
        try {
            connection.open();
            connection.use();
        } catch (RuntimeException e) {
            System.out.println("Exception occurred: " + e.getMessage());
        } finally {
            connection.close();
        }
    }
}
