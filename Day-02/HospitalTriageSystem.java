import java.util.*;

public class HospitalTriageSystem {
    public static void main(String[] args) {
        PriorityQueue<Patient> pq = new PriorityQueue<>(new Comparator<Patient>() {
            public int compare(Patient p1, Patient p2) {
                return Integer.compare(p2.severity, p1.severity);
            }
        });

        pq.add(new Patient("John", 3));
        pq.add(new Patient("Alice", 5));
        pq.add(new Patient("Bob", 2));

        while (!pq.isEmpty()) {
            System.out.println(pq.poll().name);
        }
    }

    static class Patient {
        String name;
        int severity;

        Patient(String name, int severity) {
            this.name = name;
            this.severity = severity;
        }
    }
}
