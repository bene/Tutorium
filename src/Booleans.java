public class Booleans {

    public static void main(String[] args) {

        // Der boolean Datentyp hat nur zwei mögliche werte:
        // - true
        // - false
        boolean isOpen = true;

        // 1. Möglichkeit (nicht gut)
        if (isOpen) {
            isOpen = false;
        } else {
            isOpen = true;
        }

        // 2. Möglichkeit (nicht gut)
        boolean newState = isOpen ? false : true;

        // 3. Möglichkeit (super)
        boolean newState2 = !isOpen;

        System.out.println(isOpen ? "Türe ist offen" : "Türe ist geschlossen");
    }
}
