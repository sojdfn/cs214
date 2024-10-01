package com.mycompany.a1_cs214;

/**
 *
 * @author 67993
 */
public class Article implements Comparable<Article> {
    int Id;
    String Title;
    String Abstract;
    int Computer;
    int Physics;
    int Mathematics;
    int Statistics;
    int QuantitativeBiology;
    int QuantitativeFinance;

    public Article(int Id, String Title, String Abstract, int Computer, int Physics, int Mathematics,
                   int Statistics, int QuantitativeBiology, int QuantitativeFinance) {
        this.Abstract = Abstract;
        this.Mathematics = Mathematics;
        this.Computer = Computer;
        this.Id = Id;
        this.Physics = Physics;
        this.QuantitativeBiology = QuantitativeBiology;
        this.QuantitativeFinance = QuantitativeFinance;
        this.Statistics = Statistics;
        this.Title = Title;
    }

    public int getId() {
        return Id;
    }


    @Override
    public int compareTo(Article o) {

        return Integer.compare(this.Id, o.Id);
    }


}