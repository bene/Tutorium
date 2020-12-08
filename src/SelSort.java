import java.util.Arrays;
import java.util.Scanner;

public class SelSort {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter numbers: ");

        int[] values = new int[1024];

        int counter = 0;

        do {

            values[counter] = scanner.nextInt(); // counter ist 0
            counter++; // counter ist 1

        } while (values[counter - 1] > 0); // counter ist 1

        scanner.close();

        printSteps(values, counter - 1);
    }

    static void printSteps(int values[], int amountOfValues) {

        int comparisons = 0;

        selectionSort(values, amountOfValues);

        System.out.printf("Number of comparisons: %d\n", comparisons);
        System.out.printf("Number of swaps: %d", amountOfValues);
    }

    static void selectionSort(int values[], int amountOfValues) {

        int i, j, min, t;
        for(i = 0; i < amountOfValues-1; i++) {
            min = i;
            for(j = i+1; j < values.length; j++) { // Suche kleinstes El.
                if (values[j] < values[min])
                    min = j; // merke Position des kleinsten El.
            }
            t = values[min]; // Tausch
            values[min] = values[i];
            values[i] = t;
        }
    }
}
