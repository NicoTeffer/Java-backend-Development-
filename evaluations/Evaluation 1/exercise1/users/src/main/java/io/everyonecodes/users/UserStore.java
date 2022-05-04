package io.everyonecodes.users;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@ConfigurationProperties("userstore")
public class UserStore {
    //TODO:  Has a method that receives a user email and returns a User
    // if found among all the users that have an account.

    private List<User> userList;

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public List<User> getUserList() {
        return userList;
    }

    public User getUser(String email){
        return userList.stream()
                .filter(element -> element.getEmail().equals(email))
                .findFirst().orElse(null);
    }
}
