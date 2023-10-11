package org.example.advanced.escape_room;

import java.util.Scanner;

public class EscapeRoom {

    private String input;
    private Boolean keyTaken = false;
    private Boolean windowOpen = false;
    private Boolean door;
    private Scanner scanner = new Scanner(System.in);

    private void start() {
        System.out.println("Hello you have to escape room. You have to find key and open the door. ");
        action();
    }

    private void action() {
        System.out.println("Window is closed.");
        do {
            showItems();
            input = scanner.next();
            if (input.equals("window")) {
                windowAction();
            } else if (input.equals("key")) {
                keyAction();
            }
        } while (true);
    }

    private void windowAction() {
        if (!windowOpen) {
            System.out.println("Window are open");
            windowOpen = true;
        } else {
            System.out.println("Window are closed");
            windowOpen = false;
        }
    }

    private void keyAction() {
        if (!keyTaken) {
            System.out.println("You taken key");
            keyTaken = true;
        }
    }

    private void showItems() {
        if (keyTaken) {
            System.out.println("Escape room: window, door");
        } else {
            System.out.println("Escape room: window, key, door");
        }
    }


    public static void main(String[] args) {
        EscapeRoom escapeRoom = new EscapeRoom();
        escapeRoom.start();
    }
}