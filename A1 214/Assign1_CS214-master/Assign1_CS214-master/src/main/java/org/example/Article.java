package org.example;

public class Article implements Identifiable {
    private int id;
    private String title;
    private String abstractText;
    private int computerScience;
    private int physics;
    private int mathematics;
    private int statistics;
    private int quantitativeBiology;
    private int quantitativeFinance;

    public Article(int id, String title, String abstractText, int computerScience, int physics, int mathematics, int statistics, int quantitativeBiology, int quantitativeFinance) {
        this.id = id;
        this.title = title;
        this.abstractText = abstractText;
        this.computerScience = computerScience;
        this.physics = physics;
        this.mathematics = mathematics;
        this.statistics = statistics;
        this.quantitativeBiology = quantitativeBiology;
        this.quantitativeFinance = quantitativeFinance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAbstractText() {
        return abstractText;
    }

    public void setAbstractText(String abstractText) {
        this.abstractText = abstractText;
    }

    public int getComputerScience() {
        return computerScience;
    }

    public void setComputerScience(int computerScience) {
        this.computerScience = computerScience;
    }

    public int getPhysics() {
        return physics;
    }

    public void setPhysics(int physics) {
        this.physics = physics;
    }

    public int getMathematics() {
        return mathematics;
    }

    public void setMathematics(int mathematics) {
        this.mathematics = mathematics;
    }

    public int getStatistics() {
        return statistics;
    }

    public void setStatistics(int statistics) {
        this.statistics = statistics;
    }

    public int getQuantitativeBiology() {
        return quantitativeBiology;
    }

    public void setQuantitativeBiology(int quantitativeBiology) {
        this.quantitativeBiology = quantitativeBiology;
    }

    public int getQuantitativeFinance() {
        return quantitativeFinance;
    }

    public void setQuantitativeFinance(int quantitativeFinance) {
        this.quantitativeFinance = quantitativeFinance;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", abstractText='" + abstractText + '\'' +
                ", computerScience=" + computerScience +
                ", physics=" + physics +
                ", mathematics=" + mathematics +
                ", statistics=" + statistics +
                ", quantitativeBiology=" + quantitativeBiology +
                ", quantitativeFinance=" + quantitativeFinance +
                '}';
    }
}