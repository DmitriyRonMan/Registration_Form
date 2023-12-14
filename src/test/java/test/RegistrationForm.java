package test;

import Page.MainPage;
import Page.RegistrationPage;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import data.DataGenerator;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.*;


public class RegistrationForm {
    private MainPage mainPage;
    private RegistrationPage registrationPage;

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
        registrationPage = mainPage.goToRegPage();
    }

    /*для проверки поля "Фамилия"*/
    @Test
    @DisplayName("Ввод данных в поле 'Фамилия' на кириллице в диапазоне от 3 до 60 символов.")
    void shouldTestTheLastNameField1() {

        registrationPage.getARandomLastName();
        registrationPage.setNotErrorMessageForTheLastNameFieldWithRuLetters();
    }

    @Test
    @DisplayName("Ввод данных в поле 'Фамилия' на кириллице в кол-ве 2 символов.")
    void shouldTestTheLastNameField2() {

        registrationPage.getLastNameFromString("Ян");
        registrationPage.setNotErrorMessageForTheLastNameFieldFromIntervalFrom1To64();
    }

    @Test
    @DisplayName("Ввод данных в поле 'Фамилия' на кириллице в кол-ве 64 символов.")
    void shouldTestTheLastNameField3() {

        registrationPage.getLastNameFromString("Аййильцикликирмицибайрактазийонкаграманоглувуарвтсдпнуывьстрлфуо");
        registrationPage.setNotErrorMessageForTheLastNameFieldFromIntervalFrom1To64();
    }

    @Test
    @DisplayName("Ввод данных в поле 'Фамилия', содержащие букву 'ё'.")
    void shouldTestTheLastNameField4() {

        registrationPage.getLastNameFromString("Алёхин");
        registrationPage.setNotErrorMessageForTheLastNameFieldWithRuLetters();
    }

    @Test
    @DisplayName("Ввод данных в поле 'Фамилия' на кириллице через дефис.")
    void shouldTestTheLastNameField5() {

        registrationPage.getLastNameFromString("Римский-Корсаков");
        registrationPage.setNotErrorMessageForTheLastNameFieldWithRuLetters();
    }

    @Test
    @DisplayName("Ввод данных в поле 'Фамилия', содержащий пробел.")
    void shouldTestTheLastNameField6() {

        registrationPage.getLastNameFromString("Дэвис Джексон");
        registrationPage.setNotErrorMessageForTheLastNameFieldWithRuLetters();
    }


    /*для проверки поля "Имя"*/
    @Test
    @DisplayName("Ввод данных в поле 'Имя' на кириллице в диапазоне от 3 до 60 символов.")
    void shouldTestTheNameField1() {

        registrationPage.getARandomLastName();
        registrationPage.getARandomName();
        registrationPage.setNotErrorMessageForTheNameFieldWithRuLetters();
    }

    @Test
    @DisplayName("Ввод данных в поле 'Имя' на кириллице в кол-ве 2 символов.")
    void shouldTestTheNameField2() {

        registrationPage.fillRegIngo(DataGenerator.getRegFormName("Ки"));
        registrationPage.setNotErrorMessageForTheNameFieldFromIntervalFrom1To64();
    }

    @Test
    @DisplayName("Ввод данных в поле 'Имя' на кириллице в кол-ве 64 символов.")
    void shouldTestTheNameField3() {

        registrationPage.fillRegIngo(DataGenerator.getRegFormName("Аййильцикликирмицибайрактазийонкаграманоглувуарвтсдпнуывьстрлфуо"));
        registrationPage.setNotErrorMessageForTheNameFieldFromIntervalFrom1To64();
    }

    @Test
    @DisplayName("Ввод данных в поле 'Имя' на кириллице, содержащие букву 'ё'.")
    void shouldTestTheNameField4() {

        registrationPage.fillRegIngo(DataGenerator.getRegFormName("Пётр"));
        registrationPage.setNotErrorMessageForTheNameFieldWithRuLetters();
    }

    @Test
    @DisplayName("Ввод данных в поле 'Имя' на кириллице через дефис.")
    void shouldTestTheNameField5() {

        registrationPage.fillRegIngo(DataGenerator.getRegFormName("Жак-Ив"));
        registrationPage.setNotErrorMessageForTheNameFieldWithRuLetters();
    }

    @Test
    @DisplayName("Ввод данных в поле 'Имя' на кириллице, содержащий пробел.")
    void shouldTestTheNameField6() {

        registrationPage.fillRegIngo(DataGenerator.getRegFormName("Каролина Елена"));
        registrationPage.setNotErrorMessageForTheNameFieldWithRuLetters();
    }

    /*для проверки поля "E-mail"*/
    @Test
    @DisplayName("Ввод данных в поле 'E-mail' на латинице, содержащих в себе цифры.")
    void shouldTestTheEmailField1() {

        registrationPage.fillRegIngo(DataGenerator.getRegFormEmail("vladivostok2000@rbk.ru"));
        registrationPage.setNotErrorMessageFormatEmail();
    }

    @Test
    @DisplayName("Ввод данных в поле 'E-mail' на латинице, где имя почтового ящика состоит из 2 символов.")
    void shouldTestTheEmailField2() {

        registrationPage.fillRegIngo(DataGenerator.getRegFormEmail("np@mail.ru"));
        registrationPage.setNotErrorMessageFormatEmail();
    }

    @Test
    @DisplayName("Ввод данных в поле 'E-mail' на латинице, содержащих в себе дефис.")
    void shouldTestTheEmailField3() {

        registrationPage.fillRegIngo(DataGenerator.getRegFormEmail("gagarin-space@yandex.ru"));
        registrationPage.setNotErrorMessageFormatEmail();
    }

    @Test
    @DisplayName("Ввод данных в поле 'E-mail' на латинице, где адрес электронной почты полностью в верхнем регистре.")
    void shouldTestTheEmailField4() {

        registrationPage.fillRegIngo(DataGenerator.getRegFormEmail("HOME@YAHOO.COM"));
        registrationPage.setNotErrorMessageFormatEmail();
    }

    @Test
    @DisplayName("Ввод данных в поле 'E-mail' на латинице, где имя почтового ящика содержит в себе символ '.' .")
    void shouldTestTheEmailField5() {

        registrationPage.fillRegIngo(DataGenerator.getRegFormEmail("dog.cat@gmail.com"));
        registrationPage.setNotErrorMessageFormatEmail();

    }


    //для проверки поля "Пароль"
    @Test
    @DisplayName("Ввод данных в поле 'Пароль' на латинице, содержащие в себе: цифры, спец. символы, верх. и ниж. регистр.")
    void shouldTestThePasswordField1() {

        registrationPage.fillRegIngo(DataGenerator.getRegFormPassword("PasswOrd19!"));
        registrationPage.setNotErrorMessagePasswordLight();
    }

    //для проверки перехода на форму "Вход"
    @Test
    @DisplayName("Проверка перехода на форму 'Вход' по кнопке 'Вход'.")
    void shouldTestTheButton() {

        registrationPage.enterButtonAuth();
        registrationPage.goToAuthPage();
    }


    //для проверки отправки формы "Регистрация"
    @Test
    @DisplayName("Регистрация пользователя с заполненными валидными данными.")
    void shouldTestValidRegistrationUser() {

        registrationPage.fillRegIngo(DataGenerator.getRegValidForm());
        registrationPage.enterButtonContinue();
        registrationPage.setLetterSent();
        registrationPage.setChooseRole();
        registrationPage.exitAccountAfterReg();
    }

}
