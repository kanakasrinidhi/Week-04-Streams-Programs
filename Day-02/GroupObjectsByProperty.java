import java.util.*;

class Employee {
    String name;
    Department department;

    Employee(String name, Department department) {
        this.name = name;
        this.department = department;
    }

    public String toString() {
        return name;
    }
}

enum Department {
    HR, IT, SALES
}

public class GroupObjectsByProperty {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", Department.HR),
                new Employee("Bob", Department.IT),
                new Employee("Carol", Department.HR)
        );

        Map<Department, List<Employee>> groupedByDept = groupEmployeesByDepartment(employees);
        System.out.println(groupedByDept);
    }

    public static Map<Department, List<Employee>> groupEmployeesByDepartment(List<Employee> employees) {
        Map<Department, List<Employee>> groupedMap = new HashMap<>();

        for (Employee employee : employees) {
            groupedMap.putIfAbsent(employee.department, new ArrayList<>());
            groupedMap.get(employee.department).add(employee);
        }

        return groupedMap;
    }
}
