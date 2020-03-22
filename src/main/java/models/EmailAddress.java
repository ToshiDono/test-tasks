package models;

import lombok.Data;

@Data
public class EmailAddress {
    private String login;
    private String suffix;

    public EmailAddress(String login, String suffix) {
        this.login = login;
        this.suffix = suffix;
    }
}
