package models.builders;

import constants.Data;
import models.EmailAddress;
import models.User;

public final class UserBuilder {
    private EmailAddress email;
    private String password;
    private String name;
    private String lastName;

    private UserBuilder() {
    }

    public static UserBuilder anUser() {
        return new UserBuilder();
    }

    public UserBuilder withEmail(EmailAddress email) {
        this.email = email;
        return this;
    }

    public UserBuilder withPassword(String password) {
        this.password = password;
        return this;
    }

    public UserBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public UserBuilder withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public User build() {
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setName(name);
        user.setLastName(lastName);
        return user;
    }

    public static User buildDefaultUser() {
        return   UserBuilder.anUser()
                .withEmail(new EmailAddress(Data.DEFAULT_EMAIL, Data.DEFAULT_EMAIL_SUFFIX))
                .withPassword(Data.DEFAULT_PASSWORD)
                .withName(Data.DEFAULT_USER_NAME)
                .withLastName(Data.DEFAULT_USER_LAST_NAME)
                .build();
    }
}
