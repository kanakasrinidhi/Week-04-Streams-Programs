import java.util.*;
import java.util.stream.*;

class Transaction {
    String transactionId;
    String policyNumber;
    double amount;
    String transactionDate;
    boolean isFraudulent;

    Transaction(String transactionId, String policyNumber, double amount, String transactionDate, boolean isFraudulent) {
        this.transactionId = transactionId;
        this.policyNumber = policyNumber;
        this.amount = amount;
        this.transactionDate = transactionDate;
        this.isFraudulent = isFraudulent;
    }
}

class FraudSummary {
    String policyNumber;
    long count;
    double totalAmount;

    FraudSummary(String policyNumber, long count, double totalAmount) {
        this.policyNumber = policyNumber;
        this.count = count;
        this.totalAmount = totalAmount;
    }

    public String toString() {
        return "Policy: " + policyNumber + ", Count: " + count + ", Total Fraud: $" + totalAmount;
    }
}

public class FraudDetectionAnalysis {
    public static void main(String[] args) {
        List<Transaction> transactions = Arrays.asList(
                new Transaction("T001", "P001", 12000, "2024-01-01", true),
                new Transaction("T002", "P001", 15000, "2024-01-02", true),
                new Transaction("T003", "P002", 8000, "2024-01-03", true),
                new Transaction("T004", "P002", 25000, "2024-01-04", true),
                new Transaction("T005", "P003", 20000, "2024-01-05", true),
                new Transaction("T006", "P003", 12000, "2024-01-06", true),
                new Transaction("T007", "P003", 11000, "2024-01-07", true),
                new Transaction("T008", "P003", 13000, "2024-01-08", true),
                new Transaction("T009", "P003", 10000, "2024-01-09", true),
                new Transaction("T010", "P003", 16000, "2024-01-10", true)
        );


        List<Transaction> filtered = transactions.stream()
                .filter(t -> t.isFraudulent && t.amount > 10000)
                .collect(Collectors.toList());


        Map<String, List<Transaction>> grouped = filtered.stream()
                .collect(Collectors.groupingBy(t -> t.policyNumber));


        List<FraudSummary> summaries = grouped.entrySet().stream()
                .map(entry -> {
                    String policy = entry.getKey();
                    List<Transaction> txns = entry.getValue();
                    long count = txns.size();
                    double total = txns.stream().mapToDouble(t -> t.amount).sum();
                    return new FraudSummary(policy, count, total);
                })
                .collect(Collectors.toList());


        System.out.println("🚨 Fraud Alerts:");
        summaries.stream()
                .filter(summary -> summary.count > 5 || summary.totalAmount > 50000)
                .forEach(System.out::println);
    }
}
