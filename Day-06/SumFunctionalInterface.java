package ProblemStatements;

@FunctionalInterface
interface SumFunction {
    int add(int a, int b);
}

public class SumFunctionalInterface {
    public static void main(String[] args) {

        SumFunction sum = (a, b) -> a + b;


        int result1 = sum.add(10, 20);
        int result2 = sum.add(5, 15);


        System.out.println("Sum of 10 and 20 = " + result1);
        System.out.println("Sum of 5 and 15 = " + result2);
    }
}
