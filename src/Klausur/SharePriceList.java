package Klausur;

public class SharePriceList {

    SharePriceList next;
    SharePrice item;

    static SharePriceList addFront(SharePriceList listHead, SharePrice itemOfNewNode) {

        SharePriceList newNode = new SharePriceList();
        newNode.item = itemOfNewNode;
        newNode.next = listHead;

        return newNode;
    }

    static SharePriceList addBack(SharePriceList listHead, SharePrice itemOfNewNode) {

        SharePriceList newNode = new SharePriceList();
        newNode.item = itemOfNewNode;

        if (listHead == null) {
            return newNode;
        }

        SharePriceList currentNode = listHead;

        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }

        currentNode.next = newNode;
        return listHead;
    }

    static SharePriceList removeFront(SharePriceList listHead) {

        if (listHead == null) {
            return null;
        }

        SharePriceList newHead = listHead.next;
        listHead.next = null;
        return newHead;
    }

    static SharePriceList removeBack(SharePriceList listHead) {

        if (listHead == null || listHead.next == null) {
            return null;
        }

        SharePriceList currentNode = listHead;

        while (currentNode.next.next != null) {
            currentNode = currentNode.next;
        }
        currentNode.next = null;
        return listHead;
    }

    static int count(SharePriceList listHead) {

        if (listHead == null) {
            return 0;
        }

        int counter = 0;
        SharePriceList currentNode = listHead;

        while (currentNode != null) {
            counter++;
            currentNode = currentNode.next;
        }

        return counter;
    }
}
