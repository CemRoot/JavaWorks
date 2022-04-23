package lab6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

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

    private static void selectionSort(ArrayList<Double> arr)
    {
        int n = arr.size();

        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n-1; i++)
        {
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i+1; j < n; j++)
                if (arr.get(j) < arr.get(min_idx))
                    min_idx = j;

            // Swap the found minimum element with the first
            // element
            double temp = arr.get(min_idx);
            arr.set(min_idx, arr.get(i));
            arr.set(i, temp);
        }
    }

    private static void insertionSort(ArrayList<Double> arr)
    {
        int n = arr.size();

        for (int i = 1; i < n; ++i) {
            double key = arr.get(i);
            int j = i - 1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && arr.get(j) > key) {
                arr.set(j + 1, arr.get(j));
                j = j - 1;
            }

            arr.set(j + 1, key);
        }
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

            ArrayList<Double> converted_input;
            try {
                converted_input = toDoubleList(input);
            } catch (Exception e) {
                System.out.println("Exception while parsing args " + e.toString());
                return;
            }

            try {
                ArrayList<Double> tmp1 = converted_input;
                insertionSort(tmp1);
                System.out.println("Success. Result by insertionSort: " + tmp1);

                ArrayList<Double> tmp2 = converted_input;
                selectionSort(tmp2);
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
