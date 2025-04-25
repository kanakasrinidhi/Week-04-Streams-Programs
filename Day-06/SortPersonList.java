package ProblemStatements;
import java.util.*;
import java.util.stream.*;

class Person {
    String name;
    int age;
    double salary;

    public Person(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + ", salary=" + salary + "}";
    }
}

public class SortPersonList {
    public static void main(String[] args) {
        List<Person> persons = Arrays.asList(
                new Person("Alice", 30, 70000),
                new Person("Bob", 25, 50000),
                new Person("Charlie", 35, 80000),
                new Person("David", 28, 65000)
        );

        List<Person> sortedPersons = persons.stream()
                .sorted(Comparator.comparingInt(Person::getAge))
                .collect(Collectors.toList());

        System.out.println("Sorted by age in ascending order: " + sortedPersons);
    }
}
