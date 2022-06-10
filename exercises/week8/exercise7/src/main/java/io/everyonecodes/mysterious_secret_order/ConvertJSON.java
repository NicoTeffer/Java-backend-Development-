package io.everyonecodes.mysterious_secret_order;

import com.google.gson.Gson;

import java.util.Set;

public class ConvertJSON {
    public static User getUser(User user) {
        user.setUsername("lucas");
        user.setPassword("lucas");
        user.setAuthorities(Set.of("ROLE_APPRENTICE"));
        return user;
    }
    public static void main(String[] args) {
        User user = new User();
        getUser(user);
        System.out.println("The JSON representation of Object user is: ");
        System.out.println(new Gson().toJson(user));
    }
}
