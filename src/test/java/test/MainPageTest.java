package test;

import Page.MainPage;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import data.DataGenerator;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.open;

public class MainPageTest {

    private MainPage mainPage;

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
    }

    @Test
    @DisplayName("Переход на модальное окно 'Регистрация' по кнопке 'Зарегистрироваться' ")
    void shouldTestTheEntranceReg() {

        mainPage.goToRegPage();
    }

    @Test
    @DisplayName("Переход на модальное окно 'Регистрация' по кнопке 'Регистрация' ")
    void shouldTestTheEntranceReg2() {

        mainPage.goToRegPageViaTheSecondButton();
    }

    @Test
    @DisplayName("Переход на модальное окно 'Регистрация' по кнопке 'Начать' ")
    void shouldTestTheEntranceReg3() {

        mainPage.goToRegPageViaTheStartButton();
    }

    @Test
    @DisplayName("Переход на модальное окно 'Войти' по кнопке 'Войти' ")
    void shouldTestTheEntranceAuth() {

        mainPage.goToAuthPage();
    }

    @Test
    @DisplayName("Проверка кнопки 'О продукте' на кликабельность")
    void shouldTestTheClickButtonProduct() {

        mainPage.enterButtonInfoProduct();
    }

    @Test
    @DisplayName("Проверка кнопки 'Решения' на кликабельность")
    void shouldTestTheClickButtonSolutions() {

        mainPage.enterButtonSolutions();
    }

    @Test
    @DisplayName("Проверка кнопки 'Тарифы' на кликабельность")
    void shouldTestTheClickButtonRates() {

        mainPage.enterButtonRates();
    }

    @Test
    @DisplayName("Проверка кнопки 'Поддержка' на кликабельность")
    void shouldTestTheClickButtonSupport() {

        mainPage.enterButtonSupport();
    }

    @Test
    @DisplayName("Проверка кнопки 'Контакты' на кликабельность")
    void shouldTestTheClickButtonContacts() {

        mainPage.enterButtonContacts();
    }

    @Test
    @DisplayName("Проверка ссылки 'Политикой конфиденциальности' на кликабельность")
    void shouldTestTheClickLinkPrivacyPolicy() {

        mainPage.enterLinkPrivacyPolicy();
    }

    /*@Test
    @DisplayName("Отправка формы для связи с валидными данными")
    void shouldTestTheSubmittingForm() {

        mainPage.fillContactFormInfo(DataGenerator.getContactFormValid());
    }*/

}
