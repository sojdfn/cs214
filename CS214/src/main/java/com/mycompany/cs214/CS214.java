package com.mycompany.cs214;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import javax.swing.*;
import java.awt.*;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class CS214 {
    //Create Article class
    public static class Article  
    {
        String id;
        String title;
        String abstract_;
        String computerScience;
        String physics;
        String mathematics;
        String statistics;
        String quantitativeBiology;
        String quantitativeFinance;
        public Article(String id, String title, String abstract_, String computerScience, String physics, String mathematics, String statistics, String quantitativeBiology, String quantitativeFinance) 
        {
            this.id = id;
            this.title = title;
            this.abstract_ = abstract_;
            this.computerScience = computerScience;
            this.physics = physics;
            this.mathematics = mathematics;
            this.statistics = statistics;
            this.quantitativeBiology = quantitativeBiology;
            this.quantitativeFinance = quantitativeFinance;
        }
    }
    public static void main(String[] args) throws IOException 
    {
        //Make array lists
        ArrayList<Article> articles = new ArrayList<>();
        //Make Linked lists
        LinkedList<Article> LINKED = new LinkedList<>();
        try (CSVParser csvParser = new CSVParser(new FileReader("Article.csv"), CSVFormat.DEFAULT)) 
        {
            boolean first = true;
            for (CSVRecord rec : csvParser) 
            {
                if (first) 
                {
                    first = false;
                    continue;
                }
                String id = rec.get(0);
                String title = rec.get(1);
                String abstract_ = rec.get(2);
                String computerScience = rec.get(3);
                String physics = rec.get(4);
                String mathematics = rec.get(5);
                String statistics = rec.get(6);
                String quantitativeBiology = rec.get(7);
                String quantitativeFinance = rec.get(8);
                Article article = new Article(id, title, abstract_, computerScience, physics, mathematics, statistics, quantitativeBiology, quantitativeFinance);
                articles.add(article);
                LINKED.add(article);
            }
        }
        
        int numberOfRuns = 30;
        long startTime, endTime, duration;
        startTime = System.currentTimeMillis();
        endTime = System.currentTimeMillis();
        duration = endTime - startTime;
        Scanner scanner = new Scanner(System.in);

            searchAndShowResults(articles, LINKED);

            seeSearchTypeResults(articles, LINKED);
            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("Running code 30 times");
    // Run the search algorithms and calculate runs here for 30 times
    long[] linearArrayListTimes = new long[numberOfRuns];
    long[] sentinelArrayListTimes = new long[numberOfRuns];
    long[] linearLinkedListTimes = new long[numberOfRuns];
    long[] sentinelLinkedListTimes = new long[numberOfRuns];
    Random random = new Random();
    System.out.println("");

    for (int i = 0; i < numberOfRuns; i++) {
        String randomSearchTerm = getRandomSearchTerm(articles, random);

        startTime = System.currentTimeMillis();
        linearSearch(articles, randomSearchTerm);
        endTime = System.currentTimeMillis();
        linearArrayListTimes[i] = endTime - startTime; // Store the execution time

        startTime = System.currentTimeMillis();
        sentinelLinearSearch(articles, randomSearchTerm);
        endTime = System.currentTimeMillis();
        sentinelArrayListTimes[i] = endTime - startTime; // Store the execution time

        startTime = System.currentTimeMillis();
        linearSearch(LINKED, randomSearchTerm); // Linear search for linked list
        endTime = System.currentTimeMillis();
        linearLinkedListTimes[i] = endTime - startTime; // Store the execution time

        startTime = System.currentTimeMillis();
        sentinelLinearSearch(LINKED, randomSearchTerm); // Sentinel search for linked list
        endTime = System.currentTimeMillis();
        sentinelLinkedListTimes[i] = endTime - startTime; // Store the execution time
    }
    System.out.println("Making graph now");
    graphResults(linearArrayListTimes, sentinelArrayListTimes, linearLinkedListTimes, sentinelLinkedListTimes);

    }
    

    public static String getRandomSearchTerm(ArrayList<Article> list, Random random) 
    {
        Article randomArticle = list.get(random.nextInt(list.size()));
        return randomArticle.id;
    }
   public static int linearSearch(ArrayList<Article> list, String searchTerm) 
   {
    int comparisons = 0; // Initialize the counter
    for (int i = 0; i < list.size(); i++) 
    {
        comparisons++; // Increment the counter for each comparison
        if (list.get(i).id.equals(searchTerm)) 
        {
            System.out.println("Found run no. " + i + " Num Runs " + comparisons);
            return i;
        }
    }
    System.out.println("Not Found "  + " Num Runs " + comparisons);
    return -1;
}

public static int sentinelLinearSearch(ArrayList<Article> list, String searchTerm) {
    int comparisons = 0; 
    int lastIdx = list.size() - 1;
    Article lastArticle = list.get(lastIdx);
    list.set(lastIdx, new Article(searchTerm, "", "", "", "", "", "", "", ""));

    int i = 0;
    while (!list.get(i).id.equals(searchTerm)) {
        comparisons++; 
        i++;
    }

    list.set(lastIdx, lastArticle); // Restore the last element
    if (i < lastIdx || list.get(lastIdx).id.equals(searchTerm)) 
    {
        System.out.println("Found run no. " + i + " Num Runs " + comparisons);
        return i;
    }
    System.out.println("Not Found " + i + " Num Runs " + comparisons);
    return -1;
}

    //Linear search code linkedlist 
    public static int linearSearch(LinkedList<Article> list, String searchTerm) 
    {
        for (int i = 0; i < list.size(); i++) 
        {
            if (list.get(i).id.equals(searchTerm)) 
            {
                return i;
            }
        }
        return -1;
    }
   
    //sequential search linked list
    public static int sentinelLinearSearch(LinkedList<Article> list, String searchTerm)  
    {
        
        list.add(new Article(searchTerm, "", "", "", "", "", "", "", ""));
        int i = 0;
        while (!list.get(i).id.equals(searchTerm)) 
        {
            i++;
        }
        list.remove(list.size() - 1);
        if (i < list.size()) 
        {
            return i;
        }
        return -1;
    }
   public static void searchAndShowResults(ArrayList<Article> articles, LinkedList<Article> LINKED) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Search ID: ");
    String searchTerm = scanner.nextLine();

    int arrayListIndex = linearSearch(articles, searchTerm);
    int linkedListIndex = linearSearch(LINKED, searchTerm);

    if (arrayListIndex != -1) {
        System.out.println("Search term found in ArrayList at index: " + arrayListIndex);
        System.out.println("Article ID: " + articles.get(arrayListIndex).id);
        System.out.println("Number of comparisons made (ArrayList): " + (arrayListIndex + 1));
    } else {
        System.out.println("Search term not found in ArrayList.");
    }

    if (linkedListIndex != -1) {
        System.out.println("Search term found in LinkedList at index: " + linkedListIndex);
        System.out.println("Article ID: " + LINKED.get(linkedListIndex).id);
        System.out.println("Number of comparisons made (LinkedList): " + (linkedListIndex + 1)); 
    } else {
        System.out.println("Search term not found in LinkedList.");
    }
}

