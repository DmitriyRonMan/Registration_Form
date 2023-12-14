package test;

import Page.MainPage;
import Page.RegistrationPage;
import com.codeborne.selenide.*;
import com.codeborne.selenide.logevents.SelenideLogger;
import data.DataGenerator;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;


public class NegativeTestForRegistrationForm {
    private MainPage mainPage;
    private RegistrationPage registrationPage;

    private SelenideElement lastNameField = $("[name='name']");
    private SelenideElement nameField = $("[name='surname']");
    private SelenideElement emailField = $("[name='email']");
    private SelenideElement passwordField = $("[name='password']");
    private SelenideElement buttonContinue = $("[type='submit'].css-yhxv9x");

    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
        Configuration.headless = true;
    }

    @BeforeEach
    void setUp() {
        open("https://tms.biacorp.ru/");
        mainPage = new MainPage();
        registrationPage = mainPage.goToRegPage();
    }

    /*для проверки поля "Фамилия"*/
    @Test
    @DisplayName("Ввод данных на кириллице + цифры в поле 'Фамилия'.")
    void shouldTestTheLastNameField1() {

        registrationPage.getLastNameFromString("Иванов123");
        registrationPage.setErrorMessageForTheLastNameFieldWithRuLetters();
    }

    @Test
    @DisplayName("Ввод данных на латинице в поле 'Фамилия'.")
    void shouldTestTheLastNameField2() {

        registrationPage.getLastNameFromString("Ivanov");
        registrationPage.setErrorMessageForTheLastNameFieldWithRuLetters();
    }

    @Test
    @DisplayName("Ввод данных на арабице в поле 'Фамилия'.")
    void shouldTestTheLastNameField3() {

        registrationPage.getLastNameFromString("جينادي");
        registrationPage.setErrorMessageForTheLastNameFieldWithRuLetters();
    }

    @Test
    @DisplayName("Ввод данных в поле 'Фамилия' на кириллице в кол-ве 1 символа.")
    void shouldTestTheLastNameField4() {

        registrationPage.getLastNameFromString("А");
        registrationPage.setErrorMessageForTheLastNameFieldFromIntervalFrom1To64();
    }

    @Test
    @DisplayName("Ввод данных в поле 'Фамилия' на кириллице в кол-ве 65 символов.")
    void shouldTestTheLastNameField5() {

        registrationPage.getLastNameFromString("Аййильцикликирмицибайраактазийонкаграманоглувуарвтсдпнуывьстрлфуо");
        registrationPage.setErrorMessageForTheLastNameFieldFromIntervalFrom1To64();
    }

    @Test
    @DisplayName("Ввод данных из спец. символов в поле 'Фамилия'.")
    void shouldTestTheLastNameField6() {

        registrationPage.getLastNameFromString("Ив@!-!Ов");
        registrationPage.setErrorMessageForTheLastNameFieldWithRuLetters();
    }


    /*для проверки поля "Имя"*/
    @Test
    @DisplayName("Ввод данных на кириллице + цифры в поле 'Имя'.")
    void shouldTestTheNameField1() {

        registrationPage.fillRegIngo(DataGenerator.getRegFormName("Александр12"));
        registrationPage.setErrorMessageForTheNameFieldWithRuLetters();
    }

    @Test
    @DisplayName("Ввод данных на латинице в поле 'Имя'.")
    void shouldTestTheNameField2() {

        registrationPage.fillRegIngo(DataGenerator.getRegFormName("Ivan"));
        registrationPage.setErrorMessageForTheNameFieldWithRuLetters();
    }

    @Test
    @DisplayName("Ввод данных на арабице в поле 'Имя'.")
    void shouldTestTheNameField3() {

        registrationPage.fillRegIngo(DataGenerator.getRegFormName("الكسندر"));
        registrationPage.setErrorMessageForTheNameFieldWithRuLetters();
    }

    @Test
    @DisplayName("Ввод данных в поле 'Имя' на кириллице в кол-ве 1 символа.")
    void shouldTestTheNameField4() {

        registrationPage.fillRegIngo(DataGenerator.getRegFormName("П"));
        registrationPage.setErrorMessageForTheNameFieldFromIntervalFrom1To64();
    }

    @Test
    @DisplayName("Ввод данных в поле 'Имя' на кириллице в кол-ве 65 символов.")
    void shouldTestTheNameField5() {

        registrationPage.fillRegIngo(DataGenerator.getRegFormName("Аййильцикликирмицибайраактазийонкаграманоглувуарвтсдпнуывьстрлфуо"));
        registrationPage.setErrorMessageForTheNameFieldFromIntervalFrom1To64();
    }

    @Test
    @DisplayName("Ввод данных из спец. символов в поле 'Имя'.")
    void shouldTestTheNameField6() {

        registrationPage.fillRegIngo(DataGenerator.getRegFormName("Кар[]!н@"));
        registrationPage.setErrorMessageForTheNameFieldWithRuLetters();
    }


    /*для проверки поля "E-mail"*/
    @Test
    @DisplayName("Ввод данных в поле 'E-mail', которые полностью состоят из кириллицы.")
    void shouldTestTheEmailField1() throws InterruptedException {
        Configuration.holdBrowserOpen = true;

        registrationPage.fillRegIngo(DataGenerator.getRegFormEmail("планетаюпитер@майл.ру"));
        registrationPage.setErrorMessageFormatEmail();
    }

    @Test
    @DisplayName("Ввод данных в поле 'E-mail', где имя почтового ящика состоит из двух слов через пробел.")
    void shouldTestTheEmailField2() {
        Configuration.holdBrowserOpen = true;

        registrationPage.fillRegIngo(DataGenerator.getRegFormEmail("vdnh moskva@gmail.com"));
        registrationPage.setErrorMessageFormatEmail();
    }

    @Test
    @DisplayName("Ввод данных в поле 'E-mail' без имени почтового ящика.")
    void shouldTestTheEmailField3() {

        registrationPage.fillRegIngo(DataGenerator.getRegFormEmail("@yandex.ru"));
        registrationPage.setErrorMessageFormatEmail();
    }

    @Test
    @DisplayName("Ввод данных в поле 'E-mail' без символа '@'.")
    void shouldTestTheEmailField4() {

        registrationPage.fillRegIngo(DataGenerator.getRegFormEmail("fedin.mail.ru"));
        registrationPage.setErrorMessageFormatEmail();
    }

    @Test
    @DisplayName("Ввод данных в поле 'E-mail', где доменное имя без символа '.' .")
    void shouldTestTheEmailField5() {

        registrationPage.fillRegIngo(DataGenerator.getRegFormEmail("abracadabra@yandexru"));
        registrationPage.setErrorMessageFormatEmail();
    }


    /*для проверки поля "Пароль"*/
    /*@Test
    @DisplayName("Ввод данных в поле 'Пароль', состоящих только из единиц.")
    void shouldTestThePasswordField1() {

        Configuration.holdBrowserOpen = true;

        registrationPage.fillRegIngo(DataGenerator.getRegFormPassword("11111111"));
        registrationPage.setErrorMessagePasswordRepChar();
    }*/

    @Test
    @DisplayName("Ввод данных в поле 'Пароль', содержащие в себе запрещенные спец. символы.")
    void shouldTestThePasswordField2() {

        registrationPage.fillRegIngo(DataGenerator.getRegFormPassword("opt<>12"));
        registrationPage.setErrorMessagePasswordSpecChar();
    }

    @Test
    @DisplayName("Ввод данных в поле 'Пароль', состоящих из 5 символов.")
    void shouldTestThePasswordField3() {
        Configuration.holdBrowserOpen = true;
        registrationPage.fillRegIngo(DataGenerator.getRegFormPassword("PasW!"));
        registrationPage.setErrorMessagePasswordFrom7To64();
    }

   /* @Test
    @DisplayName("Ввод данных в поле 'Пароль', состоящих из цифр от 1 до 7.")
    void shouldTestThePasswordField4() {

        // нужно проверить последовательность символов

        Configuration.holdBrowserOpen = true;

        registrationPage.fillRegIngo(DataGenerator.getRegFormPassword("1234567"));
        registrationPage.setErrorMessagePasswordLight();
    }*/

    /*@Test
    @DisplayName("Ввод данных в поле 'Пароль', состоящих из последовательных символов на латинице.")
    void shouldTestThePasswordField5() {

        Configuration.holdBrowserOpen = true;

        registrationPage.fillRegIngo(DataGenerator.getRegFormPassword("asdfghj"));
        registrationPage.setErrorMessagePasswordLight();
    }*/

    /*@Test
    @DisplayName("Ввод данных в поле 'Пароль' на кириллице, содержащие в себе: цифры, спец. символы, верх. и ниж. регистр.")
    void shouldTestThePasswordField6() {

        registrationPage.fillRegIngo(DataGenerator.getRegFormPassword("арТиК@12!"));
        registrationPage.setNotErrorMessagePasswordLight();
    }*/

    /*для проверки отправки формы "Регистрация"*/

    @Test
    @DisplayName("Регистрация пользователя с незаполненными полями.")
    void shouldTestRegistrationUser() {

        registrationPage.getLastNameFromString("");
        registrationPage.getNameFromString("");
        registrationPage.getEmailFromString("");
        registrationPage.getPasswordFromString("");
        registrationPage.notVisibleButtonContinue();
    }
}
