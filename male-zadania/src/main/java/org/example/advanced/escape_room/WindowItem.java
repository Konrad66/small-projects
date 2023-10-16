package org.example.advanced.escape_room;

public class WindowItem extends Item {

    private boolean open;

    public WindowItem() {
        super("window");
    }

    @Override
    public void use() {
        if (!open) {
            System.out.println("Window are open");
            open = true;
        } else {
            System.out.println("Window are closed");
            open = false;
        }
    }
}