public static void seeSearchTypeResults(ArrayList<Article> articles, LinkedList<Article> LINKED) {
    Random random = new Random();
    String randomSearchTerm = getRandomSearchTerm(articles, random);

    int linearArrayListIndex = linearSearch(articles, randomSearchTerm);
    int sentinelArrayListIndex = sentinelLinearSearch(articles, randomSearchTerm);

    int linearLinkedListIndex = linearSearch(LINKED, randomSearchTerm);
    int sentinelLinkedListIndex = sentinelLinearSearch(LINKED, randomSearchTerm);

    System.out.println("Results for random search term: " + randomSearchTerm);
    System.out.println("Linear Search Result (ArrayList): " + linearArrayListIndex);
    System.out.println("Sentinel Linear Search Result (ArrayList): " + sentinelArrayListIndex);
    System.out.println("Linear Search Result (LinkedList): " + linearLinkedListIndex);
    System.out.println("Sentinel Linear Search Result (LinkedList): " + sentinelLinkedListIndex);
}

public static void graphResults(long[] linearArrayListTimes, long[] sentinelArrayListTimes,
                                long[] linearLinkedListTimes, long[] sentinelLinkedListTimes) 
{
    SwingUtilities.invokeLater(() -> 
    {
        JFrame frame = new JFrame("Graph");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        XYSeriesCollection dataset = new XYSeriesCollection();
        XYSeries linearArrayListSeries = new XYSeries("Linear (ArrayList)");
        XYSeries sentinelArrayListSeries = new XYSeries("Sentinel (ArrayList)");

        for (int i = 0; i < linearArrayListTimes.length; i++) 
        {
            linearArrayListSeries.add(i + 1, linearArrayListTimes[i]);
            sentinelArrayListSeries.add(i + 1, sentinelArrayListTimes[i]);
        }
        dataset.addSeries(linearArrayListSeries);
        dataset.addSeries(sentinelArrayListSeries);

        JFreeChart chart = ChartFactory.createXYLineChart
        (
            "Graph",
            "Run",
            "Execution Time (ms)", 
            dataset,
            PlotOrientation.VERTICAL,
            true,
            true,
            false
        );
        ChartPanel chartPanel = new ChartPanel(chart);
        frame.getContentPane().add(chartPanel, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    });
}
}

