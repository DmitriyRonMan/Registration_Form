package test;

import Page.AuthorizationPage;
import Page.MainPage;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import data.DataGenerator;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.open;

public class AuthorizationTest {

    private MainPage mainPage;
    private AuthorizationPage authorizationPage;

    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
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
    @DisplayName("Вход в систему авторизованным пользователем")
    void shouldTestTheEntranceAuth() {

        authorizationPage.fillAuthIngo(DataGenerator.getAuthFormValid());
        authorizationPage.enterButtonEntrance();
        authorizationPage.setChooseRole();
    }

    @Test
    @DisplayName("Переход на форму Регистрации")
    void shouldTestTheTransitionToTheRegistrationForm() {

        authorizationPage.enterButtonReg();
        authorizationPage.goToRegPage();
    }

    @Test
    @DisplayName("Переход на форму восстановления пароля и отправка ссылки на авторизованную электронную почту")
    void shouldTestTheTransitionToThePasswordForm() {

        authorizationPage.enterButtonPassword();
        authorizationPage.fillAuthInfoPassword(DataGenerator.getAuthPasswordValidForm());
        authorizationPage.enterButtonEntrance();
        authorizationPage.setLetterSent();
    }


}
