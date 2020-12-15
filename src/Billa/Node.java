package Billa;

public class Node {

    Node next;
    String item;

    static Node addFront(Node listHead, String itemOfNewNode) {

        Node newNode = new Node();
        newNode.item = itemOfNewNode;
        newNode.next = listHead;

        return newNode;
    }

    static Node addBack(Node listHead, String itemOfNewNode) {

        Node newNode = new Node();
        newNode.item = itemOfNewNode;

        if (listHead == null) {
            return newNode;
        }

        Node currentNode = listHead;

        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }

        currentNode.next = newNode;
        return listHead;
    }

    static Node removeFront(Node listHead) {

        if (listHead == null) {
            return null;
        }

        Node newHead = listHead.next;
        listHead.next = null;
        return newHead;
    }

    static Node removeBack(Node listHead) {

        if (listHead == null || listHead.next == null) {
            return null;
        }

        Node currentNode = listHead;

        while (currentNode.next.next != null) {
            currentNode = currentNode.next;
        }
        currentNode.next = null;
        return listHead;
    }

    static int count(Node listHead) {

        if (listHead == null) {
            return 0;
        }

        int counter = 0;
        Node currentNode = listHead;

        while (currentNode != null) {
            counter++;
            currentNode = currentNode.next;
        }

        return counter;
    }

    static void print(Node listHead) {

        Node currentNode = listHead;

        while (currentNode != null) {
            System.out.printf("%s\n", currentNode.item);
            currentNode = currentNode.next;
        }
    }
}
