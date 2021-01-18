package Klausur;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Generate test data
        SharePriceList list = null;

        // a. Eine verkettete Liste mit den Testdaten befüllt
        list = add(list, createSharePrice("Apple Inc.", "AAPL", 2019, 02, 21, 171.800003, 172.369995, 170.300003, 171.059998, 17249700));
        list = add(list, createSharePrice("Microsoft Corporation", "MSFT", 2019, 02, 11, 106.199997, 106.580002, 104.970001, 105.250000, 18914100));
        list = add(list, createSharePrice("Microsoft Corporation", "MSFT", 2019, 02, 14, 106.309998, 107.290001, 105.660004, 106.900002, 21784700));
        list = add(list, createSharePrice("Microsoft Corporation", "MSFT", 2019, 02, 15, 107.910004, 108.300003, 107.360001, 108.220001, 26606900));
        list = add(list, createSharePrice("Microsoft Corporation", "MSFT", 2019, 02, 20, 107.860001, 107.940002, 106.290001, 107.150002, 21607700));
        list = add(list, createSharePrice("Microsoft Corporation", "MSFT", 2019, 02, 21, 106.900002, 109.480003, 106.870003, 109.410004, 29063200));
        list = add(list, createSharePrice("Apple Inc.", "AAPL", 2019, 02, 15, 171.250000, 171.699997, 169.750000, 170.419998, 24626800));

        // b. Einen weiteren SharePrice an der Konsole erfasst und der Liste hinzufügt.
        SharePrice fromConsole = scanSharePrice();
        list = add(list, fromConsole);

        // c. Die Liste ausgibt
        System.out.println("Alle Testdaten:");
        print(list);

        // d. und in ein Array konvertiert
        SharePrice[] sharesAsArray = toArray(list);

        // e. nach “MSFT” filtert
        SharePrice[] filtered = filter(sharesAsArray, "MSFT");

        // f. und nach Datum sortiert ausgibt (jüngster Eintrag ganz oben)
        System.out.println("Sortiert:");
        sort(filtered);
        for (SharePrice s : filtered) {
            printSharePrice(s);
        }

        // g. Den Tag mit dem größten Volumen für “Apple Inc.” ermittelt und ausgibt.
        int maxValIndex = maxVolume(sharesAsArray, "Apple Inc.");
        SharePrice maxVol = sharesAsArray[maxValIndex];

        System.out.println("Den Tag mit dem größten Volumen für “Apple Inc”:");
        printSharePrice(maxVol);
    }

    // Done
    public static SharePrice scanSharePrice() {

        Scanner sc = new Scanner(System.in);
        SharePrice newSharePrice = new SharePrice();

        newSharePrice.name = sc.next();

        while (newSharePrice.kuerzel == null) {
            String input = sc.next();
            if (input.matches("[A-Z]{4}")) {
                newSharePrice.kuerzel = input;
            } else {
                System.out.println("Ungültig!");
            }
        }

        Date newDate = new Date();
        newDate.year = sc.nextInt();
        newDate.month = sc.nextInt();
        newDate.day = sc.nextInt();

        newSharePrice.date = newDate;
        newSharePrice.openingPrice = sc.nextFloat();
        newSharePrice.closingPrice = sc.nextFloat();
        newSharePrice.low = sc.nextFloat();
        newSharePrice.high = sc.nextFloat();
        newSharePrice.volume = sc.nextInt();

        sc.close();

        return newSharePrice;
    }

    // Done
    public static void printSharePrice(SharePrice s) {

        String dateOutput = String.format("%d-%02d-%02d", s.date.year, s.date.month, s.date.day);

        String output = String.format("%s (%s) - %s - %.6f, %.6f, %.6f, %.6f. (%d)",
                s.name,
                s.kuerzel,
                dateOutput,
                s.openingPrice,
                s.high,
                s.low,
                s.closingPrice,
                s.volume);

        System.out.println(output);
    }

    // Done
    public static SharePriceList add(SharePriceList list, SharePrice s) {
        return SharePriceList.addFront(list, s);
    }

    // Done
    public static void print(SharePriceList list) {

        SharePriceList current = list;

        while (current != null) {
            printSharePrice(current.item);
            current = current.next;
        }
    }

    // Done
    public static SharePrice[] toArray(SharePriceList list) {

        if (list == null) {
            return null;
        }

        int counter = 0;
        SharePriceList current = list;

        while (current != null) {
            counter++;
            current = current.next;
        }

        SharePrice[] sharePrices = new SharePrice[counter];

        int index = 0;
        current = list;

        while (current != null) {
            sharePrices[index] = current.item;
            current = current.next;
            index++;
        }

        return sharePrices;
    }

    // Done
    public static SharePrice[] filter(SharePrice[] s, String k) {

        if (s == null || k == null || k.isEmpty()) {
            return null;
        }

        int counter = 0;

        for (int i = 0; i < s.length; i++) {
            SharePrice current = s[i];
            if (current.name.contains(k) || current.kuerzel.contains(k)) {
                counter++;
            }
        }

        SharePrice[] filteredSharePrices = new SharePrice[counter];

        int index = 0;

        for (SharePrice current : s) {
            if (current.name.contains(k) || current.kuerzel.contains(k)) {
                filteredSharePrices[index] = current;
                index++;
            }
        }

        return filteredSharePrices;
    }

    // Done
    public static void sort(SharePrice[] shares) {

        for (int i = 1; i < shares.length; i++) {
            int j = i;
            /* tmp holds value of next element to insert */
            SharePrice tmp = shares[i];
            /* find correct position for tmp */

            while (j > 0 && toDateValue(tmp.date) < toDateValue(shares[j - 1].date)) {
                /* on the way there shift right */
                shares[j] = shares[j - 1];
                j--;
            }
            shares[j] = tmp;
        }
    }

    // Done
    public static int maxVolume(SharePrice[] s, String k) {

        if (s == null || k == null || k.isEmpty()) {
            return -2;
        }

        int currentMaxIndex = 0;

        for (int i = 1; i < s.length; i++) {
            SharePrice current = s[i];

            if ((current.name.contains(k) || current.kuerzel.contains(k))
                    && s[currentMaxIndex].volume < current.volume) {
                currentMaxIndex = i;
            }
        }

        return currentMaxIndex;
    }

    // Optional helper function
    public static int toDateValue(Date date) {

        // 20210118
        // 20210119
        // 2021
        // 20210118
        // 20211000
        // 1000

        return date.year * 10000 + date.month * 100 + date.day;
    }

    // Helper function to use test data
    public static SharePrice createSharePrice(String name, String kuerzel, int year, int month, int day, double open, double high, double low, double close, int volume) {

        SharePrice sharePrice = new SharePrice();
        sharePrice.name = name;
        sharePrice.kuerzel = kuerzel;
        sharePrice.openingPrice = open;
        sharePrice.high = high;
        sharePrice.low = low;
        sharePrice.closingPrice = close;
        sharePrice.volume = volume;

        Date date = new Date();
        date.year = year;
        date.month = month;
        date.day = day;

        sharePrice.date = date;

        return sharePrice;
    }
}
