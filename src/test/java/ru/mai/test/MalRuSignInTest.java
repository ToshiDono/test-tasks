package ru.mai.test;

import com.codeborne.selenide.Selenide;
import helpers.EmailHelper;
import models.User;
import models.builders.UserBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pageElements.ShortUserInfoDropdown;
import pages.InboxPage;
import pages.MainPage;

public class MalRuSignInTest {
    private static final User user = UserBuilder.buildDefaultUser();

    @BeforeEach
    private void openMainPageAndLogin() {
        MainPage.open();
        new MainPage().getLoginForm().login(user);
    }

    @AfterEach
    private void closeBrowser() {
        Selenide.closeWebDriver();
    }

    @Test
    public void mailRuLoginTest() {
        InboxPage inboxPage = new InboxPage();
        inboxPage.checkPageIsOpen();
        inboxPage.getHeader().userIsLogined(user);
    }

    @Test
    public void checkShortUserInfoDropdownTest() {
        InboxPage inboxPage = new InboxPage();
        inboxPage.getHeader().openShortUserInfoDropdown();

        ShortUserInfoDropdown shortUserInfoDropdown = inboxPage.getHeader().getShortUserInfoDropdown();
        shortUserInfoDropdown
                .isVisible()
                .checkDisplayedAllElements();
        String visibleUserName = shortUserInfoDropdown.getUserName();
        String visibleEmail = shortUserInfoDropdown.getEmail();
        Assertions.assertAll("Users data",
                () -> visibleUserName.contains(user.getName()),
                () -> visibleUserName.contains(user.getLastName()),
                () -> visibleEmail.equals(EmailHelper.getFullEmailAddress(user.getEmail())));
    }



}
