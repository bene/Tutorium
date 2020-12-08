import java.util.Scanner;

public class ArrayWalker {

    static char currentChar = 'B';

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[][] field = new String[10][10];
        for (int x = 0; x < 10; x++) {
            for  (int y = 0; y < 10; y++) {
                field[x][y] = ".";
            }
        }
        field[0][0] = "A";

        int input = -1;
        int x = 0;
        int y = 0;

        System.out.print(toString(field));

        while (input != 5) {

            System.out.print("Enter direction command: ");
            input = scanner.nextInt();
            System.out.println();

            if (input == 8) {

                if (x == 0 || !field[x - 1][y].equals(".")) {
                    System.out.println("You cannot go there!");
                } else {
                    x -= 1;
                    field[x][y] = nextChar();
                    System.out.print(toString(field));
                }

            } else if (input == 6) {

                if (y == 10 || !field[x][y + 1].equals(".")) {
                    System.out.println("You cannot go there!");
                } else {
                    y += 1;
                    field[x][y] = nextChar();
                    System.out.print(toString(field));
                }

            } else if (input == 2) {

                if (x == 10 || !field[x + 1][y].equals(".")) {
                    System.out.println("You cannot go there!");
                } else {
                    x++;
                    field[x][y] = nextChar();
                    System.out.print(toString(field));
                }


            } else if (input == 4) {

                if (y == 0 || !field[x][y - 1].equals(".")) {
                    System.out.println("You cannot go there!");
                } else {
                    y--;
                    field[x][y] = nextChar();
                    System.out.print(toString(field));
                }
            }
        }

        scanner.close();
    }

    static String nextChar() {

        if (currentChar >= 'Z') {
            currentChar = 'A';
        }

        return Character.toString(currentChar++);
    }


    static String toString(String[][] field) {

        StringBuilder sb = new StringBuilder();

        for (int x = 0; x < 10; x++) {
            for  (int y = 0; y < 10; y++) {
                sb.append(field[x][y]);
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}
