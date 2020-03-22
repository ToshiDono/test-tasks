package pages;

import com.codeborne.selenide.Selenide;
import constants.Routes;
import lombok.Getter;
import pageElements.mainPage.LoginForm;


public class MainPage {
    @Getter
    private LoginForm loginForm;

    public MainPage() {
        loginForm = new LoginForm();
    }

    public static void open() {
        Selenide.open(Routes.MAIN_PAGE);
    }

}
