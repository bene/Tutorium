package SimpleClasses;

public class Main {

    public static void main(String[] args) {

        Auto vwGolf = new Auto();
        vwGolf.manufacturer = "VW";
        vwGolf.power = 100;

        Person max = new Person();
        max.age = 26;
        max.name = "Max";
        max.lastName = "Mustermann";
        max.car = vwGolf;

        Person anna = new Person();
        anna.age = 60;
        anna.name = "Anna";

        System.out.println(max.lastName);
        System.out.println(anna.age);
    }
}
