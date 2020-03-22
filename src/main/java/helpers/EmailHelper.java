package helpers;

import models.EmailAddress;

public class EmailHelper {

    public static String getFullEmailAddress(final EmailAddress emailAddress) {
        if (!emailAddress.getDomain().contains("@")) {
            emailAddress.setDomain("@" + emailAddress.getDomain());
        }
        return emailAddress.getLogin() + emailAddress.getDomain();
    }
}
