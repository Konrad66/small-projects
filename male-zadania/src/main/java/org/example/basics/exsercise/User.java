package org.example.basics.exsercise;

public class User {

    private String name;
    private String surname;
    private String sex;
    private int age;
    private String email;

    public User(String name, String surname, String sex, int age, String email) {
        this.name = name;
        this.surname = surname;
        this.sex = sex;
        this.age = age;
        this.email = email;
    }

    public String login(){
        return "Zalogowano pomyślnie";
    }

    public String deleteAccount(){
        return "Usunięto konto";
    }
}

