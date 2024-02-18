package page;

import com.codeborne.selenide.SelenideElement;
import data.DataHelper;


import java.time.Duration;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class TransferMoney {

    SelenideElement popUpString = $("[data-test-id=amount] input");
    SelenideElement from = $("[data-test-id=from] [type=tel]");
    SelenideElement transferTo = $("[data-test-id=to]");
    SelenideElement popUpButton = $("[data-test-id=action-transfer]");
    SelenideElement cancelButton = $("[data-test-id=action-cancel]");
   // SelenideElement errorMessage = $("[data-test-id=error-message]");

    SelenideElement errorMessage = $("[data-test-id=error-notification]");

    public void transferMoney(DataHelper.CardInfo cardNumber, String amount) {
        popUpString.val(amount);
        from.val(cardNumber.getCardNumber());
        popUpButton.click();
    }

    public void makeValidTransfer(DataHelper.CardInfo cardNumber, String amount) {
        transferMoney(cardNumber, amount);
        new DashboardPage();
    }

    public void depositError(String expectedText) {
        errorMessage.shouldHave(exactText(expectedText)).shouldBe(visible, Duration.ofMillis(15));
    }
}
