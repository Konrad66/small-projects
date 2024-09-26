package org.example.advanced.contact_list;

public class Controller {

    private Input input = new Input();
    private boolean running = true;
    private Service service = new Service();

    void startProgram(){
        do {
            printOptions();
            int decision = input.readNumber();
            executeOptions(decision);
        } while (running);
    }


    void printOptions(){
        System.out.println("Witaj w swojej liscie kontaktow. Czego potrzebujesz?");
        System.out.println("0. Opusc program.");
        System.out.println("1. Lista kontaktow.");
        System.out.println("2. Stworz nowy kontakt.");
        System.out.println("3. Usun kontakt.");
        System.out.println("4. Edytuj kontakt.");

    }

    void executeOptions(int decision){
        //int decision = input.readNumber();

        switch (decision){
            case 0:
                running = false;
                break;
            case 1:
                service.printContacts();
                break;
            case 2:
                service.createNewContact();
                break;
            case 3:
                service.deleteContact();
                break;
            case 4:
                service.editContact();
                break;
            default:
                System.out.println("Niepoprawny wybor. Sprobuj jeszcze raz.");
        }
    }
}
