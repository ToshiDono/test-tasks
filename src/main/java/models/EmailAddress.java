package models;

import lombok.Data;

@Data
public class EmailAddress {
    private String login;
    private String domain;

    public EmailAddress(String login, String domain) {
        this.login = login;
        this.domain = domain;
    }
}
