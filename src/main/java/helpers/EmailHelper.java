package helpers;

import models.EmailAddress;

public class EmailHelper {

    public static String getFullEmailAddress(final EmailAddress emailAddress) {
        if (!emailAddress.getSuffix().contains("@")) {
            emailAddress.setSuffix("@" + emailAddress.getSuffix());
        }
        return emailAddress.getLogin() + emailAddress.getSuffix();
    }
}
