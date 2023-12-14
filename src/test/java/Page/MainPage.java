package Page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import data.DataGenerator;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MainPage {

    private SelenideElement heading = $$("[class='chakra-text css-3myuqt']").find(Condition.text("БИА. Помощник логиста"));
    private SelenideElement buttonReg = $$("button").find(Condition.text("Зарегистрироваться"));
    private SelenideElement buttonReg2 = $$("button").find(Condition.text("Регистрация"));
    private SelenideElement buttonReg3 = $$("button").find(Condition.text("Начать"));
    private SelenideElement buttonAuth = $$("button").find(Condition.text("Войти"));
    private SelenideElement buttonApplication = $$("button").find(Condition.text("Оставить заявку"));
    private SelenideElement buttonInfoProduct = $$("a").find(Condition.text("О продукте"));
    private SelenideElement buttonSolutions = $$("a").find(Condition.text("Решения"));
    private SelenideElement buttonRates = $$("a").find(Condition.text("Тарифы"));
    private SelenideElement buttonSupport = $$("a").find(Condition.text("Поддержка"));
    private SelenideElement buttonContacts = $$("a").find(Condition.text("Контакты"));
    private SelenideElement linkPrivacyPolicy = $$("a").find(Condition.text("Политикой конфиденциальности"));
    private SelenideElement nameField = $("[id='name_user']");
    private SelenideElement phoneField = $("[id='telephone']");
    private SelenideElement emailField = $("[id='email_user']");
    private SelenideElement commentField = $("[id='description']");

    public MainPage() {
        heading.shouldBe(visible, Duration.ofSeconds(10));
    }

    public RegistrationPage goToRegPage() {
        buttonReg.click();
        return new RegistrationPage();
    }

    public RegistrationPage goToRegPageViaTheSecondButton() {
        buttonReg2.click();
        return new RegistrationPage();
    }

    public RegistrationPage goToRegPageViaTheStartButton() {
        buttonReg3.click();
        return new RegistrationPage();
    }

    public AuthorizationPage goToAuthPage() {
        buttonAuth.click();
        return new AuthorizationPage();
    }

    public void enterButtonInfoProduct() {
        buttonInfoProduct.click();
        $$("p").find(Condition.text("О продукте")).shouldHave(visible);
    }

    public void enterButtonSolutions() {
        buttonSolutions.click();
        $$("p").find(Condition.text("Кому подходит")).shouldHave(visible);
    }

    public void enterButtonRates() {
        buttonRates.click();
        $$("[style='display: flex;']").find(Condition.text("Свяжитесь с нами для объяснения тарифов")).shouldHave(visible);
    }

    public void enterButtonSupport() {
        buttonSupport.click();
        $$("p").find(Condition.text("Свяжитесь с нами!")).shouldHave(visible);
    }

    public void enterButtonContacts() {
        buttonContacts.click();
        $$("p").find(Condition.text("Свяжитесь с нами!")).shouldHave(visible);
    }

    public void enterLinkPrivacyPolicy() {
        linkPrivacyPolicy.click();
        $$("p").find(Condition.text("В соответствии с положениями Федерального закона")).shouldHave(visible);
    }

    public void fillContactFormInfo(DataGenerator.ContactForm contactForm) {
        nameField.sendKeys(DataGenerator.getName());
        phoneField.sendKeys(DataGenerator.getPhone("9842344523"));
        emailField.sendKeys(DataGenerator.getEmail());
        commentField.sendKeys(DataGenerator.getComment("Хочу ознакомиться с продуктами"));
        buttonApplication.click();

    }

}
