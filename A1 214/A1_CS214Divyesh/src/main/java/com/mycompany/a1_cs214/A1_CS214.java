
package com.mycompany.a1_cs214;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import java.awt.BorderLayout;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.*;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;


/**
 *
 * @author AAYUSH AVICHAL KUMAR -S11208683
 *         SHIVA LATCHMAN NARAYAN -S11208843
 *         DIYVESH KUMAR MISTRY   -
 */

public class A1_CS214 {
  public static void main(String[] args) throws IOException {
        String file = "Article.csv";
        String[] line;
        ArrayList<Article> articleList = new ArrayList<>();
        LinkedList<Article> articleLinkedList = new LinkedList<>();
        JumpSearch Search = new JumpSearch();
        LinearSearch linearSearch = new LinearSearch();
        TernerySearch ternerySearch= new TernerySearch();
        BinarySearch binarySearch = new BinarySearch();

        int key = 888;
        int runs = 30;
        int size = 21000;
        int bestCase= Integer.MAX_VALUE;
        int worstCase= Integer.MIN_VALUE;
        int comparison = 0;


        Scanner scan = new Scanner(System.in);

        try {
            CSVParser parser = new CSVParserBuilder()
                    .withSeparator(',')
                    .withEscapeChar('\07')
                    .build();
            CSVReader reader = new CSVReaderBuilder(new FileReader(file))
                    .withCSVParser(parser)
                    .withSkipLines(1)
                    .build();

            while ((line = reader.readNext()) != null) {

                    int id = Integer.parseInt(line[0]);
                    String title = line[1];
                    String abstracts = line[2];
                    int computer = Integer.parseInt(line[3]);
                    int physics = Integer.parseInt(line[4]);
                    int maths = Integer.parseInt(line[5]);
                    int statistics = Integer.parseInt(line[6]);
                    int qbiology = Integer.parseInt(line[7]);
                    int qfinance = Integer.parseInt(line[8]);

                Article alist = new Article(id, title, abstracts, computer, physics, maths, statistics, qbiology, qfinance);
                articleList.add(alist);

                Article aLinkedlist = new Article(id, title, abstracts, computer, physics, maths, statistics, qbiology, qfinance);
                articleLinkedList.add(aLinkedlist);



            }
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        
        System.out.println("Race Result For Each Algorithm");

        Map<Integer, Article> resultMap = new HashMap<>();
        Thread jumpSearchArrayListThread = new Thread(() -> {
            long start = System.currentTimeMillis();
            int num = Search.jumpSearchArrayList(articleList, key);
            Results(num, articleList, resultMap);
            long end = System.currentTimeMillis();
            executionTime("jumpSearchArrayList",start,end );

        });

        Thread linearSearchLinkedListThread = new Thread(() -> {
            long start = System.currentTimeMillis();
            int num = linearSearch.linearSLinkedList(key, articleLinkedList);
            Results(num, articleLinkedList, resultMap);
            long end = System.currentTimeMillis();
            executionTime("linearSearchLinkedList",start,end );
        });

        Thread jumpSearchLinkedListThread = new Thread(() -> {
            long start = System.currentTimeMillis();
            int num = Search.jumpSearchLinkedList(articleLinkedList, key);
            Results(num, articleLinkedList, resultMap);
            long end = System.currentTimeMillis();
            executionTime("jumpSearchLinkedList",start,end );
        });

        Thread linearSearchArrayListThread = new Thread(() -> {
            long start = System.currentTimeMillis();
            int num = linearSearch.linearSArrayList(key, articleList);
            Results(num, articleList, resultMap);
            long end = System.currentTimeMillis();
            executionTime("linearSearchArrayList",start,end );
        });

        Thread ternarySearchArrayListThread = new Thread(() -> {
            long start = System.currentTimeMillis();
            int num = ternerySearch.ternarySArrayList(key, articleList);
            Results(num, articleList, resultMap);
            long end = System.currentTimeMillis();
            executionTime("ternarySearchArrayList",start,end );
        });

        Thread ternarySearchLinkedListThread = new Thread(() -> {
            long start = System.currentTimeMillis();
            int num = ternerySearch.ternarySLinkedList(key, articleLinkedList);
            Results(num, articleLinkedList, resultMap);
            long end = System.currentTimeMillis();
            executionTime("ternarySearchLinkedList",start,end );
        });

        Thread binarySearchArrayListThread = new Thread(() -> {
            long start = System.currentTimeMillis();
            int num = binarySearch.binarySearchArrayList(articleList, key);
            Results(num, articleLinkedList, resultMap);
            long end = System.currentTimeMillis();
            executionTime("binarySearchArrayList",start,end );
        });

        Thread binarySearchLinkedListThread = new Thread(() -> {
            long start = System.currentTimeMillis();
            int num = binarySearch.binarySearchLinkedList(articleLinkedList, key);
            Results(num, articleLinkedList, resultMap);
            long end = System.currentTimeMillis();
            executionTime("binarySearchLinkedList",start,end );
        });

        jumpSearchArrayListThread.start();
        linearSearchLinkedListThread.start();
        jumpSearchLinkedListThread.start();
        linearSearchArrayListThread.start();
        ternarySearchArrayListThread.start();
        ternarySearchLinkedListThread.start();
        binarySearchArrayListThread.start();
        binarySearchLinkedListThread.start();

        try {
            jumpSearchArrayListThread.join();
            linearSearchLinkedListThread.join();
            jumpSearchLinkedListThread.join();
            linearSearchArrayListThread.join();
            ternarySearchArrayListThread.join();
            ternarySearchLinkedListThread.join();
            binarySearchArrayListThread.join();
            binarySearchLinkedListThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
       
        System.out.println("");
        System.out.println( "\t*********************************************************\n" +
                            "\t*To print Details of jump search ArrayList Enter 1\t* \n" +
                            "\t*To print Details of jump search Linkedlist Enter 2\t* \n" +
                            "\t*To print Details of Binary search ArrayList Enter 3\t* \n" +
                            "\t*To print Details of Binary search Linkedlist Enter 4\t* \n" +
                            "\t*To print Details of Linear search ArrayList Enter 5\t* \n" +
                            "\t*To print Details of Linear search LinkedList Enter 6\t*\n" +
                            "\t*To print Details of Ternery search ArrayList Enter 7\t* \n" +
                            "\t*To print Details of Ternery search ArrayList Enter 8:\t* \n" +
                            "\t*********************************************************");
        System.out.print("Choice:  ");
        int in = scan.nextInt();
        Random rand = new Random();

        switch (in)
        {
            case 1 ->
            {
                for(int i=0; i<runs; i++) {
                    int Target = getRandomTarget(articleList.size(), rand);
                    int compare = Search.jumpSearchArrayList(articleList, Target);
                    if (compare < bestCase) {
                        bestCase = compare;
                    } else if (compare > worstCase) {
                        worstCase = compare;
                    }
                    comparison += compare;
                }

                System.out.println("Best Case: "+ bestCase);
                System.out.println("Worst Case: "+worstCase);
                System.out.println("Mean Case: "+mean(comparison,runs));

            }
            case 2 ->
            {
                for(int i=0; i<runs; i++) {
                    int Target = getRandomTarget(articleList.size(), rand);
                    int compare = Search.jumpSearchLinkedList(articleLinkedList, Target);
                    if (compare < bestCase) {
                        bestCase = compare;
                    } else if (compare > worstCase) {
                        worstCase = compare;
                    }
                    comparison += compare;
                }

                System.out.println("Best Case: "+ bestCase);
                System.out.println("Worst Case: "+worstCase);
                System.out.println("Mean Case: "+mean(comparison,runs));
            }
            case 3 ->
            {

                for(int i=0; i<runs; i++) {
                    int Target = getRandomTarget(articleList.size(), rand);
                    int compare = binarySearch.binarySearchArrayList(articleList, Target);
                    if (compare < bestCase) {
                        bestCase = compare;
                    } else if (compare > worstCase) {
                        worstCase = compare;
                    }
                    comparison += compare;
                }

                System.out.println("Best Case: "+ bestCase);
                System.out.println("Worst Case: "+worstCase);
                System.out.println("Mean Case: "+mean(comparison,runs));

            }
            case 4 ->
            {
                for(int i=0; i<runs; i++) {
                int Target = getRandomTarget(articleList.size(), rand);
                int compare = binarySearch.binarySearchLinkedList(articleLinkedList, Target);
                    if (compare < bestCase) {
                        bestCase = compare;
                    } else if (compare > worstCase) {
                        worstCase = compare;
                    }
                    comparison += compare;
                }

                System.out.println("Best Case: "+ bestCase);
                System.out.println("Worst Case: "+worstCase);
                System.out.println("Mean Case: "+mean(comparison,runs));
            }
            case 5 ->
            {
                for(int i=0; i<runs; i++) {
                    int Target = getRandomTarget(articleList.size(), rand);
                    int compare = linearSearch.linearSArrayList(Target, articleList);
                    if (compare < bestCase) {
                        bestCase = compare;
                    } else if (compare > worstCase) {
                        worstCase = compare;
                    }
                    comparison += compare;
                }

                System.out.println("Best Case: "+ bestCase);
                System.out.println("Worst Case: "+worstCase);
                System.out.println("Mean Case: "+mean(comparison,runs));

            }
            case 6 ->
            {
                for(int i=0; i<runs; i++) {
                    int Target = getRandomTarget(articleList.size(), rand);
                    int compare = linearSearch.linearSLinkedList(Target, articleLinkedList);
                    if (compare < bestCase) {
                        bestCase = compare;
                    } else if (compare > worstCase) {
                        worstCase = compare;
                    }
                    comparison += compare;
                }

                System.out.println("Best Case: "+ bestCase);
                System.out.println("Worst Case: "+worstCase);
                System.out.println("Mean Case: "+mean(comparison,runs));

            }
            case 7 ->
            {

                for(int i=0; i<runs; i++) {
                    int Target = getRandomTarget(articleList.size(), rand);
                    int compare = ternerySearch.ternarySArrayList(Target, articleList);
                    if (compare < bestCase) {
                        bestCase = compare;
                    } else if (compare > worstCase) {
                        worstCase = compare;
                    }
                    comparison += compare;
                }

                System.out.println("Best Case: "+ bestCase);
                System.out.println("Worst Case: "+worstCase);
                System.out.println("Mean Case: "+mean(comparison,runs));
            }
            case 8 ->
            {
                for(int i=0; i<runs; i++) {

                    int Target = getRandomTarget(articleList.size(), rand);
                    int compare = ternerySearch.ternarySLinkedList(Target, articleLinkedList);
                    if (compare < bestCase) {
                        bestCase = compare;
                    } else if (compare > worstCase) {
                        worstCase = compare;
                    }
                    comparison += compare;
                }

                System.out.println("Best Case: "+ bestCase);
                System.out.println("Worst Case: "+worstCase);
                System.out.println("Mean Case: "+mean(comparison,runs));

            }
        }
        
        System.out.println("");
        System.out.println( "\t*******************************************\n" +
                            "\t*To print Graph of linear search 1\t\t* \n" +
                            "\t*To print Graph of jump search 2\t\t* \n" +
                            "\t*To print Graph of Binary search 3\t* \n" +
                            "\t*To print Graph of Ternery search 4\t* \n" +
                            "\t*********************************************");
        System.out.print("Choice:  ");
        int choice = scan.nextInt();
       
         switch (choice)
        {
            case 1 ->
            {
        
        //Linear Search Graph//
        long[] linearArrayListTimes = new long[30];
        long[] linearLinkedListTimes = new long[30];

        for (int i = 0; i < 30; i++) {
            int Target = getRandomTarget(articleList.size(), new Random());
            
            long startTime = System.nanoTime();
            int linearArrayListResult = linearSearch.linearSArrayList(Target, articleList);
            long endTime = System.nanoTime();
            linearArrayListTimes[i] = endTime - startTime;
            
            startTime = System.nanoTime();
            int linearLinkedListResult = linearSearch.linearSLinkedList(Target, articleLinkedList);
            endTime = System.nanoTime();
            linearLinkedListTimes[i] = endTime - startTime;
        }

        graphResults(linearArrayListTimes, linearLinkedListTimes);
        
            }
    
         
            case 2 ->
            {
        
        //Jump Search Graph//
        long[] JumpArrayListTimes = new long[30];
        long[] JumpLinkedListTimes = new long[30];

        for (int i = 0; i < 30; i++) {
            int Target = getRandomTarget(articleList.size(), new Random());
            
            long startTime = System.nanoTime();
            int JumpArrayListResult = Search.jumpSearchArrayList(articleList, Target);
            long endTime = System.nanoTime();
            JumpArrayListTimes[i] = endTime - startTime;
            
            startTime = System.nanoTime();
            int JumpLinkedListResult = Search.jumpSearchLinkedList(articleLinkedList, Target);
            endTime = System.nanoTime();
            JumpLinkedListTimes[i] = endTime - startTime;
        }

        graphResults(JumpArrayListTimes, JumpLinkedListTimes);
        
            }
            
            case 3 ->
                
            {
        
        //Jump Search Grahp//
        long[] BinarArrayListTimes = new long[30];
        long[] BinaryLinkedListTimes = new long[30];

        for (int i = 0; i < 30; i++) {
            int Target = getRandomTarget(articleList.size(), new Random());
            
            long startTime = System.nanoTime();
            int BinaryArrayListResult = binarySearch.binarySearchArrayList(articleList, Target);
            long endTime = System.nanoTime();
            BinarArrayListTimes[i] = endTime - startTime;
            
            startTime = System.nanoTime();
            int BinaryLinkedListResult = binarySearch.binarySearchLinkedList(articleLinkedList, Target);
            endTime = System.nanoTime();
            BinaryLinkedListTimes[i] = endTime - startTime;
        }

        graphResults(BinarArrayListTimes, BinaryLinkedListTimes);
        
            }
            
                      case 4 ->
            {
        
        //Jump Search Grahp//
        long[] TerneryArrayListTimes = new long[30];
        long[] TerneryLinkedListTimes = new long[30];

        for (int i = 0; i < 30; i++) {
            int Target = getRandomTarget(articleList.size(), new Random());
            
            long startTime = System.nanoTime();
            int TerneryArrayListResult = ternerySearch.ternarySArrayList(Target, articleList);
            long endTime = System.nanoTime();
            TerneryArrayListTimes[i] = endTime - startTime;
            
            startTime = System.nanoTime();
            int TerneryLinkedListResult = ternerySearch.ternarySLinkedList(Target, articleLinkedList);
            endTime = System.nanoTime();
            TerneryLinkedListTimes[i] = endTime - startTime;
        }

        graphResults(TerneryArrayListTimes, TerneryLinkedListTimes);
        
            }    
         
         }     
  }
         
    private static void Results(int num, List<Article> articleList, Map<Integer, Article> resultMap) {
        if (num != -1) {
            Article foundArticle = articleList.get(num);
            resultMap.put(foundArticle.Id, foundArticle);
        } else {
            System.out.println("error 404: ID not found");
        }
    }
    private static void executionTime(String Search, long start, long end){
        long executionTime = end - start;
        System.out.println(Search+ " executes in: "+ executionTime+ "ms");
    }

    public static int getRandomId(){
    Random random = new Random();
    return random.nextInt(20999)+1;
    }

    private static int getRandomTarget(int listSize, Random random) {
        return random.nextInt(listSize);
    }

    private static Double mean(int comparison, int runs){
        Double mean = (double) comparison/runs;
        return mean;
    }
public static void graphResults(long[] ArrayListTimes, long[] LinkedListTimes) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Execution Time Graph");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            XYSeriesCollection dataset = new XYSeriesCollection();
            XYSeries ArrayListSeries = new XYSeries("(ArrayList)");
            XYSeries LinkedListSeries = new XYSeries("(LinkedList)");

            for (int i = 0; i < ArrayListTimes.length; i++) {
                ArrayListSeries.add(i + 1, ArrayListTimes[i]);
                LinkedListSeries.add(i + 1, LinkedListTimes[i]);
            }
            dataset.addSeries(ArrayListSeries);
            dataset.addSeries(LinkedListSeries);

            JFreeChart chart = ChartFactory.createXYLineChart(
                    " Execution Time Graph",
                    "Run",
                    "Execution Time (ns)",
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




