package labs.lab7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static ArrayList<String> readOneInputLineFromConsole() {
        System.out.println("Enter numbers, one by one in a row, separated by spaces.");

        return new ArrayList<>(Arrays.asList(new Scanner(System.in).nextLine().split(" ")));
    }

    private static ArrayList<Integer> toIntegerList(ArrayList<String> lst) {
        ArrayList<Integer> ret = new ArrayList<>();

        for (String element : lst) {
            ret.add(Integer.parseInt(element));
        }

        return ret;
    }

    private static void applay(ArrayList<Integer> arr, SortingAlgorithm algo)
    {
        algo.sort(arr);
    }

    public static void main(String[] args)
    {
        System.out.println("Array sorting.");

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
                converted_input = toIntegerList(input);
            } catch (Exception e) {
                System.out.println("Exception while parsing args " + e.toString());
                return;
            }

            try {
                ArrayList<Integer> tmp1 = converted_input;
                applay(tmp1, new InsertionSort());
                System.out.println("Success. Result by insertionSort: " + tmp1);

                ArrayList<Integer> tmp2 = converted_input;
                applay(tmp1, new SelectionSort());
                System.out.println("Success. Result by selectionSort: " + tmp2);
            } catch (Exception e) {
                System.out.println("Unknown exception while calculation " + e.toString());
                return;
            }

            System.out.println("Want to try one more time?(y/n)");
            do_again = new Scanner(System.in).nextLine().equals("y");
        } while (do_again);
    }
}
