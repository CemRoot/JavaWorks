package lab3;

import java.util.Scanner;

public class Task15 {
    private static double readOneInputLineFromConsole() {
        Scanner scanner = new Scanner(System.in);
        double e;

        System.out.print("Enter value of 'e': ");
        e = scanner.nextDouble();

        return e;
    }

    private static double[] solve(double e)
    {
        double[] ret = new double[2];

        double sum = 0;
        for (int i = 1; true; ++i)
        {
            double next_part = Math.pow(-1, i + 1) / (i * (i + 1) * (i + 2));
            sum += next_part;
            if (Math.abs(next_part) < e)
            {
                ret[0] = sum;
                ret[1] = i;
                break;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println("Task 15. Calculate infinite sum.");

        boolean do_again = false;
        do {
            double input;
            try {
                input = readOneInputLineFromConsole();
            } catch (Exception e) {
                System.out.println("Exception while reading args " + e.toString());
                return;
            }

            double[] result;
            try {
                result = solve(input);
            } catch (Exception e) {
                System.out.println("Unknown exception while calculation " + e.toString());
                return;
            }

            System.out.println("Success. Result: i=" + result[1] + ", sum=" + result[0]);

            System.out.println("Want to try one more time?(y/n)");
            do_again = new Scanner(System.in).nextLine().equals("y");
        } while (do_again);
    }
}
