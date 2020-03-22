package pageElements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Selenide.$x;

public class ShortUserInfoDropdown {
    private static final String ACCOUNT_LINKS = "(//div[@id='PH:authMenu:activeAccountLinks']/a)";

    public SelenideElement city = $x(ACCOUNT_LINKS + "[1]"),
                           personalData = $x(ACCOUNT_LINKS + "[2]"),
                           passwordAndSecurity = $x(ACCOUNT_LINKS + "[3]"),
                           userEmail = $x("//div[@class='x-ph__auth_list__item__info__text']"),
                           userName = $x("//*[@class='x-ph__auth_list__item__info__email__text']"),
                           thisElement = $x("//*[@id='PH:authMenu:dropdown']"),
                           addEmailBtn = $x("//a[@id='PH_loginAnotherLink']"),
                           logoutBtn = $x("//span[contains(@class, 'x-ph__auth_list__item__logout')]");

    public ShortUserInfoDropdown isVisible() {
        thisElement.should(Condition.visible);
        return this;
    }

    public String getUserName() {
        return userName.text();
    }

    public String getEmail() {
        return userEmail.text();
    }

    public ShortUserInfoDropdown checkDisplayedAllElements() {
        Assertions.assertAll("All elements should exist",
                () -> userName.should(Condition.visible),
                () -> userEmail.should(Condition.visible),
                () -> city.should(Condition.visible),
                () -> personalData.should(Condition.visible),
                () -> passwordAndSecurity.should(Condition.visible),
                () -> addEmailBtn.should(Condition.visible),
                () -> logoutBtn.should(Condition.visible));
        return this;
    }
}
