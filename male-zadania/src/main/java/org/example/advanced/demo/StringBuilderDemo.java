package org.example.advanced.demo;

public class StringBuilderDemo {
    public static void main(String[] args) {
        StringBuilder name = new StringBuilder();

        for (int i = 0; i < 1000000; i++) {
            name.append("hello")
                    .append("word");

        }
        System.out.println(name);
    }
}


//todo Object Java - poczytać, co to, jak sie uzywa i do czego