package models;

import lombok.Data;

@Data
public class User {
    private EmailAddress email;
    private String password;
    private String name;
    private String lastName;

    public User() {
    }

    public User(EmailAddress email, String password) {
        this.email = email;
        this.password = password;
    }
}
