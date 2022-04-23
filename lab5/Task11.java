package lab5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Task11 {

    private static ArrayList<ArrayList<String>> readMatrixFromConsole() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter amount of rows in matrix: ");
        int rows = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter numbers, one by one in a row, separated by spaces.");
        System.out.println("We are expecting " + rows + " rows, with " + rows + " elements in each row");

        ArrayList<ArrayList<String>> matrix = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            ArrayList<String> row = new ArrayList<String>(Arrays.asList(scanner.nextLine().split(" ")));

            if (rows != row.size())
            {
                throw new RuntimeException("Wrong matrix size. Row size: " + row.size() + " , expected size: " + rows);
            }

            matrix.add(row);
        }
        return matrix;
    }

    private static ArrayList<ArrayList<Integer>> toIntegerMatrix(ArrayList<ArrayList<String>> matrix_in) {
        ArrayList<ArrayList<Integer>> matrix_out = new ArrayList<>();

        for (int i = 0; i < matrix_in.size(); ++i) {
            ArrayList<String> row_in = matrix_in.get(i);

            ArrayList<Integer> row_out = new ArrayList<>();
            for (int j = 0; j < row_in.size(); ++j) {
                row_out.add(Integer.parseInt(row_in.get(j)));
            }

            matrix_out.add(row_out);
        }

        return matrix_out;
    }

    private static ArrayList<Integer> solve(ArrayList<ArrayList<Integer>> matrix)
    {
        ArrayList<Integer> ret = new ArrayList<>();

        for (int i = 0; i < matrix.size(); ++i)
        {
            ArrayList<Integer> row = matrix.get(i);
            System.out.println("row[" + i + "]: " + row);

            boolean is_winner = true;
            for (int j = 0; j < row.size(); ++j)
            {
                if (i == j)
                {
                    continue;
                }

                if (row.get(j) == 0)
                {
                    is_winner = false;
                    System.out.println("not winner");
                    break;
                }
            }

            if (is_winner)
            {
                ret.add(i + 1);
            }
        }

        return ret;
    }

    public static void main(String[] args) {
        System.out.println("Task 5. Calculate sum of all negative elements.");

        boolean do_again = false;
        do {
            ArrayList<ArrayList<String>> matrix;
            try {
                matrix = readMatrixFromConsole();
            } catch (Exception e) {
                System.out.println("Exception while reading args " + e.toString());
                return;
            }

            ArrayList<ArrayList<Integer>> converted_matrix;
            try {
                converted_matrix = toIntegerMatrix(matrix);
            } catch (Exception e) {
                System.out.println("Exception while parsing args " + e.toString());
                return;
            }

            ArrayList<Integer> winners;
            try {
                winners = solve(converted_matrix);
            } catch (Exception e) {
                System.out.println("Unknown exception while calculation " + e.toString());
                return;
            }

            System.out.println("Success. Result: " + winners);

            System.out.println("Want to try one more time?(y/n)");
            do_again = new Scanner(System.in).nextLine().equals("y");
        } while (do_again);
    }
}
