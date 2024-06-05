package com.s201_chess;

import java.io.Serializable;
import java.util.Objects;

class User implements Serializable {
    private String username;
    private String firstName;
    private String lastName;

    public User(String username, String firstNamem, String lastName) {
        this.username = username;
        this.firstName = firstNamem;
        this.lastName = lastName;
    }

    // Redéfinition de equals et hashCode pour comparer les utilisateurs
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User that = (User) o;
        return Objects.equals(username, that.username) &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, firstName, lastName);
    }
}
