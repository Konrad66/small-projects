package org.example.advanced.contact_list;

import java.util.ArrayList;
import java.util.List;

public class Service {

    List<Contact> contactList = new ArrayList<>();




    void printContacts(){
        for (Contact contact : contactList) {
            System.out.println(contact);
        }
    }

    void createNewContact(){


        //Contact contact = new Contact();
    }





}
