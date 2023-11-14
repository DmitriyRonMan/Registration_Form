package Page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$;

public class AuthorizationPage {

    private SelenideElement heading = $$("h2").find(Condition.text("Вход"));

    public AuthorizationPage() {
        heading.shouldBe(Condition.visible);
    }
}
