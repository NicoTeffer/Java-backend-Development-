package io.everyonecodes.basket;

import java.util.Objects;

public class User {

    // TODO:  Has email and accountType as String properties.

    private String email;
    private String accountType;

    public User() {
    }

    public User(String email, String accountType) {
        this.email = email;
        this.accountType = accountType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(email, user.email) && Objects.equals(accountType, user.accountType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, accountType);
    }
}
