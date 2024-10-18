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

    void createNewContact(String name, String phoneNumber, String email){
        Contact contact = new Contact(name, phoneNumber, email);
        contactList.add(contact);

    }





}
