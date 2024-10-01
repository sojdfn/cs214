package org.example;

import org.example.searchAlgorithm.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class App 
{
    public static void main( String[] args )
    {
        String csvFilePath = "src\\main\\java\\org\\example\\train.csv";
        ArrayList<Article> articlesArrayList = ReadData.readCSVFileArrayList(csvFilePath);
        LinkedList<Article> articlesLinkedList = ReadData.readCSVFileLinkedList(csvFilePath);

        ArrayListBinarySearch arrayListBinarySearch = new ArrayListBinarySearch();
        ArrayListLinearSearch arrayListLinearSearch = new ArrayListLinearSearch();
        ArrayListTernarySearch arrayListTernarySearch = new ArrayListTernarySearch();
        ArrayListFibonacciSearch arrayListFibonacciSearch = new ArrayListFibonacciSearch();

        LinkedListBinarySearch linkedListBinarySearch =   new LinkedListBinarySearch();
        LinkedListLinearSearch linkedListLinearSearch =  new LinkedListLinearSearch();
        LinkedListTernarySearch linkedListTernarySearch = new LinkedListTernarySearch();
        LinkedListFibonacciSearch linkedListFibonacciSearch = new LinkedListFibonacciSearch();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Search for Objects using algorithms");
            System.out.println("2. Race");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    while (true) {
                        System.out.println("Search Menu:");
                        System.out.println("1. Search Array List using binary search");
                        System.out.println("2. Search Array List using linear search");
                        System.out.println("3. Search Array List using fibonacci search");
                        System.out.println("4. Search Array List using ternary search");
                        System.out.println("5. Search Linked List using binary search");
                        System.out.println("6. Search Linked List using linear search");
                        System.out.println("7. Search Linked List using fibonacci search");
                        System.out.println("8. Search Linked List using ternary search");
                        System.out.println("0. Exit");
                        System.out.print("Enter your choice: ");

                        int searchChoice = scanner.nextInt();

                        switch (searchChoice) {
                            case 1:
                                System.out.println("Please enter the id");
                                int searchTarget = scanner.nextInt();
                                System.out.println("Performing binary search on ArrayList...");
                                Article result = arrayListBinarySearch.binarySearchById(articlesArrayList, searchTarget);
                                if (result!=null){
                                    System.out.println("Article found");
                                    System.out.println(result);
                                    System.out.println("\n");
                                }
                                else{
                                    System.out.println("Article not found");
                                    System.out.println("\n");
                                }
                                break;
                            case 2:
                                System.out.println("Please enter the id");
                                searchTarget = scanner.nextInt();
                                System.out.println("Performing linear search on ArrayList...");
                                result = arrayListLinearSearch.linearSearchById(articlesArrayList, searchTarget);
                                if (result!=null){
                                    System.out.println("Article found");
                                    System.out.println(result);
                                    System.out.println("\n");
                                }
                                else{
                                    System.out.println("Article not found");
                                    System.out.println("\n");
                                }
                                break;
                            case 3:
                                System.out.println("Please enter the id");
                                searchTarget = scanner.nextInt();
                                System.out.println("Performing fibonacci search on ArrayList...");
                                result = arrayListFibonacciSearch.fibonacciSearchById(articlesArrayList, searchTarget);
                                if (result!=null){
                                    System.out.println("Article found");
                                    System.out.println(result);
                                    System.out.println("\n");
                                }
                                else{
                                    System.out.println("Article not found");
                                    System.out.println("\n");
                                }
                                break;
                            case 4:
                                System.out.println("Please enter the id");
                                searchTarget = scanner.nextInt();
                                System.out.println("Performing ternary search on ArrayList...");
                                result = arrayListTernarySearch.ternarySearchById(articlesArrayList, searchTarget);
                                if (result!=null){
                                    System.out.println("Article found");
                                    System.out.println(result);
                                    System.out.println("\n");
                                }
                                else{
                                    System.out.println("Article not found");
                                    System.out.println("\n");
                                }
                                break;
                            case 5:
                                System.out.println("Please enter the id");
                                searchTarget = scanner.nextInt();
                                System.out.println("Performing binary search on LinkedList...");
                                result = linkedListBinarySearch.binarySearchById(articlesLinkedList, searchTarget);
                                if (result!=null){
                                    System.out.println("Article found");
                                    System.out.println(result);
                                    System.out.println("\n");
                                }
                                else{
                                    System.out.println("Article not found");
                                    System.out.println("\n");
                                }
                                break;
                            case 6:
                                System.out.println("Please enter the id");
                                searchTarget = scanner.nextInt();
                                System.out.println("Performing linear search on LinkedList...");
                                result = linkedListLinearSearch.linearSearchById(articlesLinkedList, searchTarget);
                                if (result!=null){
                                    System.out.println("Article found");
                                    System.out.println(result);
                                    System.out.println("\n");
                                }
                                else{
                                    System.out.println("Article not found");
                                    System.out.println("\n");
                                }
                                break;
                            case 7:
                                System.out.println("Please enter the id");
                                searchTarget = scanner.nextInt();
                                System.out.println("Performing fibonacci search on LinkedList...");
                                result = linkedListFibonacciSearch.fibonacciSearchById(articlesLinkedList, searchTarget);
                                if (result!=null){
                                    System.out.println("Article found");
                                    System.out.println(result);
                                    System.out.println("\n");
                                }
                                else{
                                    System.out.println("Article not found");
                                    System.out.println("\n");
                                }
                                break;
                            case 8:
                                System.out.println("Please enter the id");
                                searchTarget = scanner.nextInt();
                                System.out.println("Performing ternary search on LinkedList...");
                                result = linkedListTernarySearch.ternarySearchById(articlesLinkedList, searchTarget);
                                if (result!=null){
                                    System.out.println("Article found");
                                    System.out.println(result);
                                    System.out.println("\n");
                                }
                                else{
                                    System.out.println("Article not found");
                                    System.out.println("\n");
                                }
                                break;
                            case 0:
                                System.out.println("Exiting Search Menu...\n");
                                break;
                            default:
                                System.out.println("Invalid choice. Please enter a valid option.\n");
                        }
                        if (searchChoice == 0) {
                            break; // Exit the inner search menu loop
                        }
                    }
                    break;
                case 2:
                    RaceAlgorithms(articlesLinkedList, articlesArrayList);
                    break;
                case 0:
                    System.out.println("Exiting...\n");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.\n");
            }
        }


    }

    public static void RaceAlgorithms(LinkedList<Article> articlesLinkedList, ArrayList<Article> articlesArrayList){
        ArrayListBinarySearch arrayListBinarySearch = new ArrayListBinarySearch();
        ArrayListLinearSearch arrayListLinearSearch = new ArrayListLinearSearch();
        ArrayListTernarySearch arrayListTernarySearch = new ArrayListTernarySearch();
        ArrayListFibonacciSearch arrayListFibonacciSearch = new ArrayListFibonacciSearch();

        LinkedListBinarySearch linkedListBinarySearch =   new LinkedListBinarySearch();
        LinkedListLinearSearch linkedListLinearSearch =  new LinkedListLinearSearch();
        LinkedListTernarySearch linkedListTernarySearch = new LinkedListTernarySearch();
        LinkedListFibonacciSearch linkedListFibonacciSearch = new LinkedListFibonacciSearch();

        int numIterations = 30;
        long[] executionTimesBinaryArrayList = new long[numIterations];
        long[] executionTimesLinearArrayList  = new long[numIterations];
        long[] executionTimesTernaryArrayList  = new long[numIterations];
        long[] executionTimesFibonacciArrayList  = new long[numIterations];
        long[] executionTimesBinaryLinkedList = new long[numIterations];
        long[] executionTimesLinearLinkedList = new long[numIterations];
        long[] executionTimesTernaryLinkedList = new long[numIterations];
        long[] executionTimesFibonacciLinkedList = new long[numIterations];

        Thread threadBinaryArrayList = new Thread(() -> {
            for (int i = 0; i < numIterations; i++) {
                int randomKey = (int) (Math.random() * articlesArrayList.size());
                int targetIdArrayList = articlesArrayList.get(randomKey).getId();

                // ArrayList searches
                long startTime1 = System.nanoTime();
                Article result1 = arrayListBinarySearch.binarySearchById(articlesArrayList, targetIdArrayList);
                long endTime1 = System.nanoTime();
                executionTimesBinaryArrayList[i] = endTime1 - startTime1;
            }
        });

        Thread threadLinearArrayList = new Thread(() -> {
            for (int i = 0; i < numIterations; i++) {
                int randomKey = (int) (Math.random() * articlesArrayList.size());
                int targetIdArrayList = articlesArrayList.get(randomKey).getId();

                long startTime2 = System.nanoTime();
                Article result2 = arrayListLinearSearch.linearSearchById(articlesArrayList, targetIdArrayList);
                long endTime2 = System.nanoTime();
                executionTimesLinearArrayList[i] = endTime2 - startTime2;
            }
        });

        Thread threadTernaryArrayList = new Thread(() -> {
            for (int i = 0; i < numIterations; i++) {
                int randomKey = (int) (Math.random() * articlesArrayList.size());
                int targetIdArrayList = articlesArrayList.get(randomKey).getId();

                long startTime3 = System.nanoTime();
                Article result3 = arrayListTernarySearch.ternarySearchById(articlesArrayList, targetIdArrayList);
                long endTime3 = System.nanoTime();
                executionTimesTernaryArrayList[i] = endTime3 - startTime3;
            }
        });

        Thread threadFibonacciArrayList = new Thread(() -> {
            for (int i = 0; i < numIterations; i++) {
                int randomKey = (int) (Math.random() * articlesArrayList.size());
                int targetIdArrayList = articlesArrayList.get(randomKey).getId();

                long startTime4 = System.nanoTime();
                Article result4 = arrayListFibonacciSearch.fibonacciSearchById(articlesArrayList, targetIdArrayList);
                long endTime4 = System.nanoTime();
                executionTimesFibonacciArrayList[i] = endTime4 - startTime4;
            }
        });

        Thread threadBinaryLinkedList = new Thread(() -> {
            for (int i = 0; i < numIterations; i++) {
                int randomKey = (int) (Math.random() * articlesArrayList.size());
                int targetIdLinkedList = articlesArrayList.get(randomKey).getId();

                long startTime5 = System.nanoTime();
                Article result5 = linkedListBinarySearch.binarySearchById(articlesLinkedList, targetIdLinkedList);
                long endTime5 = System.nanoTime();
                executionTimesBinaryLinkedList[i] = endTime5 - startTime5;
            }
        });

        Thread threadLinearLinkedList = new Thread(() -> {
            for (int i = 0; i < numIterations; i++) {
                int randomKey = (int) (Math.random() * articlesArrayList.size());
                int targetIdLinkedList = articlesArrayList.get(randomKey).getId();

                long startTime6 = System.nanoTime();
                Article result6 = linkedListLinearSearch.linearSearchById(articlesLinkedList, targetIdLinkedList);
                long endTime6 = System.nanoTime();
                executionTimesLinearLinkedList[i] = endTime6 - startTime6;
            }
        });

        Thread threadTernaryLinkedList = new Thread(() -> {
            for (int i = 0; i < numIterations; i++) {
                int randomKey = (int) (Math.random() * articlesArrayList.size());
                int targetIdLinkedList = articlesArrayList.get(randomKey).getId();

                long startTime7 = System.nanoTime();
                Article result7 = linkedListTernarySearch.ternarySearchById(articlesLinkedList, targetIdLinkedList);
                long endTime7 = System.nanoTime();
                executionTimesTernaryLinkedList[i] = endTime7 - startTime7;
            }
        });

        Thread threadFibonacciLinkedList = new Thread(() -> {
            for (int i = 0; i < numIterations; i++) {
                int randomKey = (int) (Math.random() * articlesArrayList.size());
                int targetIdLinkedList = articlesArrayList.get(randomKey).getId();

                long startTime8 = System.nanoTime();
                Article result8 = linkedListFibonacciSearch.fibonacciSearchById(articlesLinkedList, targetIdLinkedList);
                long endTime8 = System.nanoTime();
                executionTimesFibonacciLinkedList[i] = endTime8 - startTime8;
            }
        });

        System.out.println("\nRace started");
        // Start all threads
        threadBinaryArrayList.start();
        threadLinearArrayList.start();
        threadTernaryArrayList.start();
        threadFibonacciArrayList.start();
        threadBinaryLinkedList.start();
        threadLinearLinkedList.start();
        threadTernaryLinkedList.start();
        threadFibonacciLinkedList.start();

        System.out.println("..............");
        System.out.println("..............");
        System.out.println("..............");
        // Wait for all threads to finish
        try {
            threadBinaryArrayList.join();
            threadLinearArrayList.join();
            threadTernaryArrayList.join();
            threadFibonacciArrayList.join();
            threadBinaryLinkedList.join();
            threadLinearLinkedList.join();
            threadTernaryLinkedList.join();
            threadFibonacciLinkedList.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Race finished\n");

        // Calculate statistics
        //Arraylist binary search
        long bestTimeBinaryArrayList = Long.MAX_VALUE;
        long worstTimeBinaryArrayList = Long.MIN_VALUE;
        long totalElapsedTimeBinaryArrayList = 0;

        long bestTimeLinearArrayList = Long.MAX_VALUE;
        long worstTimeLinearArrayList = Long.MIN_VALUE;
        long totalElapsedTimeLinearArrayList = 0;

        long bestTimeTernaryArrayList = Long.MAX_VALUE;
        long worstTimeTernaryArrayList = Long.MIN_VALUE;
        long totalElapsedTimeTernaryArrayList = 0;

        long bestTimeFibonacciArrayList = Long.MAX_VALUE;
        long worstTimeFibonacciArrayList = Long.MIN_VALUE;
        long totalElapsedTimeFibonacciArrayList = 0;

        long bestTimeBinaryLinkedList = Long.MAX_VALUE;
        long worstTimeBinaryLinkedList = Long.MIN_VALUE;
        long totalElapsedTimeBinaryLinkedList = 0;

        long bestTimeLinearLinkedList = Long.MAX_VALUE;
        long worstTimeLinearLinkedList = Long.MIN_VALUE;
        long totalElapsedTimeLinearLinkedList = 0;

        long bestTimeTernaryLinkedList = Long.MAX_VALUE;
        long worstTimeTernaryLinkedList = Long.MIN_VALUE;
        long totalElapsedTimeTernaryLinkedList = 0;

        long bestTimeFibonacciLinkedList = Long.MAX_VALUE;
        long worstTimeFibonacciLinkedList = Long.MIN_VALUE;
        long totalElapsedTimeFibonacciLinkedList = 0;

        for (int i = 0; i < numIterations; i++) {
            //Binary ArrayList
            totalElapsedTimeBinaryArrayList += executionTimesBinaryArrayList[i];

            if (executionTimesBinaryArrayList[i] < bestTimeBinaryArrayList) {
                bestTimeBinaryArrayList = executionTimesBinaryArrayList[i];
            }

            if (executionTimesBinaryArrayList[i] > worstTimeBinaryArrayList) {
                worstTimeBinaryArrayList = executionTimesBinaryArrayList[i];
            }
            //Linear ArrayList
            totalElapsedTimeLinearArrayList += executionTimesLinearArrayList[i];

            if (executionTimesLinearArrayList[i] < bestTimeLinearArrayList) {
                bestTimeLinearArrayList = executionTimesLinearArrayList[i];
            }

            if (executionTimesLinearArrayList[i] > worstTimeLinearArrayList) {
                worstTimeLinearArrayList = executionTimesLinearArrayList[i];
            }
            //Ternary ArrayList
            totalElapsedTimeTernaryArrayList += executionTimesTernaryArrayList[i];

            if (executionTimesTernaryArrayList[i] < bestTimeTernaryArrayList) {
                bestTimeTernaryArrayList = executionTimesTernaryArrayList[i];
            }

            if (executionTimesTernaryArrayList[i] > worstTimeTernaryArrayList) {
                worstTimeTernaryArrayList = executionTimesTernaryArrayList[i];
            }
            //Fibonacci ArrayList
            totalElapsedTimeFibonacciArrayList += executionTimesFibonacciArrayList[i];

            if (executionTimesFibonacciArrayList[i] < bestTimeFibonacciArrayList) {
                bestTimeFibonacciArrayList = executionTimesFibonacciArrayList[i];
            }

            if (executionTimesFibonacciArrayList[i] > worstTimeFibonacciArrayList) {
                worstTimeFibonacciArrayList = executionTimesFibonacciArrayList[i];
            }
            //Binary LinkedList
            totalElapsedTimeBinaryLinkedList += executionTimesBinaryLinkedList[i];

            if (executionTimesBinaryLinkedList[i] < bestTimeBinaryLinkedList) {
                bestTimeBinaryLinkedList = executionTimesBinaryLinkedList[i];
            }

            if (executionTimesBinaryLinkedList[i] > worstTimeBinaryLinkedList) {
                worstTimeBinaryLinkedList = executionTimesBinaryLinkedList[i];
            }
            //Linear LinkedList
            totalElapsedTimeLinearLinkedList += executionTimesLinearLinkedList[i];

            if (executionTimesLinearLinkedList[i] < bestTimeLinearLinkedList) {
                bestTimeLinearLinkedList = executionTimesLinearLinkedList[i];
            }

            if (executionTimesLinearLinkedList[i] > worstTimeLinearLinkedList) {
                worstTimeLinearLinkedList = executionTimesLinearLinkedList[i];
            }
            //Ternary LinkedList
            totalElapsedTimeTernaryLinkedList += executionTimesTernaryLinkedList[i];

            if (executionTimesTernaryLinkedList[i] < bestTimeTernaryLinkedList) {
                bestTimeTernaryLinkedList = executionTimesTernaryLinkedList[i];
            }

            if (executionTimesTernaryLinkedList[i] > worstTimeTernaryLinkedList) {
                worstTimeTernaryLinkedList = executionTimesTernaryLinkedList[i];
            }
            //Fibonacci Linkedlist
            totalElapsedTimeFibonacciLinkedList += executionTimesFibonacciLinkedList[i];

            if (executionTimesFibonacciLinkedList[i] < bestTimeFibonacciLinkedList) {
                bestTimeFibonacciLinkedList = executionTimesFibonacciLinkedList[i];
            }

            if (executionTimesFibonacciLinkedList[i] > worstTimeFibonacciLinkedList) {
                worstTimeFibonacciLinkedList = executionTimesFibonacciLinkedList[i];
            }
        }

        double meanTimeBinaryArrayList = (double) totalElapsedTimeBinaryArrayList / numIterations;
        double meanTimeLinearArrayList = (double) totalElapsedTimeLinearArrayList / numIterations;
        double meanTimeTernaryArrayList = (double) totalElapsedTimeTernaryArrayList / numIterations;
        double meanTimeFibonacciArrayList = (double) totalElapsedTimeFibonacciArrayList / numIterations;
        double meanTimeBinaryLinkedList = (double) totalElapsedTimeBinaryLinkedList / numIterations;
        double meanTimeLinearLinkedList = (double) totalElapsedTimeLinearLinkedList / numIterations;
        double meanTimeTernaryLinkedList = (double) totalElapsedTimeTernaryLinkedList / numIterations;
        double meanTimeFibonacciLinkedList = (double) totalElapsedTimeFibonacciLinkedList / numIterations;


        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Race Menu:");
            System.out.println("1. Display graph of time taken by the algorithms");
            System.out.println("2. Display mean, best and worst time for each algorithm");
            System.out.println("3. Display graph of worst-case time complexity of these algorithms");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            int searchChoice = scanner.nextInt();
            switch (searchChoice) {
                case 1:
                    System.out.println("\n Displaying graph of time taken by the algorithms");
                    DefaultCategoryDataset totalTimeDataset = new DefaultCategoryDataset();

                    totalTimeDataset.addValue(totalElapsedTimeBinaryArrayList, "Binary ArrayList", "Binary Search Array List");
                    totalTimeDataset.addValue(totalElapsedTimeLinearArrayList, "Linear ArrayList", "Linear Search Array List");
                    totalTimeDataset.addValue(totalElapsedTimeTernaryArrayList, "Ternary ArrayList", "Ternary Search Array List");
                    totalTimeDataset.addValue(totalElapsedTimeFibonacciArrayList, "Fibonacci ArrayList", "Fibonacci Search Array List");
                    totalTimeDataset.addValue(totalElapsedTimeBinaryLinkedList, "Binary LinkedList", "Binary Search Linked List");
                    totalTimeDataset.addValue(totalElapsedTimeLinearLinkedList, "Linear LinkedList", "Linear Search Linked List");
                    totalTimeDataset.addValue(totalElapsedTimeTernaryLinkedList, "Ternary LinkedList", "Ternary Search Linked List");
                    totalTimeDataset.addValue(totalElapsedTimeFibonacciLinkedList, "Fibonacci LinkedList", "Fibonacci Search Linked List");

                    JFreeChart totalTimebarChart = ChartFactory.createBarChart(
                            "Total Time Taken by Search Algorithms",    // Chart title
                            "Algorithm",                            // X-axis label
                            "Time (ns)",                       // Y-axis label
                            totalTimeDataset,
                            PlotOrientation.VERTICAL,
                            true,                                   // Include legend
                            true,
                            false
                    );

                    ChartPanel totalTimechartPanel = new ChartPanel(totalTimebarChart);
                    totalTimechartPanel.setPreferredSize(new java.awt.Dimension(800, 600));

                    javax.swing.JFrame totalTimeFrame = new javax.swing.JFrame("Search Algorithms Total Time");
                    totalTimeFrame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
                    totalTimeFrame.getContentPane().add(totalTimechartPanel);
                    totalTimeFrame.pack();
                    totalTimeFrame.setVisible(true);

                    System.out.println("\n");


                    break;
                case 2:
                    System.out.println("\nDisplaying mean, best and worst time for each algorithm");
                    System.out.println("----------------------------------------------------------");
                    System.out.println("Array List Binary Search - Best Time: " + bestTimeBinaryArrayList + " ns, Worst Time: " + worstTimeBinaryArrayList + " ns, Mean Time: " + meanTimeBinaryArrayList + " ns");
                    System.out.println("Array List Linear Search - Best Time: " + bestTimeLinearArrayList + " ns, Worst Time: " + worstTimeLinearArrayList + " ns, Mean Time: " + meanTimeLinearArrayList + " ns");
                    System.out.println("Array List Ternary Search - Best Time: " + bestTimeTernaryArrayList + " ns, Worst Time: " + worstTimeTernaryArrayList + " ns, Mean Time: " + meanTimeTernaryArrayList + " ns");
                    System.out.println("Array List Fibonacci Search - Best Time: " + bestTimeFibonacciArrayList + " ns, Worst Time: " + worstTimeFibonacciArrayList + " ns, Mean Time: " + meanTimeFibonacciArrayList + " ns");
                    System.out.println("Linked List Binary Search - Best Time: " + bestTimeBinaryLinkedList + " ns, Worst Time: " + worstTimeBinaryLinkedList + " ns, Mean Time: " + meanTimeBinaryLinkedList + " ns");
                    System.out.println("Linked List Linear Search - Best Time: " + bestTimeLinearLinkedList + " ns, Worst Time: " + worstTimeLinearLinkedList + " ns, Mean Time: " + meanTimeLinearLinkedList + " ns");
                    System.out.println("Linked List Ternary Search - Best Time: " + bestTimeTernaryLinkedList + " ns, Worst Time: " + worstTimeTernaryLinkedList + " ns, Mean Time: " + meanTimeTernaryLinkedList + " ns");
                    System.out.println("Linked List Fibonacci Search - Best Time: " + bestTimeFibonacciLinkedList + " ns, Worst Time: " + worstTimeFibonacciLinkedList + " ns, Mean Time: " + meanTimeFibonacciLinkedList + " ns");
                    System.out.println("\n");
                    double minMeanTime = Double.MAX_VALUE;
                    String fastestAlgorithm = "";

                    if (meanTimeBinaryArrayList < minMeanTime) {
                        minMeanTime = meanTimeBinaryArrayList;
                        fastestAlgorithm = "Binary Search on ArrayList";
                    }
                    if (meanTimeLinearArrayList < minMeanTime) {
                        minMeanTime = meanTimeLinearArrayList;
                        fastestAlgorithm = "Linear Search on ArrayList";
                    }
                    if (meanTimeTernaryArrayList < minMeanTime) {
                        minMeanTime = meanTimeTernaryArrayList;
                        fastestAlgorithm = "Ternary Search on ArrayList";
                    }
                    if (meanTimeFibonacciArrayList < minMeanTime) {
                        minMeanTime = meanTimeFibonacciArrayList;
                        fastestAlgorithm = "Fibonacci Search on ArrayList";
                    }
                    if (meanTimeBinaryLinkedList < minMeanTime) {
                        minMeanTime = meanTimeBinaryLinkedList;
                        fastestAlgorithm = "Binary Search on LinkedList";
                    }
                    if (meanTimeLinearLinkedList < minMeanTime) {
                        minMeanTime = meanTimeLinearLinkedList;
                        fastestAlgorithm = "Linear Search on LinkedList";
                    }
                    if (meanTimeTernaryLinkedList < minMeanTime) {
                        minMeanTime = meanTimeTernaryLinkedList;
                        fastestAlgorithm = "Ternary Search on LinkedList";
                    }
                    if (meanTimeFibonacciLinkedList < minMeanTime) {
                        minMeanTime = meanTimeFibonacciLinkedList;
                        fastestAlgorithm = "Fibonacci Search on LinkedList";
                    }

                    System.out.println("The fastest algorithm is: " + fastestAlgorithm);
                    System.out.println("Mean time is: " + minMeanTime);
                    System.out.println("\n");

                    break;
                case 3:
                    System.out.println("\nDisplaying graph of worst-case time complexity of these algorithms");
                    DefaultCategoryDataset dataset = new DefaultCategoryDataset();

                    dataset.addValue(worstTimeBinaryArrayList, "Binary ArrayList", "Binary Search Array List");
                    dataset.addValue(worstTimeLinearArrayList, "Linear ArrayList", "Linear Search Array List");
                    dataset.addValue(worstTimeTernaryArrayList, "Ternary ArrayList", "Ternary Search Array List");
                    dataset.addValue(worstTimeFibonacciArrayList, "Fibonacci ArrayList", "Fibonacci Search Array List");
                    dataset.addValue(worstTimeBinaryLinkedList, "Binary LinkedList", "Binary Search Linked List");
                    dataset.addValue(worstTimeLinearLinkedList, "Linear LinkedList", "Linear Search Linked List");
                    dataset.addValue(worstTimeTernaryLinkedList, "Ternary LinkedList", "Ternary Search Linked List");
                    dataset.addValue(worstTimeFibonacciLinkedList, "Fibonacci LinkedList", "Fibonacci Search Linked List");

                    JFreeChart barChart = ChartFactory.createBarChart(
                            "Worst-Case Time Complexity",    // Chart title
                            "Algorithm",                            // X-axis label
                            "Time (ns)",                       // Y-axis label
                            dataset,
                            PlotOrientation.VERTICAL,
                            true,                                   // Include legend
                            true,
                            false
                    );

                    ChartPanel chartPanel = new ChartPanel(barChart);
                    chartPanel.setPreferredSize(new java.awt.Dimension(800, 600));

                    javax.swing.JFrame frame = new javax.swing.JFrame("Search Algorithms Performance");
                    frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
                    frame.getContentPane().add(chartPanel);
                    frame.pack();
                    frame.setVisible(true);
                    System.out.println("\n");
                    break;
                case 0:
                    System.out.println("Exiting Race Menu...\n");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.\n");
            }
            if (searchChoice == 0) {
                break; // Exit the inner search menu loop
            }
        }
    }
}
