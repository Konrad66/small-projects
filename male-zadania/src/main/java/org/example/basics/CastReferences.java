package org.example.basics;

import java.util.Random;

public class CastReferences {
    public static void main(String[] args) {
        Object object = new Random();
        object = "abc";
       if(object.getClass().equals(String.class)) {
           String text = (String) object;
           System.out.println(text.toUpperCase());
       }

       String textNumber = "123abc";
       int asInt = Integer.parseInt(textNumber);
        System.out.println(asInt);
    }
}
