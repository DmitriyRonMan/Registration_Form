package test;

import Page.AuthorizationPage;
import Page.MainPage;
import Page.RegistrationPage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;
import data.DataGenerator;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;


public class RegistrationForm {
    private MainPage mainPage;
    private RegistrationPage registrationPage;
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
        registrationPage = mainPage.goToRegPage();
    }

    /*для проверки поля "Фамилия"*/
    @Test
    @DisplayName("Ввод данных в поле 'Фамилия' на кириллице в диапазоне от 3 до 60 символов.")
    void shouldTestTheLastNameField1() {

        registrationPage.getARandomLastName();
        registrationPage.setErrorMessageForTheLastNameFieldWithRuLetters();
    }

    @Test
    @DisplayName("Ввод данных в поле 'Фамилия' на кириллице в кол-ве 2 символов.")
    void shouldTestTheLastNameField2() {

        registrationPage.getLastNameFromString("Ян");
        registrationPage.setErrorMessageForTheLastNameFieldFromIntervalFrom1To64();
    }

    @Test
    @DisplayName("Ввод данных в поле 'Фамилия' на кириллице в кол-ве 64 символов.")
    void shouldTestTheLastNameField3() {

        Configuration.holdBrowserOpen = true;

        registrationPage.getLastNameFromString("Аййильцикликирмицибайрактазийонкаграманоглувуарвтсдпнуывьстрлфуо");
        registrationPage.setErrorMessageForTheLastNameFieldFromIntervalFrom1To64();
    }

    @Test
    @DisplayName("Ввод данных в поле 'Фамилия', содержащие букву 'ё'.")
    void shouldTestTheLastNameField4() {

        registrationPage.getLastNameFromString("Алёхин");
        registrationPage.setErrorMessageForTheLastNameFieldWithRuLetters();
    }

    @Test
    @DisplayName("Ввод данных в поле 'Фамилия' на кириллице через дефис.")
    void shouldTestTheLastNameField5() {

        Configuration.holdBrowserOpen = true;

        registrationPage.getLastNameFromString("Римский-Корсаков");
        registrationPage.setErrorMessageForTheLastNameFieldWithRuLetters();
    }

    @Test
    @DisplayName("Ввод данных в поле 'Фамилия', содержащий пробел.")
    void shouldTestTheLastNameField6() {

        Configuration.holdBrowserOpen = true;

        registrationPage.getLastNameFromString("Дэвис Джексон");
        registrationPage.setErrorMessageForTheLastNameFieldWithRuLetters();
    }


    /*для проверки поля "Имя"*/
    @Test
    @DisplayName("Ввод данных в поле 'Имя' на кириллице в диапазоне от 3 до 60 символов.")
    void shouldTestTheNameField1() {

        registrationPage.getARandomLastName();
        registrationPage.getARandomName();
        registrationPage.setErrorMessageForTheNameFieldWithRuLetters();
    }

    @Test
    @DisplayName("Ввод данных в поле 'Имя' на кириллице в кол-ве 2 символов.")
    void shouldTestTheNameField2() {

        registrationPage.getARandomLastName();
        registrationPage.getNameFromString("Ки");
        registrationPage.setErrorMessageForTheNameFieldFromIntervalFrom1To64();
    }

    @Test
    @DisplayName("Ввод данных в поле 'Имя' на кириллице в кол-ве 64 символов.")
    void shouldTestTheNameField3() {

        Configuration.holdBrowserOpen = true;

        registrationPage.getARandomLastName();
        registrationPage.getNameFromString("Аййильцикликирмицибайрактазийонкаграманоглувуарвтсдпнуывьстрлфуо");
        registrationPage.setErrorMessageForTheNameFieldFromIntervalFrom1To64();
    }

    @Test
    @DisplayName("Ввод данных в поле 'Имя' на кириллице, содержащие букву 'ё'.")
    void shouldTestTheNameField4() {

        registrationPage.getARandomLastName();
        registrationPage.getNameFromString("Пётр");
        registrationPage.setErrorMessageForTheNameFieldWithRuLetters();
    }

    @Test
    @DisplayName("Ввод данных в поле 'Имя' на кириллице через дефис.")
    void shouldTestTheNameField5() {
        Configuration.holdBrowserOpen = true;

        registrationPage.getARandomLastName();
        registrationPage.getNameFromString("Жак-Ив");
        registrationPage.setErrorMessageForTheNameFieldWithRuLetters();
    }

    @Test
    @DisplayName("Ввод данных в поле 'Имя' на кириллице, содержащий пробел.")
    void shouldTestTheNameField6() {
        Configuration.holdBrowserOpen = true;

        registrationPage.getARandomLastName();
        registrationPage.getNameFromString("Каролина Елена");
        registrationPage.setErrorMessageForTheNameFieldWithRuLetters();
    }

    /*для проверки поля "E-mail"*/
    @Test
    @DisplayName("Ввод данных в поле 'E-mail' на латинице, содержащих в себе цифры.")
    void shouldTestTheEmailField1() {

        registrationPage.getARandomLastName();
        registrationPage.getARandomName();
        registrationPage.getEmailFromString("vladivostok2000@rbk.ru");
        registrationPage.setErrorMessageFormatEmail();
    }

    @Test
    @DisplayName("Ввод данных в поле 'E-mail' на латинице, где имя почтового ящика состоит из 2 символов.")
    void shouldTestTheEmailField2() {

        registrationPage.getARandomLastName();
        registrationPage.getARandomName();
        registrationPage.getEmailFromString("np@mail.ru");
        registrationPage.setErrorMessageFormatEmail();
    }

    @Test
    @DisplayName("Ввод данных в поле 'E-mail' на латинице, содержащих в себе дефис.")
    void shouldTestTheEmailField3() {

        registrationPage.getARandomLastName();
        registrationPage.getARandomName();
        registrationPage.getEmailFromString("gagarin-space@yandex.ru");
        registrationPage.setErrorMessageFormatEmail();
    }

    @Test
    @DisplayName("Ввод данных в поле 'E-mail' на латинице, где адрес электронной почты полностью в верхнем регистре.")
    void shouldTestTheEmailField4() {

        registrationPage.getARandomLastName();
        registrationPage.getARandomName();
        registrationPage.getEmailFromString("HOME@YAHOO.COM");
        registrationPage.setErrorMessageFormatEmail();
    }

    @Test
    @DisplayName("Ввод данных в поле 'E-mail' на латинице, где имя почтового ящика содержит в себе символ '.' .")
    void shouldTestTheEmailField5() {

        registrationPage.getARandomLastName();
        registrationPage.getARandomName();
        registrationPage.getEmailFromString("dog.cat@gmail.com");
        registrationPage.setErrorMessageFormatEmail();

    }


    //для проверки поля "Пароль"
    @Test
    @DisplayName("Ввод данных в поле 'Пароль' на латинице, содержащие в себе: цифры, спец. символы, верх. и ниж. регистр.")
    void shouldTestThePasswordField1() {

        registrationPage.getARandomLastName();
        registrationPage.getARandomName();
        registrationPage.getARandomEmail();
        registrationPage.getPasswordFromString("PasswOrd19!");
        registrationPage.setErrorMessagePasswordLight();
    }

    @Test
    @DisplayName("Ввод данных в поле 'Пароль' на кириллице, содержащие в себе: цифры, спец. символы, верх. и ниж. регистр.")
    void shouldTestThePasswordField2() {

        registrationPage.getARandomLastName();
        registrationPage.getARandomName();
        registrationPage.getARandomEmail();
        registrationPage.getPasswordFromString("арТиК@12!");
        registrationPage.setErrorMessagePasswordLight();
    }


    //для проверки перехода на форму "Вход"
    @Test
    @DisplayName("Проверка перехода на форму 'Вход' по кнопке 'Вход'.")
    void shouldTestTheButton() {
        Configuration.holdBrowserOpen = true;

        registrationPage.enterButtonAuth();
        registrationPage.goToAuthPage();
    }


    //для проверки отправки формы "Регистрация"
    @Test
    @DisplayName("Регистрация пользователя с заполненными валидными данными.")
    void shouldTestRegistrationUser() {

        registrationPage.fillRegIngo(DataGenerator.getRegValidForm());
        registrationPage.setChooseRole();
    }

}
