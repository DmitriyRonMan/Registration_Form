package Page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import data.DataGenerator;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class RegistrationPage {

    private SelenideElement heading = $$("h2").find(Condition.text("Регистрация"));
    private SelenideElement lastNameField = $("[name='name']");
    private SelenideElement nameField = $("[name='surname']");
    private SelenideElement emailField = $("[name='email']");
    private SelenideElement passwordField = $("[name='password']");
    private SelenideElement buttonContinue = $("[type='submit'].css-yhxv9x");

    public RegistrationPage() {
        heading.shouldBe(Condition.visible);
    }

    public void getLastNameFrom3To60() {
        lastNameField.sendKeys(DataGenerator.getLastName());
        $(byText("Значение поля фамилия, может содержать только русские буквы")).shouldHave(Condition.not(Condition.visible));

    }
}
