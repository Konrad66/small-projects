package org.example.basics.exe40;

public class LineApplication {

    public static void main(String[] args) {
        Line line1 = new Line(10, "@");
        Line line2 = new Line(15, "*");
        Line line3 = new Line(1, "!");

        line1.print();
        line2.print();
        line3.print();
    }
}