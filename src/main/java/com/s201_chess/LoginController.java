package com.s201_chess;

import javafx.beans.InvalidationListener;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class LoginController extends GridPane {
    @FXML
    VBox vb;
    @FXML
    TextField usernameField;
    @FXML
    TextField firstNameField;
    @FXML
    TextField lastNameField;
    @FXML
    Button loginButton;

    // pour passer de Hello à Login UNIQUEMENT quand on appuie sur le loginButton
    public void changeScene(Button button) {
        try {
            File file = new File("users.txt");
            ObservableList<User> users = new ObservableList<User>() {
                @Override
                public void addListener(InvalidationListener invalidationListener) {

                }

                @Override
                public void removeListener(InvalidationListener invalidationListener) {

                }

                @Override
                public int size() {
                    return 0;
                }

                @Override
                public boolean isEmpty() {
                    return false;
                }

                @Override
                public boolean contains(Object o) {
                    return false;
                }

                @Override
                public Iterator<User> iterator() {
                    return null;
                }

                @Override
                public Object[] toArray() {
                    return new Object[0];
                }

                @Override
                public <T> T[] toArray(T[] a) {
                    return null;
                }

                @Override
                public boolean add(User user) {
                    return false;
                }

                @Override
                public boolean remove(Object o) {
                    return false;
                }

                @Override
                public boolean containsAll(Collection<?> c) {
                    return false;
                }

                @Override
                public boolean addAll(Collection<? extends User> c) {
                    return false;
                }

                @Override
                public boolean addAll(int index, Collection<? extends User> c) {
                    return false;
                }

                @Override
                public boolean removeAll(Collection<?> c) {
                    return false;
                }

                @Override
                public boolean retainAll(Collection<?> c) {
                    return false;
                }

                @Override
                public void clear() {

                }

                @Override
                public User get(int index) {
                    return null;
                }

                @Override
                public User set(int index, User element) {
                    return null;
                }

                @Override
                public void add(int index, User element) {

                }

                @Override
                public User remove(int index) {
                    return null;
                }

                @Override
                public int indexOf(Object o) {
                    return 0;
                }

                @Override
                public int lastIndexOf(Object o) {
                    return 0;
                }

                @Override
                public ListIterator<User> listIterator() {
                    return null;
                }

                @Override
                public ListIterator<User> listIterator(int index) {
                    return null;
                }

                @Override
                public List<User> subList(int fromIndex, int toIndex) {
                    return List.of();
                }

                @Override
                public void addListener(ListChangeListener<? super User> listChangeListener) {

                }

                @Override
                public void removeListener(ListChangeListener<? super User> listChangeListener) {

                }

                @Override
                public boolean addAll(User... users) {
                    return false;
                }

                @Override
                public boolean setAll(User... users) {
                    return false;
                }

                @Override
                public boolean setAll(Collection<? extends User> collection) {
                    return false;
                }

                @Override
                public boolean removeAll(User... users) {
                    return false;
                }

                @Override
                public boolean retainAll(User... users) {
                    return false;
                }

                @Override
                public void remove(int i, int i1) {

                }
            };
            User user = new User(usernameField.getText(), firstNameField.getText(), lastNameField.getText());
            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
            FileManager.loadFile(file);
            FileManager.addUser(users, user);
            FileManager.saveUser(users);
            Stage stage = (Stage) button.getScene().getWindow();
            stage.setScene(new Scene(loader.load(), 777, 659));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void loginClicked() {
        // TODO : permettre l'enregistrement des utilisateurs dans la liste ET le fichier quand on appuie sur le bouton
        loginButton.setOnMouseClicked(actionEvent -> {
            changeScene(loginButton);
        });
    }
}