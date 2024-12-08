package org.example.kodi.module1.submodule3;

public class App {
    public static void main(String[] args) {
        DeadIslandQuest deadIslandQuest = new DeadIslandQuest();
        EliteKnightQuest eliteKnightQuest = new EliteKnightQuest();
        Knight knight = new Knight(deadIslandQuest);
        knight.recognizeQuest(deadIslandQuest);
        knight.recognizeQuest(eliteKnightQuest);
    }
}