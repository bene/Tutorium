import java.util.Arrays;
import java.util.Scanner;

public class Eratosthenes {

    public static void main(String[] args) {

        // Scanner erstellen, mit diesem kann User Input eingelesen werden.
        Scanner sc = new Scanner(System.in);

        // Ein Doppelpunkt signalisiert dem User, dass ein Input erwartet wird.
        System.out.print(": ");

        // Der nächste int der eingegeben wird ist die Zahl,
        // bis zu welcher geprüft werden sollte.
        int checkUpTo = sc.nextInt();

        // Nachdem eingelesen wurde bis zu welcher Zahl geprüft werden sollte,
        // benötigt man keinen User Input mehr, der Scanner wird geschlossen.
        sc.close();

        // Ein neues Array mit checkUpTo + 1 Plätzen erstellen.
        // Ein neues Array enthält noch keine definierten Werte, sprich
        // bei einem int Array nur Nullen.
        int[] candidates = new int[checkUpTo + 1];

        // Deswegen befüllen wir das Array mit den Werten die wir brauchen,
        // also mit 0, 1, 2, 3, 4, ... bis checkUpTo.
        for (int i = 0; i < candidates.length; i++) {
            candidates[i] = i;
        }

        // Arrays.toString ist eine vordefinierte Hilfsfunktion, mit der
        // man alle Werte eines Arrays in Form eines String bekommen.
        // Das ist praktisch zum debuggen.
        System.out.println(Arrays.toString(candidates));

        // Auf dem letzten Platz des Arrays befindet sich die
        // höchste Zahl, also die Eingegebene.
        int maxValue = candidates[candidates.length-1];

        // Anmerkung: Da Integer Arrays nur ints beinhalten können, setzen wir nicht
        // Primzahlen auf 0 (nicht wie in der Angabe zu einem Punkt).

        // Die Schleife läuft nur bis i * i größer ist
        // als der höchste Wert, da eben die Vielfachen entfernt werden.
        // i startet bei 2, da wir 0 und 1 überspringen (keine Primzahlen),
        // und wird nach jedem Durchlauf um eins erhöht.
        for (int i = 2; i * i <= maxValue; i++) {

            // Wenn die Zahl von Platz i == 0 ist, bedeutet das,
            // dass die ursprüngliche Zahl von diesem Platz keine Primzahl ist
            // und ein Vielfaches einer anderen Zahl ist. Letzteres weiß man,
            // da sie ansonsten noch nicht 0 sein könnte.
            if (candidates[i] != 0) {

                // nextMultiple ist das nächste Vielfache
                int nextMultiple = i + i;

                // Solange das nun aktuelle Vielfache kleiner ist,
                // wie der höchste zu überprüfende Wert, setzen wir
                // auch alle weiteren Vielfache zu 0.
                while (nextMultiple <= maxValue) {

                    // Das nun aktuelle Vielfache setzen wir auf 0
                    candidates[nextMultiple] = 0;

                    // nextMultiple wird wiederum zum neuen nächsten Vielfachen
                    nextMultiple += i;
                }
            }
        }

        // Hilfsvariable counter zum tracken, wie vielen
        // Zahlen bereits in der aktuellen Zeile stehen.
        int counter = 0;

        // Alle Kandidaten durchgehen, aber 0 und vor allem 1 überspringen
        for (int i = 2; i < candidates.length; i++) {

            // Wenn der aktuelle Kandidat, also die Zahl am
            // i-tem platz des Arrays nicht Null ist, ist sie
            // eine Primzahl, da wir alle Nicht-Primzahlen auf
            // Null gesetzt haben (wie beim Beispiel der Punkt).
            if (candidates[i] != 0 && candidates[i] != 1) {

                // Die Zahl ausgeben
                System.out.printf("%d ", candidates[i]);

                // und nach jeder Ausgabe den counter erhöhen
                counter++;

                // Wenn der counter bei 10 steht
                if (counter == 10) {

                    // Einen Zeilenumbrauch ausgeben
                    System.out.print("\n");

                    // Und den counter zurücksetzen
                    counter = 0;
                }
            }
        }
    }
}
