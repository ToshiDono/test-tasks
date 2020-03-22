package pageElements.emailPage;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class LettersTable {
    public final SelenideElement thisElement = $x("//*[@class='dataset-letters']");

    public void isVisible() {
        thisElement.should(Condition.visible);
    }
}
