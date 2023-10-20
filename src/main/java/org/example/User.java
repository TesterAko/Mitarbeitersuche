package org.example;

public class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void getUserData() {
        System.out.println("Username: " + username + " Password: " + password);
    }
    public void createUserData(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public void saveUserData() {
        System.out.println("User saved");
    }
    public void deleteUserData() {
        System.out.println("User deleted");
        this.username = null;
        this.password = null;
    }
    public void updateUserData(String username, String password) {
        this.username = username;
        this.password = password;
        System.out.println("User updated");
    }
}
