package io.everyonecodes.amazing_goodbye_world;

public class AmazingGoodbyeWorld {

    private final Goodbye goodbye;
    private final World world;

    public AmazingGoodbyeWorld(Goodbye goodbye, World world) {
        this.goodbye = goodbye;
        this.world = world;
    }

    public String get() {
        String goodbyeString = goodbye.get();
        String worldString = world.get();
        return goodbyeString + " " + worldString;
    }
}
