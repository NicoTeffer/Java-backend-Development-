package io.everyonecodes.small_business;

public class ShopService {

    private boolean open;

    public ShopService(boolean open) {
        this.open = open;
    }

    public void open(){
        open = true;
    }

    public void close(){
        open = false;
    }

    public boolean isOpen(){
        return open;
    }

}
