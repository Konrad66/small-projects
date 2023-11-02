package org.example.advanced.escape_room;

import javax.swing.*;
import java.util.Scanner;

public class InputGeneratorGui implements InputGenerator{

    @Override
    public String readText() {
        String input = JOptionPane.showInputDialog("Napisz swój wybór");
       if(input == null){
           System.exit(0);
       }
        return input;
    }
}
