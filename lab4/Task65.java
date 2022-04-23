package lab4;

import java.util.*;

public class Task65 {
    private static ArrayList<String> readOneInputLineFromConsole() {
        System.out.println("Enter numbers, one by one in a row, separated by spaces.");

        return new ArrayList<>(Arrays.asList(new Scanner(System.in).nextLine().split(" ")));
    }

    private static ArrayList<Integer> toDoubleList(ArrayList<String> lst) {
        ArrayList<Integer> ret = new ArrayList<>();

        for (String element : lst) {
            ret.add(Integer.parseInt(element));
        }

        return ret;
    }

    private static ArrayList<Integer> solve(ArrayList<Integer> lst)
    {
        ArrayList<Integer> result = new ArrayList<>();
        result.addAll(lst);
        Collections.reverse(result);

        return result;
    }

    public static void main(String[] args) {
        System.out.println("Task 65. Reverse integers array.");

        boolean do_again = false;
        do {
            ArrayList<String> input;
            try {
                input = readOneInputLineFromConsole();
            } catch (Exception e) {
                System.out.println("Exception while reading args " + e.toString());
                return;
            }

            ArrayList<Integer> converted_input;
            try {
                converted_input = toDoubleList(input);
            } catch (Exception e) {
                System.out.println("Exception while parsing args " + e.toString());
                return;
            }

            ArrayList<Integer> result;
            try {
                result = solve(converted_input);
            } catch (Exception e) {
                System.out.println("Unknown exception while calculation " + e.toString());
                return;
            }

            System.out.println("Success. Result: " + result.toString());

            System.out.println("Want to try one more time?(y/n)");
            do_again = new Scanner(System.in).nextLine().equals("y");
        } while (do_again);
    }
}
