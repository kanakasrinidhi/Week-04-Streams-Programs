import java.util.*;
import java.util.stream.*;

class Employee {
    int id;
    String name;
    String department;
    double salary;

    Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String toString() {
        return id + " " + name + " " + department + " $" + salary;
    }
}

public class EmployeeStreamProcessor {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee(101, "Alice", "Engineering", 95000),
                new Employee(102, "Bob", "Engineering", 87000),
                new Employee(103, "Carol", "HR", 60000),
                new Employee(104, "David", "Engineering", 78000),
                new Employee(105, "Eva", "Marketing", 85000),
                new Employee(106, "Frank", "Engineering", 92000)
        );

        List<Employee> filteredSorted = employees.stream()
                .filter(e -> e.department.equals("Engineering") && e.salary > 80000)
                .sorted((e1, e2) -> Double.compare(e2.salary, e1.salary))
                .collect(Collectors.toList());

        System.out.println("Filtered and Sorted Employees:");
        filteredSorted.forEach(System.out::println);

        Map<String, List<Employee>> grouped = filteredSorted.stream()
                .collect(Collectors.groupingBy(e -> e.department));

        System.out.println("\nGrouped by Department:");
        grouped.forEach((dept, list) -> {
            System.out.println(dept + ": " + list);
        });

        Map<String, Double> avgSalary = filteredSorted.stream()
                .collect(Collectors.groupingBy(
                        e -> e.department,
                        Collectors.averagingDouble(e -> e.salary)
                ));

        System.out.println("\nAverage Salary by Department:");
        avgSalary.forEach((dept, avg) -> {
            System.out.println(dept + ": $" + avg);
        });
    }
}
