import java.util.*;
import java.text.*;

class InsurancePolicy implements Comparable<InsurancePolicy> {
    String policyNumber;
    String policyholderName;
    Date expiryDate;
    String coverageType;
    double premiumAmount;

    public InsurancePolicy(String policyNumber, String policyholderName, String expiryDate, String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        try {
            this.expiryDate = new SimpleDateFormat("yyyy-MM-dd").parse(expiryDate);
        } catch (Exception e) {
            this.expiryDate = new Date();
        }
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof InsurancePolicy)) return false;
        InsurancePolicy that = (InsurancePolicy) o;
        return this.policyNumber.equals(that.policyNumber);
    }

    public int hashCode() {
        return policyNumber.hashCode();
    }

    public int compareTo(InsurancePolicy o) {
        return this.expiryDate.compareTo(o.expiryDate);
    }

    public String toString() {
        return policyNumber + " | " + policyholderName + " | " + new SimpleDateFormat("yyyy-MM-dd").format(expiryDate) + " | " + coverageType + " | " + premiumAmount;
    }
}

public class PolicySetOperations {
    public static void main(String[] args) {
        Set<InsurancePolicy> hashSet = new HashSet<>();
        Set<InsurancePolicy> linkedHashSet = new LinkedHashSet<>();
        Set<InsurancePolicy> treeSet = new TreeSet<>();

        InsurancePolicy p1 = new InsurancePolicy("P001", "Alice", "2025-05-10", "Health", 5000);
        InsurancePolicy p2 = new InsurancePolicy("P002", "Bob", "2025-05-25", "Auto", 3000);
        InsurancePolicy p3 = new InsurancePolicy("P003", "Charlie", "2025-04-30", "Home", 4500);
        InsurancePolicy p4 = new InsurancePolicy("P004", "Alice", "2025-05-15", "Health", 5200);
        InsurancePolicy p5 = new InsurancePolicy("P002", "Bob", "2025-05-25", "Auto", 3000);

        List<InsurancePolicy> policies = Arrays.asList(p1, p2, p3, p4, p5);

        for (InsurancePolicy p : policies) {
            hashSet.add(p);
            linkedHashSet.add(p);
            treeSet.add(p);
        }

        System.out.println("HashSet (Unique Quick Lookup):");
        for (InsurancePolicy p : hashSet) System.out.println(p);

        System.out.println("\nLinkedHashSet (Insertion Order):");
        for (InsurancePolicy p : linkedHashSet) System.out.println(p);

        System.out.println("\nTreeSet (Sorted by Expiry Date):");
        for (InsurancePolicy p : treeSet) System.out.println(p);

        System.out.println("\nPolicies Expiring Within 30 Days:");
        Date now = new Date();
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, 30);
        Date limit = cal.getTime();
        for (InsurancePolicy p : treeSet) {
            if (!p.expiryDate.before(now) && p.expiryDate.before(limit)) {
                System.out.println(p);
            }
        }

        System.out.println("\nPolicies with Coverage Type 'Health':");
        for (InsurancePolicy p : hashSet) {
            if (p.coverageType.equalsIgnoreCase("Health")) {
                System.out.println(p);
            }
        }

        System.out.println("\nDuplicate Policies Based on Policy Number:");
        Set<String> seen = new HashSet<>();
        for (InsurancePolicy p : policies) {
            if (!seen.add(p.policyNumber)) {
                System.out.println(p);
            }
        }

        System.out.println("\nPerformance Comparison (Adding 10000 items):");
        List<InsurancePolicy> bigList = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            bigList.add(new InsurancePolicy("P" + i, "User" + i, "2025-12-31", "Auto", 1000 + i));
        }

        long start, end;

        start = System.nanoTime();
        Set<InsurancePolicy> hs = new HashSet<>();
        hs.addAll(bigList);
        end = System.nanoTime();
        System.out.println("HashSet add time: " + (end - start) + " ns");

        start = System.nanoTime();
        Set<InsurancePolicy> lhs = new LinkedHashSet<>();
        lhs.addAll(bigList);
        end = System.nanoTime();
        System.out.println("LinkedHashSet add time: " + (end - start) + " ns");

        start = System.nanoTime();
        Set<InsurancePolicy> ts = new TreeSet<>();
        ts.addAll(bigList);
        end = System.nanoTime();
        System.out.println("TreeSet add time: " + (end - start) + " ns");
    }
}
