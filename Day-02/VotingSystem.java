import java.util.*;

public class VotingSystem {
    HashMap<String, Integer> voteMap = new HashMap<>();
    LinkedHashMap<String, Integer> orderedVoteMap = new LinkedHashMap<>();
    TreeMap<String, Integer> sortedVoteMap = new TreeMap<>();

    public void castVote(String candidate) {
        voteMap.put(candidate, voteMap.getOrDefault(candidate, 0) + 1);
        orderedVoteMap.put(candidate, voteMap.get(candidate));
    }

    public void displayVotesInOrder() {
        System.out.println("Votes in order of voting:");
        for (Map.Entry<String, Integer> entry : orderedVoteMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public void displayVotesSorted() {
        sortedVoteMap.clear();
        sortedVoteMap.putAll(voteMap);
        System.out.println("Votes in sorted order:");
        for (Map.Entry<String, Integer> entry : sortedVoteMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        VotingSystem system = new VotingSystem();
        system.castVote("Alice");
        system.castVote("Bob");
        system.castVote("Charlie");
        system.castVote("Alice");
        system.castVote("Bob");

        system.displayVotesInOrder();
        System.out.println();
        system.displayVotesSorted();
    }
}
