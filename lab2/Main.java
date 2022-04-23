package labs.lab2;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static String readOneInputLineFromConsole() {
        System.out.print("Enter value of 'a b c d' separated by space: ");

        return new Scanner(System.in).nextLine();
    }

    private static ArrayList<Double> toDoubleArrayList(String value) {
        ArrayList<Double> ret = new ArrayList<>();

        String[] words = value.split(" ");
        ret.add(Double.parseDouble(words[0]));
        ret.add(Double.parseDouble(words[1]));
        ret.add(Double.parseDouble(words[2]));
        ret.add(Double.parseDouble(words[3]));

        return ret;
    }

    private static double task_1(double a, double b, double c, double d)
    {
        double part_1 = Math.sin(a);
        double part_2 = 4 * Math.log(b) / Math.pow(c, d);

        return Math.sqrt(Math.abs(part_1 - part_2));2^5 => 2*2*2*2*2
    }

    private static double task_11(double a, double b, double c, double d)
    {
        double part_1 = 9 * (Math.asin(a) / Math.cos(Math.sqrt(Math.abs(b))));
        double part_2 = Math.pow(2.43, d) + Math.log(c);

        return part_1 + part_2;
    }

    private static double task_21(double a, double b, double c, double d)
    {
        double part_1 = Math.log(a / b);
        double part_2 = Math.sqrt(Math.cos(c) + Math.pow(Math.E, d));

        return 3 * (part_1 + part_2);
    }

    public static void main(String[] args) {
        System.out.println("Task 5. Calculate sum.");

        boolean do_again = false;
        do {
            System.out.print("Enter task number[1, 11, 21]: ");
            int task_number = Integer.parseInt(new Scanner(System.in).nextLine());

            String input;
            try {
                input = readOneInputLineFromConsole();
            } catch (Exception e) {
                System.out.println("Exception while reading args " + e.toString());
                return;
            }

            ArrayList<Double> converted_input;
            try {
                converted_input = toDoubleArrayList(input);
            } catch (Exception e) {
                System.out.println("Exception while parsing args " + e.toString());
                return;
            }

            double result = 0;
            try {
                switch (task_number) {
                    case 1: {
                        result = task_1(converted_input.get(0), converted_input.get(1), converted_input.get(2), converted_input.get(3));
                        break;
                    }
                    case 11: {
                        result = task_11(converted_input.get(0), converted_input.get(1), converted_input.get(2), converted_input.get(3));
                        break;
                    }
                    case 21: {
                        result = task_21(converted_input.get(0), converted_input.get(1), converted_input.get(2), converted_input.get(3));
                        break;
                    }
                    default: {
                        throw new Exception("Wrong task number. Supported tasks: 1, 11, 21");
                    }
                }

                System.out.println("Success. Result: " + result);
            } catch (Exception e) {
                System.out.println("Unknown exception while calculation " + e.toString());
                return;
            }

            System.out.println("Want to try one more time?(y/n)");
            do_again = new Scanner(System.in).nextLine().equals("y");
        } while (do_again);
    }
}
