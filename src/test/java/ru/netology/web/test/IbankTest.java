package ru.netology.web.test;


import org.junit.jupiter.api.Test;
import ru.netology.web.data.DataHelper;
import ru.netology.web.page.LoginPageV1;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class IbankTest {

    @Test
    void loginPage() {
        var loginPage = open("http://localhost:9999", LoginPageV1.class);
        var authInfo = DataHelper.getAuthInfo();
        var verificationPage = loginPage.validLogin(authInfo);
        var verificationCode = DataHelper.getVerificationCode();
        var dashboardPage = verificationPage.validCode(verificationCode);
        var firstCardBalance = DataHelper.getFirstCardBalance();
        var secondCardBalance = DataHelper.getSecondCardBalance();
        var firstCardInfo = dashboardPage.getCardBalance(firstCardBalance);
        var secondCardInfo = dashboardPage.getCardBalance(secondCardBalance);
        var amount = DataHelper.generateValidAmount(firstCardInfo);
        var expectedBalanceOfFirstCard = firstCardInfo - amount;
        var expectedBalanceOfSecondCard = secondCardInfo + amount;
        var transferPage = dashboardPage.selectCardToTransfer(secondCardBalance);
        dashboardPage = transferPage.makeValidTransfer(String.valueOf(amount), firstCardBalance);
        var actualBalanceOfFirstCard = dashboardPage.getCardBalance(firstCardBalance);
        var actualBalanceOfSecondCard = dashboardPage.getCardBalance(secondCardBalance);
        assertEquals(expectedBalanceOfFirstCard, actualBalanceOfFirstCard);
        assertEquals(expectedBalanceOfSecondCard, actualBalanceOfSecondCard);

    }
}