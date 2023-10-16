package org.example.advanced.escape_room;

public class WindowAction extends Action{

    private Boolean open;

    @Override
    public void action() {
        if (!open) {
            System.out.println("Window are open");
            open = true;
        } else {
            System.out.println("Window are closed");
            open = false;
        }
    }
}