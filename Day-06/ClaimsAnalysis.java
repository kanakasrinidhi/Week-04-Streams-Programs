import java.util.*;
import java.util.stream.*;
import java.time.LocalDate;

class Claim {
    String claimId;
    String policyNumber;
    double claimAmount;
    LocalDate claimDate;
    String status;

    Claim(String claimId, String policyNumber, double claimAmount, LocalDate claimDate, String status) {
        this.claimId = claimId;
        this.policyNumber = policyNumber;
        this.claimAmount = claimAmount;
        this.claimDate = claimDate;
        this.status = status;
    }
}

class PolicySummary {
    String policyNumber;
    double totalAmount;
    double averageAmount;

    PolicySummary(String policyNumber, double totalAmount, double averageAmount) {
        this.policyNumber = policyNumber;
        this.totalAmount = totalAmount;
        this.averageAmount = averageAmount;
    }

    public String toString() {
        return "Policy: " + policyNumber + ", Total: $" + totalAmount + ", Average: $" + averageAmount;
    }
}

public class ClaimsAnalysis {
    public static void main(String[] args) {
        List<Claim> claims = Arrays.asList(
                new Claim("C101", "P1001", 6000, LocalDate.of(2023, 3, 1), "Approved"),
                new Claim("C102", "P1002", 4000, LocalDate.of(2023, 3, 2), "Pending"),
                new Claim("C103", "P1001", 7000, LocalDate.of(2023, 4, 1), "Approved"),
                new Claim("C104", "P1003", 9000, LocalDate.of(2023, 5, 1), "Approved"),
                new Claim("C105", "P1002", 8000, LocalDate.of(2023, 5, 2), "Approved"),
                new Claim("C106", "P1004", 2000, LocalDate.of(2023, 6, 1), "Rejected"),
                new Claim("C107", "P1003", 10000, LocalDate.of(2023, 6, 5), "Approved")
        );

        // 1. Filter approved claims > $5000
        List<Claim> filteredClaims = claims.stream()
                .filter(c -> c.status.equals("Approved") && c.claimAmount > 5000)
                .collect(Collectors.toList());

        // 2. Group by policy number
        Map<String, List<Claim>> groupedByPolicy = filteredClaims.stream()
                .collect(Collectors.groupingBy(c -> c.policyNumber));

        // 3. Aggregate total and average claim amounts per policy
        List<PolicySummary> policySummaries = groupedByPolicy.entrySet().stream()
                .map(entry -> {
                    String policy = entry.getKey();
                    List<Claim> policyClaims = entry.getValue();
                    double total = policyClaims.stream().mapToDouble(c -> c.claimAmount).sum();
                    double average = total / policyClaims.size();
                    return new PolicySummary(policy, total, average);
                })
                .collect(Collectors.toList());

        // 4. Top 3 policies by total claim amount
        List<PolicySummary> top3Policies = policySummaries.stream()
                .sorted((p1, p2) -> Double.compare(p2.totalAmount, p1.totalAmount))
                .limit(3)
                .collect(Collectors.toList());

        System.out.println("Top 3 Policies by Total Claim Amount:");
        top3Policies.forEach(System.out::println);
    }
}
