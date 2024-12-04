package org.example.basics.exsercise;

public class ForumUser extends User {

    private String userName;
    private int numberOfPosts;
    private boolean isUserLogged;

    public ForumUser(String name, String surname, String sex, int age, String email, String userName, int numberOfPosts, boolean isUserLogged) {
        super(name, surname, sex, age, email);
        this.userName = userName;
        this.numberOfPosts = numberOfPosts;
        this.isUserLogged = isUserLogged;
    }

    public void userLogin(){
        isUserLogged = true;
    }

    public void userLogout(){
        isUserLogged = false;
    }



}
