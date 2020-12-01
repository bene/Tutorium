public class Funktionen {

    public static void main(String[] args) {

        int result = 0;

        result = add(0, 20);
        result = result + 1;

        System.out.println(result);

        multiply(10, 10);
    }

    // Static vorerst ignorieren
    // Return type ist int
    static int add(int a, int b) {

        if (a == 0) {
            return 10;
        }

        System.out.println("Wir sind hier!");

        return a + b;
    }

    static void multiply(int a, int b) {
        System.out.println(a * b);
    }
}
