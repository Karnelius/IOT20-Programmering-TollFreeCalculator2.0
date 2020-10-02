package kyh.exercises.lecture6;

public class OverloadingExamples {
    public static void main(String[] args) {
        int sum1 = add(1, 2);
        System.out.println("Sum: " + sum1);

        double sum2 = add(1.1, 2.2);
        System.out.println("Sum: " + sum2);
    }

    public static int add(int a, int b) {
        return a + b;
    }

    public static double add(double a, double b) {
        return a + b;
    }
}
