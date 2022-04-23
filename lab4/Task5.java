package lab4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Task5 {

    private static ArrayList<String> readOneInputLineFromConsole() {
        System.out.println("Enter numbers, one by one in a row, separated by spaces.");

        return new ArrayList<>(Arrays.asList(new Scanner(System.in).nextLine().split(" ")));
    }

    private static ArrayList<Double> toDoubleList(ArrayList<String> lst) {
        ArrayList<Double> ret = new ArrayList<>();

        for (String element : lst) {
            ret.add(Double.parseDouble(element));
        }

        return ret;
    }

    private static double solve(ArrayList<Double> lst)
    {
        double ret = 0;
        for (int i = 0; i < lst.size(); ++i)
        {
            if (lst.get(i) < 0)
            {
                ret += lst.get(i);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println("Task 5. Calculate sum of all negative elements.");

        boolean do_again = false;
        do {
            ArrayList<String> input;
            try {
                input = readOneInputLineFromConsole();
            } catch (Exception e) {
                System.out.println("Exception while reading args " + e.toString());
                return;
            }

            ArrayList<Double> converted_input;
            try {
                converted_input = toDoubleList(input);
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
