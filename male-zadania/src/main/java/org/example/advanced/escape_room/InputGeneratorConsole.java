package org.example.advanced.escape_room;

import java.util.Scanner;

public class InputGeneratorConsole implements InputGenerator{

    @Override
    public String readText() {
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

}
