package org.example.advanced.escape_room;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EscapeRoom {

    private String input;
    private Boolean doorOpen = false;
    private Scanner scanner = new Scanner(System.in);


    private List<Item> items;

    private void start() {
        System.out.println("Hello you have to escape room. You have to find key and open the door. ");
        List<String> items = readCSV();
        //System.out.println(items);
        this.items = createActions(items);
        action();
    }

    private void action() {
        System.out.println("Window is closed.");
        do {
            showItems();
            input = scanner.next();
            for (Item item : items) {
                if (item.getName().equals(input)) {
                    item.use();
                }
            }
        } while (!doorOpen);
    }


    private void showItems() {
        for (Item item : items){
            //TODO
            item.visible();
            System.out.println(item);
        }
    }
/*
    private void doorAction() {
        if (keyTaken) {
            System.out.println("Door are open. You won!");
            doorOpen = true;
        } else {
            System.out.println("You can't open the door");
        }
    }

 */

    private List<String> readCSV() {
        List<String> itemNames = new ArrayList<>();
        try {
            Scanner reader = new Scanner(new File("items.csv"));
            String text = reader.next();
            String[] texts = text.split(";");
            for (String name : texts) {
                itemNames.add(name);
            }
        } catch (FileNotFoundException exception) {
            System.out.println("File doesn't exist");
            exception.printStackTrace();
        }

        return itemNames;
    }

    private List<Item> createActions(List<String> items) {
        List<Item> itemList = new ArrayList<>();
        for (String item : items) {
            ActionFactory factory = new ActionFactory();
            itemList.add(factory.createAction(item));
        }
        //TODO różnica między metodą equals a 2 x ==
        return itemList;
    }

    public static void main(String[] args) {
        EscapeRoom escapeRoom = new EscapeRoom();
        escapeRoom.start();

    }
}


// 5 pomysłów na różne aplikacje i zacząć tworzyć