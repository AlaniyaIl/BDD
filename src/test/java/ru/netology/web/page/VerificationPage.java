package ru.netology.web.page;

import com.codeborne.selenide.SelenideElement;
import ru.netology.web.data.DataHelper;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class VerificationPage {
    private SelenideElement codeFiled = $("[data-test-id=code] input");
    private SelenideElement acceptFiled = $("[data-test-id=action-verify]");

    public DashboardPage validCode (DataHelper.VerificationCode info){
        codeFiled.setValue(info.getCode());
        acceptFiled.click();
        return new DashboardPage();
    }
}