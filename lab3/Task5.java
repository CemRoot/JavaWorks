package lab3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Task5 {

    private static String readOneInputLineFromConsole() {
        System.out.print("Enter value of 's': ");

        return new Scanner(System.in).nextLine();
    }

    private static Double toDouble(String value) {
        return Double.parseDouble(value);
    }

    private static double solve(Double s)
    {
        double ret = 0;
        for (int i = 1; i <= 35; ++i)
        {
            ret += Math.log10(Math.sqrt(s * 1 / Math.pow(i, 2)));
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println("Task 5. Calculate sum.");

        boolean do_again = false;
        do {
            String input;
            try {
                input = readOneInputLineFromConsole();
            } catch (Exception e) {
                System.out.println("Exception while reading args " + e.toString());
                return;
            }

            Double converted_input;
            try {
                converted_input = toDouble(input);
            } catch (Exception e) {
                System.out.println("Exception while parsing args " + e.toString());
                return;
            }

            double result;
            try {
                result = solve(converted_input);
            } catch (Exception e) {
                System.out.println("Unknown exception while calculation " + e.toString());
                return;
            }

            System.out.println("Success. Result: " + result);

            System.out.println("Want to try one more time?(y/n)");
            do_again = new Scanner(System.in).nextLine().equals("y");
        } while (do_again);
    }
}
