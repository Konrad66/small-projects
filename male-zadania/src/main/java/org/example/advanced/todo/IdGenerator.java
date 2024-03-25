package org.example.advanced.todo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class IdGenerator {

    private static final String FILE_PATH = "UniqueId.txt";

    public int giveLastId(){
        try(Scanner scanner = new Scanner(new File(FILE_PATH))){
            return scanner.nextInt();
        } catch (FileNotFoundException e){
            System.out.println("Nie znaleziono pliku" + e);
        }
        return 0;
    }

    public void saveNewId(int naszaLiczba) {
        //String text = String.valueOf(naszaLiczba);
        try(FileWriter fileWriter = new FileWriter(FILE_PATH)){
            fileWriter.write(naszaLiczba + "");
        } catch (IOException e){
            System.out.println("Nie znaleziono pliku" + e);
        }
    }
}