package org.example.basics.exe40;

public class Line {

    private int length;
    private String fill;


    public Line(int length, String fill) {
        this.length = length;
        this.fill = fill;
    }

    public void print() {
        for (int i = 0; i < length; i++) {
            System.out.print(fill);
        }
        System.out.println();
    }
}