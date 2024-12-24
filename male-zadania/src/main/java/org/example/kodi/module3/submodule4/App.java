package org.example.kodi.module3.submodule4;

import java.util.*;

public class App {
    public static void main(String[] args) {
        List<String> even = new ArrayList<>();
        List<String> odd = new ArrayList<>();
        Deque<String> stringDeque = new ArrayDeque<>();
        AppendString appendString = new AppendString();
        appendString.appendString(stringDeque);
        appendString.printQue(stringDeque);

        Iterator<String> iterator = stringDeque.iterator();
        while (iterator.hasNext()) {
            for (int i = 0; i < stringDeque.size(); i++) {
                String next = iterator.next();
                if (next.length() % 2 == 0) {
                    even.add(next);
                } else {
                    odd.add(next);
                }
            }
        }

        for (String s : odd) {
            System.out.println("Odd: " + s);
        }

        System.out.println("-------------");
        for (String s : even) {
            System.out.println("Even: " + s);
        }
    }
}


class AppendString {
    private Random random = new Random();

    void appendString(Deque<String> stringDeque) {
        for (int i = 0; i < 50; i++) {
            int randomCount = random.nextInt(50) + 1;
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < randomCount; j++) {
                stringBuilder.append('a');
            }
            stringDeque.add(stringBuilder.toString());
        }
    }

    void printQue(Deque<String> stringDeque) {
        int index = 1;
        for (String s : stringDeque) {
            System.out.println("Index " + index + ": " + s);
            index++;
        }
    }
}