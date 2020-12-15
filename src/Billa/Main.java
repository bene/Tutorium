package Billa;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Node listHeadAll = null;
        Node listHead1 = null;
        Node listHead2 = null;

        while (true) {
            System.out.print(": ");
            String n = sc.next();

            if (n.equals("-")) {
                break;
            }

            listHeadAll = Node.addBack(listHeadAll, n);
        }

        boolean run = true;
        while (run) {
            // Print here
            int countAll = Node.count(listHeadAll);
            System.out.printf("Personen: %d\n", countAll);

            int count1 = Node.count(listHead1);
            System.out.printf("Kassa 1: %d\n", count1);

            int count2 = Node.count(listHead2);
            System.out.printf("Kassa 2: %d\n", count2);

            System.out.print(": ");
            String c = sc.next();

            switch (c) {
                case "-":
                    run = false;
                    break;
                case "a":
                    // anstellen
                    if (listHeadAll == null) {
                        run = false;
                        break;
                    }

                    String person = listHeadAll.item;
                    listHeadAll = Node.removeFront(listHeadAll);

                    count1 = Node.count(listHead1);
                    count2 = Node.count(listHead2);

                    if (count1 <= count2) {
                        listHead1 = Node.addBack(listHead1, person);
                    } else {
                        listHead2 = Node.addBack(listHead2, person);
                    }
                    break;
                case "1":
                    listHead1 = Node.removeFront(listHead1);
                    break;
                case "2":
                    listHead2 = Node.removeFront(listHead2);
                    break;
            }
        }

        sc.close();
    }
}
