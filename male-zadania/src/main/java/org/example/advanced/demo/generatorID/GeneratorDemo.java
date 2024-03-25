package org.example.advanced.demo.generatorID;

public class GeneratorDemo {
    public static void main(String[] args) {
        //tworze generator
        //pytam o najblizsza wolna liczbe
        //wyswietlam
        //kaze mu zapisac o jeden wieksza

        Generator generator = new Generator();
        int naszaLiczba = generator.dajOstatniaLiczbe();
        System.out.println(naszaLiczba);
        naszaLiczba++;
        generator.zapiszNowaLiczbe(naszaLiczba);
    }
}
