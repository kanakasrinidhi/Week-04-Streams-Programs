import java.util.*;

public class BankingSystem {
    HashMap<Integer, Double> accounts = new HashMap<>();
    TreeMap<Double, List<Integer>> balanceSortedAccounts = new TreeMap<>();
    Queue<Integer> withdrawalQueue = new LinkedList<>();

    public void createAccount(int accountNumber, double initialBalance) {
        accounts.put(accountNumber, initialBalance);
    }

    public void requestWithdrawal(int accountNumber) {
        if (accounts.containsKey(accountNumber)) {
            withdrawalQueue.add(accountNumber);
        }
    }

    public void processWithdrawals(double amount) {
        while (!withdrawalQueue.isEmpty()) {
            int accountNumber = withdrawalQueue.poll();
            if (accounts.get(accountNumber) >= amount) {
                accounts.put(accountNumber, accounts.get(accountNumber) - amount);
                System.out.println("Withdrawal of $" + amount + " from Account " + accountNumber + " successful.");
            } else {
                System.out.println("Insufficient balance for Account " + accountNumber);
            }
        }
    }

    public void displayAccountsSortedByBalance() {
        balanceSortedAccounts.clear();
        for (Map.Entry<Integer, Double> entry : accounts.entrySet()) {
            balanceSortedAccounts.putIfAbsent(entry.getValue(), new ArrayList<>());
            balanceSortedAccounts.get(entry.getValue()).add(entry.getKey());
        }
        System.out.println("Accounts sorted by balance:");
        for (Map.Entry<Double, List<Integer>> entry : balanceSortedAccounts.entrySet()) {
            for (int accNum : entry.getValue()) {
                System.out.println("Account " + accNum + ": $" + entry.getKey());
            }
        }
    }

    public static void main(String[] args) {
        BankingSystem bank = new BankingSystem();
        bank.createAccount(1001, 5000.0);
        bank.createAccount(1002, 3000.0);
        bank.createAccount(1003, 7000.0);

        bank.requestWithdrawal(1001);
        bank.requestWithdrawal(1003);

        bank.processWithdrawals(1000.0);
        System.out.println();
        bank.displayAccountsSortedByBalance();
    }
}
