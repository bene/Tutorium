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

    // 4 3 3 8 6

    static void printSteps(int values[], int amountOfValues) {

        int comparisons = 0;
        int swaps = selectionSort(values, amountOfValues);

        System.out.print("Result: ");
        for (int i = 0; i < amountOfValues; i++) {
            comparisons = comparisons + (amountOfValues - i - 1);
            System.out.printf("%d ", values[i]);
        }
        System.out.print("\n");

        System.out.printf("Number of comparisons: %d\n", comparisons);
        System.out.printf("Number of swaps: %d", swaps);
    }

    static int selectionSort(int values[], int amountOfValues) {

        int swapCounter = 0;

        int i, j, min, t;
        for(i = 0; i < amountOfValues-1; i++) {
            min = i;
            for(j = i+1; j < amountOfValues; j++) { // Suche kleinstes El.
                if (values[j] < values[min])
                    min = j; // merke Position des kleinsten El.
            }

            System.out.printf("Step %d: ", i + 1);

            for (int k = 0; k < amountOfValues; k++) {

                // 1. values[k] ist kleinstes
                // 2. values[k] ist zu swappendes
                // 3. values[k] ist kleinstes und zu swappendes
                // 4. values[k] ist irrelevant

                if (min == k && i == k) {
                    System.out.printf("([%d]) ", values[k]);
                } else if (min == k) {
                    System.out.printf("[%d] ", values[k]);
                } else if (i == k) {
                    System.out.printf("(%d) ", values[k]);
                } else {
                    System.out.printf("%d ", values[k]);
                }
            }
            System.out.print("\n");

            if (values[min] != values[i]) {
                // Tausch
                t = values[min];
                values[min] = values[i];
                values[i] = t;
                swapCounter++;
            }
        }

        return swapCounter;
    }
}
