package pageElements.mainPage;

import com.codeborne.selenide.SelenideElement;
import models.User;
import pages.InboxPage;

import static com.codeborne.selenide.Selenide.$x;

public class LoginForm {
    public final SelenideElement mailInput = $x("//input[@id='mailbox:login']"),
                                 eMailDomainSelect = $x("//select[@id='mailbox:domain']"),
                                 passwordBtn = $x("//div/label[@id='mailbox:submit']"),
                                 passwordInput = $x("//input[@id='mailbox:password']");

    public void fillEmailInput(String login) {
        mailInput.setValue(login);
    }

    public void selectEmailDomain(String suffix) {
        eMailDomainSelect.selectOptionContainingText(suffix);
    }

    public void clickPasswordBtn() {
        passwordBtn.click();
    }

    public void fillPasswordInput(String password) {
        passwordInput.setValue(password);
    }

    public InboxPage login(User user) {
        fillEmailInput(user.getEmail().getLogin());
        selectEmailDomain(user.getEmail().getDomain());
        clickPasswordBtn();
        fillPasswordInput(user.getPassword());
        clickPasswordBtn();
        return new InboxPage();
    }
}
