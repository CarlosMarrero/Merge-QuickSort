
import java.util.*;

import javax.swing.JFrame;

public class MergeSortAndQuickSortDriver {

    static DataForChart data = new DataForChart();
    static Vector<Person> contacts = new Vector<Person>();
    private static int index = 0;
    static final String BEFORE = "Before", AFTER = "After", MERGE = "Merge Sort", QUICK = "QuickSort";

    public static void populateVector() {
        contacts.clear();// empties the vector everytime before continuing
        Random r = new Random(); // just create one and keep it around
        // all the letter in the alphabet to be randomly used.
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        // all the numbers in the number line to be randomly used for phone
        // number.
        String number = "0123456789";
        for (Integer k = 0; k < 10000; k++) {
            final int N = 10;// number of letters in the name
            StringBuilder sa = new StringBuilder();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < N; i++) {
                sa.append(number.charAt(r.nextInt(number.length())));
                sb.append(alphabet.charAt(r.nextInt(alphabet.length())));
            }
            String randomName = sb.toString();
            String randomphoneNumber = sa.toString();
            Person c = new Person(randomName, randomphoneNumber);
            contacts.add(c);
        }
    }

    public static void toScreen(int a, String string, String st) {
        index++;
        if ((a == 0 && index == 14) || (a == 0 && index == 16)
                || (a == 0 && index == 18)) {
            System.out.println("\n" + string + " using " + st + ":");
            for (int i = contacts.size() - 10; i < contacts.size(); i++) {
                System.out.println(contacts.get(i));
            }
        } else if ((a == 0 && index != 14) || (a == 0 && index != 18)) {
            System.out.println("\n" + string + " using " + st + ":");
            for (int i = 0; i < 10; i++) {
                System.out.println(contacts.get(i));
            }
        }
    }

    public static void chart() {
        data.chart();// MAKES CHART
        data.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// ALLOWS TO CLOSE.
        data.setSize(1600, 300);// SETS SIZE OF WINDOW TO DISPLAY CHART.
        data.setVisible(true);
        data.setTitle("Homework #7 Test Results");// SETS TITLE
    }

    @SuppressWarnings({"hiding"})
    public static <Person extends Comparable<? super Person>> void main(String[] args) {
        QuickSort<Person> quick = new QuickSort<Person>();
        MergeSort<Person> merge = new MergeSort<Person>();
        AphabeticalOrder aphabetical = new AphabeticalOrder();
        ReverseOrder reverse = new ReverseOrder();
        long start, stop, timeLength;
        int j = 0;
        System.out.println("Begining Test Cases please wait....");
        while (j < 10)// Runs the test cases 10 times.
        {
            try// try the test cases. if anything is out of place an exception
            // is thrown accordingly.
            {
                switch (1) {
                    case 1:
                        populateVector();
                        Collections.sort(contacts, aphabetical);
                        toScreen(j, BEFORE, QUICK);
                        // resets timelength everytime or else will
                        // just add on onto old timelength.
                        timeLength = 0;
                        start = System.nanoTime();// starts time.
                        quick.quickSort(contacts, 0, 0);
                        stop = System.nanoTime();// stops time.
                        toScreen(j, AFTER, QUICK);
                        timeLength += (stop - start);// time in nanoseconds.
                        data.setTime(0, j, timeLength);// inputs the times in an
                        // array in the data class.

                        populateVector();
                        Collections.sort(contacts, aphabetical);
                        toScreen(j, BEFORE, QUICK);
                        timeLength = 0;
                        start = System.nanoTime();// starts time.
                        quick.quickSort(contacts, 0, contacts.size() - 1);
                        stop = System.nanoTime();// stops time.
                        toScreen(j, AFTER, QUICK);
                        timeLength += (stop - start);// time in nanoseconds.
                        data.setTime(6, j, timeLength);

                        populateVector();
                        Collections.sort(contacts, aphabetical);
                        toScreen(j, BEFORE, MERGE);
                        timeLength = 0;
                        start = System.nanoTime();// starts time.
                        merge.mergesort(contacts);
                        stop = System.nanoTime();// stops time.
                        toScreen(j, AFTER, MERGE);
                        timeLength += (stop - start);// time in nanoseconds.
                        data.setTime(3, j, timeLength);

                    case 2:
                        populateVector();
                        toScreen(j, BEFORE, QUICK);
                        timeLength = 0;
                        start = System.nanoTime();// starts time.
                        quick.quickSort(contacts, 0, 0);
                        stop = System.nanoTime();// stops time.
                        toScreen(j, AFTER, QUICK);
                        timeLength += (stop - start);// time in nanoseconds.
                        data.setTime(1, j, timeLength);

                        populateVector();
                        toScreen(j, BEFORE, QUICK);
                        timeLength = 0;
                        start = System.nanoTime();// starts time.
                        quick.quickSort(contacts, 0, contacts.size() - 1);
                        stop = System.nanoTime();// stops time.
                        toScreen(j, AFTER, QUICK);
                        timeLength += (stop - start);// time in nanoseconds.
                        data.setTime(7, j, timeLength);

                        populateVector();
                        toScreen(j, BEFORE, MERGE);
                        timeLength = 0;
                        start = System.nanoTime();// starts time.
                        merge.mergesort(contacts);
                        stop = System.nanoTime();// stops time.
                        toScreen(j, AFTER, MERGE);
                        timeLength += (stop - start);// time in nanoseconds.
                        data.setTime(4, j, timeLength);

                    case 3:
                        populateVector();
                        Collections.sort(contacts, reverse);
                        toScreen(j, BEFORE, QUICK);
                        timeLength = 0;
                        start = System.nanoTime();// starts time.
                        quick.quickSort(contacts, 0, 0);
                        stop = System.nanoTime();// stops time.
                        toScreen(j, AFTER, QUICK);
                        timeLength += (stop - start);// time in nanoseconds.
                        data.setTime(2, j, timeLength);

                        populateVector();
                        Collections.sort(contacts, reverse);
                        toScreen(j, BEFORE, QUICK);
                        timeLength = 0;
                        start = System.nanoTime();// starts time.
                        quick.quickSort(contacts, contacts.size() - 1, 0);
                        stop = System.nanoTime();// stops time.
                        toScreen(j, AFTER, QUICK);
                        timeLength += (stop - start);// time in nanoseconds.
                        data.setTime(8, j, timeLength);

                        populateVector();
                        Collections.sort(contacts, reverse);
                        toScreen(j, BEFORE, MERGE);
                        timeLength = 0;
                        start = System.nanoTime();// starts time.
                        merge.mergesort(contacts);
                        stop = System.nanoTime();// stops time.
                        toScreen(j, AFTER, MERGE);
                        timeLength += (stop - start);// time in nanoseconds.
                        data.setTime(5, j, timeLength);
                        break;// stops the switch statements.
                }
            } catch (Exception e) {
                System.out.println("An Error occured: " + e.getMessage());
                System.exit(-1);// exits the program if an exception is caught.
            }
            j++;// increases j so the next test run can start.
        }
        data.averageAndDev();// calculates the average and standard deviation.
        chart();// displays the chart with all the information.
    }
}
