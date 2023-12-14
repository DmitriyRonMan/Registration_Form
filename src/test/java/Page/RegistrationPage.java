package Page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import data.DataGenerator;

import java.time.Duration;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    private SelenideElement heading = $$("h2").find(Condition.text("Регистрация"));
    private SelenideElement lastNameField = $("[name='name']");
    private SelenideElement buttonCloseLetter = $("[type='button'].css-1ik4h6n");
    private SelenideElement buttonDelivery = $$("p").find(Condition.text("Внутригородская доставка"));
    private SelenideElement buttonMenu = $(".css-1khs3ah");
    private SelenideElement buttonExitAc = $$("p").find(Condition.text("Выйти из аккаунта"));
    private SelenideElement nameField = $("[name='surname']");
    private SelenideElement emailField = $("[name='email']");
    private SelenideElement passwordField = $("[name='password']");
    private SelenideElement buttonContinue = $("[type='submit'].css-yhxv9x");
    private SelenideElement buttonEntrance = $("[type='button'].css-jq7zez");
    private SelenideElement chooseRole = $(withText("Выберите вашу роль"));
    private SelenideElement letterSent = $(withText("Письмо отправлено!"));
    private SelenideElement errorMessageForTheLastNameFieldWithRuLetters = $(byText("Значение поля фамилия, может содержать только русские буквы и дефис"));
    private SelenideElement errorMessageForTheLastNameFieldFromIntervalFrom1To64 = $(byText("Значение поля фамилия, должно содержать не меньше 1 буквы и не больше 64 букв"));
    private SelenideElement errorMessageForTheNameFieldWithRuLetters = $(byText("Значение поля имя, может содержать только русские буквы и дефис"));
    private SelenideElement errorMessageForTheNameFieldFromIntervalFrom1To64 = $(byText("Значение поля имя, должно содержать не меньше 1 буквы и не больше 64 букв"));
    private SelenideElement errorMessageFormatEmail = $(byText("Значение поля email, не соответствует формату почты"));
    private SelenideElement errorMessagePasswordLight = $(byText("Недопустимый пароль. Пароль слишком простой."));
    /*
        private SelenideElement errorMessagePasswordRepChar = $(byText("Пароль указан неверно. Имеются повторяющиеся символы"));
    */
    private SelenideElement errorMessagePasswordSpecChar = $(byText("Пароль не должен содержать символы «?», «#», «<», «>», «%», «/»"));
    private SelenideElement errorMessagePasswordFrom7To64 = $(byText("Значение поля пароль, должно содержать не меньше 7 буквы и не больше 25 букв"));

    public RegistrationPage() {

        heading.shouldBe(Condition.visible);
    }

    public AuthorizationPage goToAuthPage() {

        return new AuthorizationPage();
    }

    // методы для вывода рандомных данных

    public void getARandomLastName() {

        lastNameField.sendKeys(DataGenerator.getLastName());
    }

    public void getARandomName() {

        nameField.sendKeys(DataGenerator.getName());
    }

    // методы для работы со строкой

    public void getLastNameFromString(String s) {

        lastNameField.setValue(s);
    }

    public void getNameFromString(String s) {

        nameField.setValue(s);
    }

    public void getEmailFromString(String s) {

        emailField.setValue(s);
    }

    public void getPasswordFromString(String s) {

        passwordField.sendKeys(s);
    }

    // методы для вывода сообщений (с приставкой NOT)

    public void setNotErrorMessageForTheLastNameFieldWithRuLetters() {
        errorMessageForTheLastNameFieldWithRuLetters.shouldHave(Condition.not(Condition.visible));
    }

    public void setNotErrorMessageForTheNameFieldWithRuLetters() {
        errorMessageForTheNameFieldWithRuLetters.shouldHave(Condition.not(Condition.visible));
    }

    public void setNotErrorMessageForTheLastNameFieldFromIntervalFrom1To64() {
        errorMessageForTheLastNameFieldFromIntervalFrom1To64.shouldHave(Condition.not(Condition.visible));
    }

    public void setNotErrorMessageForTheNameFieldFromIntervalFrom1To64() {
        errorMessageForTheNameFieldFromIntervalFrom1To64.shouldHave(Condition.not(Condition.visible));
    }

    public void setNotErrorMessageFormatEmail() {
        errorMessageFormatEmail.shouldHave(Condition.not(Condition.visible));
    }

    public void setNotErrorMessagePasswordLight() {
        errorMessagePasswordLight.shouldHave(Condition.not(Condition.visible));
    }

    // методы для вывода сообщений

    public void setErrorMessageForTheLastNameFieldWithRuLetters() {
        errorMessageForTheLastNameFieldWithRuLetters.shouldHave(Condition.visible);
    }

    public void setErrorMessageForTheNameFieldWithRuLetters() {
        errorMessageForTheNameFieldWithRuLetters.shouldHave(Condition.visible);
    }

    public void setErrorMessageForTheLastNameFieldFromIntervalFrom1To64() {
        errorMessageForTheLastNameFieldFromIntervalFrom1To64.shouldHave(Condition.visible);
    }

    public void setErrorMessageForTheNameFieldFromIntervalFrom1To64() {
        errorMessageForTheNameFieldFromIntervalFrom1To64.shouldHave(Condition.visible);
    }

    public void setErrorMessageFormatEmail() {
        errorMessageFormatEmail.shouldHave(Condition.visible);
    }

   /* public void setErrorMessagePasswordLight() {
        errorMessagePasswordLight.shouldHave(Condition.visible);
    }

    public void setErrorMessagePasswordRepChar() {
        errorMessagePasswordRepChar.shouldHave(Condition.visible);
    }*/

    public void setErrorMessagePasswordSpecChar() {
        errorMessagePasswordSpecChar.shouldHave(Condition.visible);
    }

    public void setErrorMessagePasswordFrom7To64() {
        errorMessagePasswordFrom7To64.shouldHave(Condition.visible);
    }


    public void setChooseRole() {

        refresh();
        chooseRole.shouldHave(Condition.visible, Duration.ofSeconds(10));
    }

    public void setLetterSent() {

        letterSent.shouldHave(Condition.visible);
        buttonCloseLetter.click();
    }

    public void exitAccountAfterReg() {

        buttonDelivery.click();
        buttonMenu.click();
        buttonExitAc.click();
    }

    public void enterButtonAuth() {
        buttonEntrance.click();
    }

    public void enterButtonContinue() {
        buttonContinue.click();
    }

    public void notVisibleButtonContinue() {
        buttonContinue.shouldHave(Condition.not(Condition.visible));
    }

    public void fillRegIngo(DataGenerator.RegInfo regInfo) {
        lastNameField.sendKeys(regInfo.getLastName());
        nameField.sendKeys(regInfo.getName());
        emailField.sendKeys(regInfo.getEmail());
        passwordField.sendKeys(regInfo.getPassword());
    }


}
