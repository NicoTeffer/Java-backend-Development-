package io.everyonecodes.qpl_profiler;

import com.google.gson.Gson;

public class ConvertJSON {
    public static Player getPlayer(Player player) {
        player.setName("Shane Hendrixson");
        player.setAge(33);
        player.setStatus("Active");
        player.setTeam("Team Liquid");
        player.setTotalEarnings(433079);
        player.setCountry("United States");
        player.setId("id");
        return player;
    }
    public static void main(String[] args) {
        Player player = new Player();
        getPlayer(player);
        System.out.println("The JSON representation of Object player is: ");
        System.out.println(new Gson().toJson(player));
    }
}
