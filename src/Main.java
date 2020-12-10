public class Main {

    public static void main(String[] args) {

        Auto vwGolf = new Auto();
        vwGolf.name = "VW Golf";
        vwGolf.ps = 100;

        Person max = new Person();
        max.age = 26;
        max.name = "Max";
        max.lastName = "Mustermann";

        Person anna = new Person();
        anna.age = 60;
        anna.name = "Anna";

        System.out.println(max.lastName);
        System.out.println(anna.age);
    }
}
