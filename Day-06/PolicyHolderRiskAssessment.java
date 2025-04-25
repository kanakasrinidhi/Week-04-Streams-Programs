import java.util.*;
import java.util.stream.*;

class PolicyHolder {
    String holderId;
    String name;
    int age;
    String policyType;
    double premiumAmount;

    PolicyHolder(String holderId, String name, int age, String policyType, double premiumAmount) {
        this.holderId = holderId;
        this.name = name;
        this.age = age;
        this.policyType = policyType;
        this.premiumAmount = premiumAmount;
    }
}

class RiskAssessment {
    String holderId;
    String name;
    double riskScore;

    RiskAssessment(String holderId, String name, double riskScore) {
        this.holderId = holderId;
        this.name = name;
        this.riskScore = riskScore;
    }

    public String toString() {
        return "ID: " + holderId + ", Name: " + name + ", Risk Score: " + riskScore;
    }
}

public class PolicyHolderRiskAssessment {
    public static void main(String[] args) {
        List<PolicyHolder> holders = Arrays.asList(
                new PolicyHolder("H001", "John", 65, "Life", 40000),
                new PolicyHolder("H002", "Alice", 70, "Life", 30000),
                new PolicyHolder("H003", "Bob", 55, "Health", 20000),
                new PolicyHolder("H004", "Eve", 62, "Life", 10000),
                new PolicyHolder("H005", "Tom", 61, "Vehicle", 15000),
                new PolicyHolder("H006", "Sara", 68, "Life", 50000)
        );


        List<PolicyHolder> filtered = holders.stream()
                .filter(h -> h.policyType.equals("Life") && h.age > 60)
                .collect(Collectors.toList());


        List<RiskAssessment> assessments = filtered.stream()
                .map(h -> new RiskAssessment(h.holderId, h.name, h.premiumAmount / h.age))
                .collect(Collectors.toList());


        List<RiskAssessment> sortedAssessments = assessments.stream()
                .sorted((a, b) -> Double.compare(b.riskScore, a.riskScore))
                .collect(Collectors.toList());


        Map<String, List<RiskAssessment>> riskCategories = sortedAssessments.stream()
                .collect(Collectors.groupingBy(a -> a.riskScore > 0.5 ? "High Risk" : "Low Risk"));


        System.out.println("High Risk:");
        riskCategories.getOrDefault("High Risk", new ArrayList<>()).forEach(System.out::println);

        System.out.println("\nLow Risk:");
        riskCategories.getOrDefault("Low Risk", new ArrayList<>()).forEach(System.out::println);
    }
}
