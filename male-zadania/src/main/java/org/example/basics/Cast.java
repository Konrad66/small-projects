package org.example.basics;


public class Cast {
    public static void main(String[] args) {
        System.out.println();
        String text = new String("abc");
        long number = 123_232_345_456L;
        int number2 = (int)number;
        System.out.println(number2);


        int smallNumber = 12334;
        long bigNumber = smallNumber;
        //typy dzielimi na: prymitywne i referencyjne
        //zekres jest zawwsze dzielony na pol rowniez dla wartosci minusowych
        //p rzykladowo byte ma zakres 8 miejsc (w kodzie 01) co daje zakres 2^8 co przeklada sie na -128 do 127
        int number3 = 300;
        byte number4 = (byte) (number3 + 700);
        System.out.println(number4);
        int number5 = (int) 123.8;
        int number6 = (int)Math.round(123.8 );
        char symbol = (char) number6;
        System.out.println(symbol);
        System.out.println(number6);
        //System.out.println(number5);


        for (int i = 'a'; i <= 'z' ; i++) {
            System.out.println((char) i);
        }


        //bit:


    }
}
