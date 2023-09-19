package org.example.advanced.escape_room;

import java.util.Scanner;

public class EscapeRoom {


    public void room() {
        System.out.println("Hello you have to escape room. You have to find key and open the door.");
        System.out.println("You have 3 items: window, key and door");
        String key = "Key";
        String window = "Window";
        String door = "Door";
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Choose item");
            scanner.next();


        } while (true);

    }


    public static void main(String[] args) {
        EscapeRoom escapeRoom = new EscapeRoom();
        escapeRoom.room();


    }

}
