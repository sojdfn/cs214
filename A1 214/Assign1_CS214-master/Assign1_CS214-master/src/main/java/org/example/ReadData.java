package org.example;

import com.opencsv.CSVReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class ReadData {
    public static ArrayList<Article> readCSVFileArrayList(String filePath) {
        ArrayList<Article> articleList = new ArrayList<>();

        try{
            FileReader fileReader = new FileReader(filePath);
            CSVReader reader = new CSVReader(fileReader);
            String[] line;
            boolean isFirstLine = true;
            while ((line = reader.readNext()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }
                if (line.length == 9) {
                    try {
                        int id = Integer.parseInt(line[0]);
                        String title = line[1];
                        String abstractText = line[2];
                        int computerScience = Integer.parseInt(line[3]);
                        int physics = Integer.parseInt(line[4]);
                        int mathematics = Integer.parseInt(line[5]);
                        int statistics = Integer.parseInt(line[6]);
                        int quantitativeBiology = Integer.parseInt(line[7]);
                        int quantitativeFinance = Integer.parseInt(line[8]);
                        Article article = new Article(id, title, abstractText, computerScience, physics, mathematics, statistics, quantitativeBiology, quantitativeFinance);
                        articleList.add(article);

                    } catch (Exception e) {

                    }
                }
            }
        }
        catch (IOException e) {
        }
        return articleList;
    }

    public static LinkedList<Article> readCSVFileLinkedList(String filePath) {
        LinkedList<Article> articleList = new LinkedList<>();

        try{
            FileReader fileReader = new FileReader(filePath);
            CSVReader reader = new CSVReader(fileReader);
            String[] line;
            boolean isFirstLine = true;
            while ((line = reader.readNext()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue; // Skip the first line (header)
                }
                if (line.length == 9) {
                    try {
                        // Assuming line[0] is ID, line[1] is TITLE, line[2] is ABSTRACT, and so on...
                        int id = Integer.parseInt(line[0]);
                        String title = line[1];
                        String abstractText = line[2];
                        int computerScience = Integer.parseInt(line[3]);
                        int physics = Integer.parseInt(line[4]);
                        int mathematics = Integer.parseInt(line[5]);
                        int statistics = Integer.parseInt(line[6]);
                        int quantitativeBiology = Integer.parseInt(line[7]);
                        int quantitativeFinance = Integer.parseInt(line[8]);
                        Article article = new Article(id, title, abstractText, computerScience, physics, mathematics, statistics, quantitativeBiology, quantitativeFinance);
                        articleList.add(article);
                    } catch (Exception e) {
                    }
                }
            }
        }
        catch (IOException e) {
        }
        return articleList;
    }
}