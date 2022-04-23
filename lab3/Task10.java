package lab3;

import java.util.ArrayList;
import java.util.Scanner;

public class Task10 {
    private static int[] readOneInputLineFromConsole() {
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[2];

        System.out.print("Enter value of 't': ");
        arr[0] = scanner.nextInt();

        System.out.print("Enter value of 'n': ");
        arr[1] = scanner.nextInt();

        return arr;
    }

    private static double solve(int[] arr)
    {
        double ret = 0;
        if (arr[0] < 0) {
            for (int i = 1; i <= arr[1]; ++i) {
                ret += Math.pow(arr[0], 2) * i;
            }
        } else {
            for (int i = 1; i <= arr[1]; ++i)
            {
                ret += Math.sqrt(arr[0] * i);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println("Task 10. Calculate function.");

        boolean do_again = false;
        do {
            int[] input;
            try {
                input = readOneInputLineFromConsole();
            } catch (Exception e) {
                System.out.println("Exception while reading args " + e.toString());
                return;
            }

            double result;
            try {
                result = solve(input);
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
