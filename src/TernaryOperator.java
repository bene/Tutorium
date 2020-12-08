public class TernaryOperator {

    public static void main(String[] args) {

        boolean withYear = false;

        String dateWithYear = "01.12.2020";
        String dateWithoutYear = "01.12.";

        if (withYear) {
            System.out.println(dateWithYear);
        } else {
            System.out.println(dateWithoutYear);
        }

        // Ist das Gleiche wie:
        // Wenn withYear ist wahr (dann->) ? (mache->) ... (sonst->) : (mache->) ...
        System.out.println(withYear ? dateWithYear : dateWithoutYear);
    }
}
