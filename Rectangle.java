package com.company;

public class Rectangle {
    private Point start;
    private int a;
    private int b;

    private int s;

    public Rectangle() {
    }

    public Rectangle(Point start, int a, int b) {
        this.start = start;
        this.a = a;
        this.b = b;
        this.s = a*b;
    }


    public Point getStart() {
        return start;
    }

    public void setStart(Point start) {
        this.start = start;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getS() {
        return s;
    }

    public void setS(int s) {
        this.s = s;
    }
}
