package org.example.advanced.escape_room;

import java.util.Scanner;

public class EscapeRoom {

    public String input;
    public Boolean window;
    public Boolean door;
    public Scanner scanner = new Scanner(System.in);

    public void start(){
        room();
        windowAction();


    }

    public void windowAction(){
        do {
            input = scanner.next();
            if (input.equals("close")) {
                System.out.println("Window are closed");
            } else if (input.equals("open")){
                System.out.println("Window are open");
            }
        } while (true);
    }


    public void room() {
        System.out.println("Hello you have to escape room. You have to find key and open the door. ");
        System.out.print("You can open and close window using command 'open' and 'close'. ");
        System.out.print("You can take key using command 'take'. ");
        System.out.print("You can open door using command 'key'.");
    }

    public boolean executeInteraction() {
        switch (input) {
            case "key":
                System.out.println("Key was taken");
                break;
            case "door":
                System.out.println("Door are closed");
                break;
            case "window":
                System.out.println("Window are opened");
                break;
            default:
                System.out.println("Do action!");
        }
        return false;
    }




    public static void main(String[] args) {
        EscapeRoom escapeRoom = new EscapeRoom();
        escapeRoom.start();
    }
}