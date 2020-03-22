package pages;

import com.codeborne.selenide.WebDriverRunner;
import constants.Routes;
import lombok.Getter;
import org.junit.jupiter.api.Assertions;
import pageElements.Header;
import pageElements.emailPage.LettersTable;

public class InboxPage {

    @Getter
    private LettersTable lettersTable;
    @Getter
    private Header header;

    public InboxPage() {
        this.lettersTable = new LettersTable();
        this.header = new Header();
    }

    public void checkPageIsOpen() {
        lettersTable.isVisible();
        Assertions.assertTrue( WebDriverRunner.url().contains(Routes.INBOX_PAGE));
    }
}
