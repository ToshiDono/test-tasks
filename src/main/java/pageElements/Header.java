package pageElements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import helpers.EmailHelper;
import lombok.Getter;
import models.User;

import static com.codeborne.selenide.Selenide.$x;

public class Header {
    public final SelenideElement shortUserInfoDropdownEl = $x("//*[@id='PH_authMenu']");

    @Getter
    private ShortUserInfoDropdown shortUserInfoDropdown;

    public Header() {
        this.shortUserInfoDropdown = new ShortUserInfoDropdown();
    }

    public void userIsLogined(User user) {
        shortUserInfoDropdownEl
                .should(Condition.visible)
                .should(Condition.text(EmailHelper.getFullEmailAddress(user.getEmail())));
    }

    public void openShortUserInfoDropdown() {
        shortUserInfoDropdownEl.click();
    }
}
