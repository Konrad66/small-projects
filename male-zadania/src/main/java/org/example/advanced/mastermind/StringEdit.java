package org.example.advanced.mastermind;

public class StringEdit {
    public static void main(String[] args) {
        String input = "/))))";
        StringBuilder input2 = new StringBuilder(input);
        System.out.println(input2);
        int j = 0;
        input2.setCharAt(j,')');
        System.out.println(input2);
        System.out.println(input);
        input = input2.toString()
        System.out.println(input);
    }
}
