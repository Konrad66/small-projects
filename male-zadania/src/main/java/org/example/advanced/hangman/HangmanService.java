package org.example.advanced.hangman;

import java.util.ArrayList;
import java.util.List;

public class HangmanService {


    String losujSlowo(){
        List<String> words = new ArrayList<>();
        words.add("komputer");
        words.add("monitor");

        return words.get(0);
    }

    //masz slowo i odgadniete litery
    //zacznij od pustego napisu jako wynik
    //zamieniam slowo i odgadniete litery na male
    //dla kazdej litery slowa
    // która nie jest zadna z odgadnietych liter
    //dodaj do wyniku kreske
    // w przeciwnym razie dodaj odgadnieta litere


    //jesli ta litera == odgadnieta litera
    // zamien kreske na litere

    String zakodujSlowo(String word, List<String> odgadnieteLitery){
        String result = "";
        word = word.toLowerCase();
        for(int i = 0; i < odgadnieteLitery.size(); i++) {
            odgadnieteLitery.set(i, odgadnieteLitery.get(i).toLowerCase());
        }
        for (int i = 0; i < word.length(); i++) {
            boolean odgadnieta = false;
            for(int j = 0; j < odgadnieteLitery.size(); j++){
                if ((word.charAt(i) +"").equals(odgadnieteLitery.get(j))) {
                    odgadnieta = true;
                }
            }
            String symbol;
            if(!odgadnieta){
                symbol = "-";
            } else {
                symbol = word.charAt(i) + "";
            }
            result += " " + symbol + " ";
        }
        return result;
    }
/*
    String zakodujSlowo2(String word, char odgadnietaLitera){
        String result = "";
        for (char letter: word.toCharArray() ) {
            if(letter != odgadnietaLitera){
                result += " - ";
            } else {
                result += odgadnietaLitera;
            }
        }
        return result;
    }*/

   /* public static void main(String[] args) {
        HangmanService hangmanService = new HangmanService();
        System.out.println(hangmanService.losujSlowo());
    }*/


    public static void main(String[] args) {
        HangmanService hangmanService = new HangmanService();
        ArrayList<String> letters = new ArrayList<>();
        letters.add("k");
        letters.add("o");
        letters.add("h");
        System.out.println(hangmanService.zakodujSlowo("Komputer", letters));
        // A _ a
    }

    // liste -> słowa
    // losował z listy jedno słowo
    //


}
