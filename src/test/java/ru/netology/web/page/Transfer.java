package ru.netology.web.page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.conditions.Text;
import ru.netology.web.data.DataHelper;

import java.time.Duration;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class Transfer {
    private SelenideElement summFiled = $("[data-test-id= amount] input");
    private SelenideElement numCardFiled = $("[data-test-id= from] input");
    private SelenideElement transFiled = $("[data-test-id=action-transfer]");
    private SelenideElement transCancel = $("[data-test-id=action-cancel]");
    private SelenideElement errorMessage = $("[data-test-id='error-message']");


    public void makeTransfer (String amountToTransfer, DataHelper.CardInfo cardInfo){
        summFiled.setValue(amountToTransfer);
        numCardFiled.setValue(cardInfo.getCardNumber());
        transFiled.click();
    }
    public void dontMakeTransfer (String amountToTransfer, DataHelper.CardInfo cardInfo){
        summFiled.setValue(amountToTransfer);
        numCardFiled.setValue(cardInfo.getCardNumber());
        transCancel.click();
    }
    public DashboardPage makeValidTransfer(String amountToTransfer, DataHelper.CardInfo cardInfo) {
        makeTransfer(amountToTransfer, cardInfo);
        return new DashboardPage();
    }

    public void findErrorMassage(String expectedText){
        errorMessage.shouldHave(exactText(expectedText), Duration.ofSeconds(15)).shouldBe(visible);
    }
}
