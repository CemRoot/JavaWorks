package lab5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Task5 {

    private static ArrayList<ArrayList<String>> readMatrixFromConsole() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter amount of rows in matrix: ");
        int rows = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter numbers, one by one in a row, separated by spaces.");
        System.out.println("We are expecting " + rows + " rows");

        int columns = -1;
        ArrayList<ArrayList<String>> matrix = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            ArrayList<String> row = new ArrayList<String>(Arrays.asList(scanner.nextLine().split(" ")));
            if (i == 0)
            {
                columns = row.size();
            }
            else
            {
                if (columns != row.size())
                {
                    throw new RuntimeException("Wrong matrix size. Row size: " + row.size() + " , expected size: " + columns);
                }
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

    private static void solve(ArrayList<ArrayList<Integer>> matrix)
    {
        for (int i = 0; i < matrix.size(); ++i)
        {
            ArrayList<Integer> row = matrix.get(i);

            for (int j = i; j < row.size(); ++j)
            {
                row.set(j, 0);
            }
        }
    }

    private static void printMatrix(ArrayList<ArrayList<Integer>> matrix)
    {
        System.out.println("Success. Result: ");

        for (ArrayList<Integer> row : matrix){
            System.out.println(row);
        }
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

            try {
                solve(converted_matrix);
            } catch (Exception e) {
                System.out.println("Unknown exception while calculation " + e.toString());
                return;
            }

            printMatrix(converted_matrix);

            System.out.println("Want to try one more time?(y/n)");
            do_again = new Scanner(System.in).nextLine().equals("y");
        } while (do_again);
    }
}
