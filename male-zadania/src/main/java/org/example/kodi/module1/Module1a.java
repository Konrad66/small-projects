package org.example.kodi.module1;

public class Module1a {

    public static void main(String[] args) {
        String name = "Adam";
        double age = 40.5;
        double height = 178;
        User user = new User(name, age, height);
        UserValidator userValidator = new UserValidator();

        if (userValidator.isValid(user)) {
            System.out.println("User is older than 30 and higher then 160cm");
        } else {
            System.out.println("User is younger than 30 or lower than 160cm");
        }
    }
}

class UserValidator {

    boolean isValid(User user) {
        return isNameValid(user.getName()) && isAgeValid(user.getAge()) && isHeightValid(user.getHeight());
    }

    boolean isNameValid(String name) {
        return name != null;
    }

    boolean isAgeValid(double age) {
        return age > 30;
    }

    boolean isHeightValid(double height) {
        return height > 160;
    }
}

class User {
    String name;
    double age;
    double height;

    public User(String name, double age, double height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }

    String getName() {
        return name;
    }

    double getAge() {
        return age;
    }

    double getHeight() {
        return height;
    }
}