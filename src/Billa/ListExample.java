package Billa;

public class ListExample {

    public static void main(String[] args) {

        Node head = null;

        head = Node.addFront(head, "Max");
        head = Node.addFront(head, "Moritz");
        head = Node.addBack(head, "Anna");
        head = Node.addBack(head, "Sophie");

        head = Node.removeBack(head);
        head = Node.removeBack(head);

        System.out.println(Node.count(head));
        Node.print(head);
    }
}
