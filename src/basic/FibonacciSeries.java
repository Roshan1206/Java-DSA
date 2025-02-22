package basic;

public class FibonacciSeries {
    public static void main(String[] args) {
        printFibonnaciSeries(10);
    }

    public static void printFibonnaciSeries(int number){
        int firstNumber = 0;
        int secondNumber = 1;

        System.out.println(firstNumber);
        System.out.println(secondNumber);

        for (int i = 0; i < number-2; i++) {
            int nextNumber = firstNumber + secondNumber;
            System.out.println(nextNumber);
            firstNumber = secondNumber;
            secondNumber = nextNumber;
        }
    }
}
