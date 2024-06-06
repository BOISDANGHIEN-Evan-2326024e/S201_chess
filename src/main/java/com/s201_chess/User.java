package com.s201_chess;

import java.io.Serializable;
import java.util.Objects;

// classe spécifique aux utilisateurs
public class User implements Serializable {
    private String username;
    private String firstName;
    private String lastName;

    //un constructeur
    public User(String username, String firstNamem, String lastName) {
        this.username = username;
        this.firstName = firstNamem;
        this.lastName = lastName;
    }

    // Redéfinition de equals et hashCode pour comparer les utilisateurs // d'accord Chat
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    // redéfinition du toString pour User
    @Override
    public String toString() {
        return "User: username=" + username + ", firstName=" + firstName + ", lastName=" + lastName;
    }
}
