public class Hanoi {

    public static void main(String[] args) {

        int count = towersOfHanoi(5, 5, "A", "C", "B");

        // Die Anzahl der Züge ausgeben
        System.out.printf("Züge: %d", count);
    }

    static int towersOfHanoi(int amountOfDiscs, int n, String fromRod, String toRod, String tempRod) {

        System.out.printf("%stowersOfHanoi(%d, %s, %s) {\n", createSpacer(amountOfDiscs - n), n, fromRod, toRod);

        if (n == 1) {
            System.out.printf("%s--> Moving disk 1 from rod %s to rod %s\n", createSpacer(amountOfDiscs - n + 1), fromRod, toRod);
            System.out.printf("%s}\n", createSpacer(amountOfDiscs - n));
            return 1;
        }
        int moves = towersOfHanoi(amountOfDiscs, n - 1, fromRod, tempRod, toRod);
        System.out.printf("%s--> Moving disk %d from rod %s to rod %s\n", createSpacer(amountOfDiscs - n + 1), n, fromRod, toRod);
        moves += towersOfHanoi(amountOfDiscs, n - 1, tempRod, toRod, fromRod);

        System.out.printf("%s}\n", createSpacer(amountOfDiscs - n));

        return moves + 1;
    }

    // Erstellt einen String mit intents * zwei Leerzeichen
    // Bonus research: Mit einem StringBuilder kann die Funktion effizienter gemacht werden.
    static String createSpacer(int intents) {
        String s = "";
        for (int i = 0; i < intents; i++) {
            s += "  ";
            // Oder: s = s + "  ";
        }
        return s;
    }
}
