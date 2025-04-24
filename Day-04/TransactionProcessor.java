package Exceptions;

class TransactionFailedException extends Exception {
    public TransactionFailedException(String message) {
        super(message);
    }
}

public class TransactionProcessor {

    public static void processTransaction(String userId, double amount) throws TransactionFailedException {
        try {
            if (amount < 0) {
                throw new IllegalArgumentException("Amount cannot be negative");
            }
            if (amount > 10000) {
                throw new Exception("Transaction limit exceeded");
            }
            System.out.println("Transaction successful for user: " + userId + ", amount: " + amount);
        } catch (Exception e) {
            throw new TransactionFailedException("Transaction failed for user " + userId + " with amount " + amount + ": " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        try {
            processTransaction("user101", 15000);
        } catch (TransactionFailedException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
