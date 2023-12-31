package Page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import data.DataGenerator;

import java.time.Duration;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class AuthorizationPage {

    private SelenideElement heading = $$("h2").find(Condition.text("Вход"));
    private SelenideElement emailField = $("[name='email']");
    private SelenideElement emailFieldPassword = $("[name='email'].css-zwe2ij");
    private SelenideElement passwordField = $("[name='password']");
    private SelenideElement buttonEntrance = $("[type='submit'].css-yhxv9x");
    private SelenideElement buttonReg = $("[type='button'].css-jq7zez");
    private SelenideElement buttonPassword = $("[type='button'].css-14kqsx4");
    private SelenideElement buttonDelivery = $$("p").find(Condition.text("Внутригородская доставка"));
    private SelenideElement buttonMenu = $(".css-1khs3ah");
    private SelenideElement buttonExitAc = $$("p").find(Condition.text("Выйти из аккаунта"));
    private SelenideElement chooseRole = $(withText("Выберите вашу роль"));
    private SelenideElement letterSent = $(withText("Письмо отправлено!"));

    private SelenideElement errorMessagePasswordAndName = $(byText("Неправильное имя пользователя или пароль."));
    private SelenideElement errorMessageNotEmailAuth = $(byText("Такого email не существует"));

    public AuthorizationPage() {

        heading.shouldBe(Condition.visible, Duration.ofSeconds(10));
    }

    public RegistrationPage goToRegPage() {
        return new RegistrationPage();
    }

    public MainPage goToMainPage() {
        return new MainPage();
    }

    public void enterButtonEntrance() {

        buttonEntrance.click();
    }

    public void enterButtonPassword() {

        buttonPassword.click();
    }

    public void enterButtonReg() {
        buttonReg.click();
    }

    public void setChooseRole() {

        chooseRole.shouldHave(Condition.visible, Duration.ofSeconds(10));
        buttonDelivery.click();
    }

    public void exitAccount() {
        buttonMenu.click();
        buttonExitAc.click();
    }

    public void setLetterSent() {

        letterSent.shouldHave(Condition.visible);
    }

    public void setErrorMessagePasswordAndName() {
        errorMessagePasswordAndName.shouldHave(Condition.visible);
    }

    public void setErrorMessageNotEmailAuth() {
        errorMessageNotEmailAuth.shouldHave(Condition.visible);
    }

    public void fillAuthIngo(DataGenerator.AuthInfo authInfo) {
        emailField.sendKeys(authInfo.getEmailAuth());
        passwordField.sendKeys(authInfo.getPasswordAuth());
    }

    public void fillAuthInfoPassword(DataGenerator.AuthInfoPassword authInfoPassword) {
        emailFieldPassword.sendKeys(authInfoPassword.getEmailAuthPassword());

    }
}
