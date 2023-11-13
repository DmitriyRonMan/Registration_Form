package Page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MainPage {

    private SelenideElement heading = $$("[class='chakra-text css-3myuqt']").find(Condition.text("БИА. Помощник логиста"));
    private SelenideElement buttonReg = $$("button").find(Condition.text("Зарегистрироваться"));
    private SelenideElement buttonAuth = $$("button").find(Condition.text("Войти"));


    public MainPage() {
        heading.shouldBe(visible);
    }

    public RegistrationPage goToRegPage() {
        buttonReg.click();
        return new RegistrationPage();
    }

    public AuthorizationPage goToAuthPage() {
        buttonAuth.click();
        return new AuthorizationPage();
    }
}
