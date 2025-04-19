import java.time.LocalDate;
import java.util.*;

class Policy {
    String policyNumber;
    String policyHolderName;
    LocalDate expiryDate;

    public Policy(String policyNumber, String policyHolderName, LocalDate expiryDate) {
        this.policyNumber = policyNumber;
        this.policyHolderName = policyHolderName;
        this.expiryDate = expiryDate;
    }

    public String toString() {
        return "PolicyNumber: " + policyNumber + ", Name: " + policyHolderName + ", Expiry: " + expiryDate;
    }
}

public class InsurancePolicyManagementSystem {

    HashMap<String, Policy> policyMap = new HashMap<>();
    LinkedHashMap<String, Policy> orderedPolicyMap = new LinkedHashMap<>();
    TreeMap<LocalDate, List<Policy>> expiryDateMap = new TreeMap<>();

    public void addPolicy(Policy policy) {
        policyMap.put(policy.policyNumber, policy);
        orderedPolicyMap.put(policy.policyNumber, policy);
        expiryDateMap.putIfAbsent(policy.expiryDate, new ArrayList<>());
        expiryDateMap.get(policy.expiryDate).add(policy);
    }

    public Policy getPolicyByNumber(String policyNumber) {
        return policyMap.get(policyNumber);
    }

    public void listExpiringIn30Days() {
        LocalDate today = LocalDate.now();
        LocalDate limitDate = today.plusDays(30);
        System.out.println("Policies expiring in next 30 days:");
        expiryDateMap.subMap(today.plusDays(1), true, limitDate, true)
                .values()
                .forEach(list -> list.forEach(System.out::println));
    }

    public void listPoliciesByHolder(String holderName) {
        System.out.println("Policies for holder: " + holderName);
        for (Policy policy : policyMap.values()) {
            if (policy.policyHolderName.equalsIgnoreCase(holderName)) {
                System.out.println(policy);
            }
        }
    }

    public void removeExpiredPolicies() {
        LocalDate today = LocalDate.now();
        Iterator<Map.Entry<LocalDate, List<Policy>>> it = expiryDateMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<LocalDate, List<Policy>> entry = it.next();
            if (entry.getKey().isBefore(today)) {
                for (Policy policy : entry.getValue()) {
                    policyMap.remove(policy.policyNumber);
                    orderedPolicyMap.remove(policy.policyNumber);
                }
                it.remove();
            }
        }
        System.out.println("Expired policies removed.");
    }

    public void displayAllPoliciesInOrder() {
        System.out.println("All policies in insertion order:");
        for (Policy policy : orderedPolicyMap.values()) {
            System.out.println(policy);
        }
    }

    public static void main(String[] args) {
        InsurancePolicyManagementSystem system = new InsurancePolicyManagementSystem();
        system.addPolicy(new Policy("P101", "Alice", LocalDate.of(2025, 5, 20)));
        system.addPolicy(new Policy("P102", "Bob", LocalDate.now().plusDays(10)));
        system.addPolicy(new Policy("P103", "Charlie", LocalDate.now().minusDays(5)));
        system.addPolicy(new Policy("P104", "Alice", LocalDate.now().plusDays(25)));

        system.displayAllPoliciesInOrder();
        System.out.println();

        System.out.println("Retrieve by number P102:");
        System.out.println(system.getPolicyByNumber("P102"));
        System.out.println();

        system.listExpiringIn30Days();
        System.out.println();

        system.listPoliciesByHolder("Alice");
        System.out.println();

        system.removeExpiredPolicies();
        System.out.println();

        system.displayAllPoliciesInOrder();
    }
}
