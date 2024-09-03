package org.example.advanced.lambda;

import java.util.List;

public class LambdaDemo {


    public static void main(String[] args) {
        Button exit = new Button(100, 50, "Red", "Exit");
        Button start = new Button(80, 80, "Green", "Start");

        start.setAction(new StartAction());
        start.setAction(new InnerClass());

        class LocalClassStartAction implements ButtonAction {

            @Override
            public void onClickAction() {
                System.out.println("Startujemy");
            }
        }
        LocalClassStartAction buttonAction = new LocalClassStartAction();
        ButtonAction buttonActionStartInner = new ButtonAction() {
            @Override
            public void onClickAction() {
                System.out.println("Startujemy z abstr. klasy");
            }
        };


        //todo klasy anonimowe poczytac
        //w klasie anonimowje nie mozemy zrobic Construktora


        start.setAction(buttonAction);
        start.setAction(() -> System.out.println("Startujemy z abstr. klasy"));
        start.setAction(() -> System.out.println("Startujemy z lambdy. klasy"));

        List<String> names = List.of("Kamil", "Maria", "Marta");
        for (String name : names) {
            System.out.println(name);
        }

        names.forEach(name -> System.out.println(name));


        System.out.println(buttonAction.getClass());
        System.out.println(buttonActionStartInner.getClass());

        start.onClick();


//        exit.onClick();


//        button.setAction(exitButtonAction);
//        button.setAction(System.out.println("Zaczyanamy grę"));


    }

    static void exitButtonAction() {
        System.out.println("Kończymy program");
    }

    static class InnerClass implements ButtonAction {

        @Override
        public void onClickAction() {
            System.out.println("Start");
        }
    }


}

class Button {
    private int width;
    private int height;
    private String color;
    private String label;
    private ButtonAction buttonAction;

    public Button(int width, int height, String color, String label) {
        this.width = width;
        this.height = height;
        this.color = color;
        this.label = label;
    }

    public void setAction(ButtonAction buttonAction) {
        this.buttonAction = buttonAction;
    }

    public void onClick() {
        buttonAction.onClickAction();
    }
}

//interface funkcyjny
@FunctionalInterface
interface ButtonAction {

    void onClickAction();

}


class StartAction implements ButtonAction {

    @Override
    public void onClickAction() {
        System.out.println("start");
    }
}


class ButtonExit extends Button {

    public ButtonExit(int width, int height, String color, String label) {
        super(width, height, color, label);
    }

    @Override
    public void onClick() {
        System.out.println("Kończymy program");
    }
}

class ButtonStart extends Button {
    public ButtonStart(int width, int height, String color, String label) {
        super(width, height, color, label);
    }

    @Override
    public void onClick() {
        System.out.println("Zaczyanamy grę");
    }
}
