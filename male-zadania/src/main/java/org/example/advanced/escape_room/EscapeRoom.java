package org.example.advanced.escape_room;

import java.util.Scanner;

public class EscapeRoom {

    public String input;
    public Boolean keyTaken = false;
    public Boolean windowOpen = false;
    public Boolean door;
    public Scanner scanner = new Scanner(System.in);

    public void start() {
        room();
        action();


    }

    public void room() {
        System.out.println("Hello you have to escape room. You have to find key and open the door. ");
        System.out.println("Escape room: window, key, door");
    }


    public void action() {
        System.out.println("Window is closed.");
        do {
            input = scanner.next();
            if (input.equals("window")) {
                if (!windowOpen) {
                    System.out.println("Window are open");
                    windowOpen = true;
                } else {
                    System.out.println("Window are closed");
                    windowOpen = false;
                }
            } else if (input.equals("key")) {
                if (!keyTaken) {
                    System.out.println("You taken key");
                    keyTaken = true;
                }
            }
            if (keyTaken == true) {
                System.out.println("Escape room: window, door");
            } else {
                System.out.println("Escape room: window, key, door");
            }
        } while (true);
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