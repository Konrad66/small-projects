package org.example.advanced.hangman;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileControl {

    private static String FILE_PATH_WORDS = "words.csv";

    List<String> loadWords() {
        List<String> words = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(FILE_PATH_WORDS))) {
            while (scanner.hasNextLine()) {
                String text = scanner.nextLine();
                String[] data = text.split(";");
                String word = data[1];
                words.add(word);
            }
            System.out.println("Plik został poprawnie załadowany");
        } catch (IOException e) {
            System.out.println("Nie znaleziono pliku o nazwie " + e);
        }
        return words;
    }
}