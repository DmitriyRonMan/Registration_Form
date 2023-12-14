package test;

import Page.AuthorizationPage;
import Page.MainPage;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import data.DataGenerator;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.open;

public class NegativeTestsForTheAuthorizationForm {

    private MainPage mainPage;
    private AuthorizationPage authorizationPage;

    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        Configuration.headless = true;
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }

    @BeforeEach
    void setUp() {
        open("https://tms.biacorp.ru/");
        mainPage = new MainPage();
        authorizationPage = mainPage.goToAuthPage();
    }

    @Test
    @DisplayName("Вход в систему без 'Email'")
    void shouldTestTheEntranceAuthNotEmail() {

        authorizationPage.fillAuthIngo(DataGenerator.getAuthFormNoValidEmail());
        authorizationPage.enterButtonEntrance();
        authorizationPage.setErrorMessagePasswordAndName();
    }

    @Test
    @DisplayName("Вход в систему без 'Password'")
    void shouldTestTheEntranceAuthNotPassword() {

        authorizationPage.fillAuthIngo(DataGenerator.getAuthFormNoValidPassword());
        authorizationPage.enterButtonEntrance();
        authorizationPage.setErrorMessagePasswordAndName();
    }

    @Test
    @DisplayName("Переход на форму восстановления пароля и отправка ссылки на неавторизованную электронную почту")
    void shouldTestTheTransitionToThePasswordFormNotAuthEmail() {

        authorizationPage.enterButtonPassword();
        authorizationPage.fillAuthInfoPassword(DataGenerator.getAuthPasswordNotValidForm());
        authorizationPage.enterButtonEntrance();
        authorizationPage.setErrorMessageNotEmailAuth();
    }
}
