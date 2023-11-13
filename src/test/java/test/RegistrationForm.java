package test;

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

        registrationPage.getLastNameFrom3To60();
    }

    @Test
    @DisplayName("Ввод данных в поле 'Фамилия' на кириллице в кол-ве 2 символов.")
    void shouldTestTheLastNameField2() {

        lastNameField.setValue("Ян");
        $(byText("Значение поля фамилия, должно содержать не меньше 1 буквы и не больше 64 букв")).shouldHave(Condition.not(Condition.visible));
    }

    @Test
    @DisplayName("Ввод данных в поле 'Фамилия' на кириллице в кол-ве 64 символов.")
    void shouldTestTheLastNameField3() {

        Configuration.holdBrowserOpen = true;

        lastNameField.setValue("Аййильцикликирмицибайрактазийонкаграманоглувуарвтсдпнуывьстрлфуо");
        $(byText("Значение поля фамилия, должно содержать не меньше 1 буквы и не больше 64 букв")).shouldHave(Condition.not(Condition.visible));
    }

    @Test
    @DisplayName("Ввод данных в поле 'Фамилия', содержащие букву 'ё'.")
    void shouldTestTheLastNameField4() {

        lastNameField.setValue("Алёхин");
        $(byText("Значение поля фамилия, может содержать только русские буквы")).shouldHave(Condition.not(Condition.visible));
    }

    @Test
    @DisplayName("Ввод данных в поле 'Фамилия' на кириллице через дефис.")
    void shouldTestTheLastNameField5() {

        Configuration.holdBrowserOpen = true;

        lastNameField.setValue("Римский-Корсаков");
        $(byText("Значение поля фамилия, может содержать только русские буквы")).shouldHave(Condition.not(Condition.visible));
    }

    @Test
    @DisplayName("Ввод данных в поле 'Фамилия', содержащий пробел.")
    void shouldTestTheLastNameField6() {

        Configuration.holdBrowserOpen = true;

        lastNameField.setValue("Дэвис Джексон");
        $(byText("Значение поля фамилия, может содержать только русские буквы")).shouldHave(Condition.not(Condition.visible));
    }


    /*для проверки поля "Имя"*/
    @Test
    @DisplayName("Ввод данных в поле 'Имя' на кириллице в диапазоне от 3 до 60 символов.")
    void shouldTestTheNameField1() {

        lastNameField.sendKeys(DataGenerator.getLastName());
        nameField.sendKeys(DataGenerator.getName());
        $(byText("Значение поля фамилия, может содержать только русские буквы")).shouldHave(Condition.not(Condition.visible));
    }

    @Test
    @DisplayName("Ввод данных в поле 'Имя' на кириллице в кол-ве 2 символов.")
    void shouldTestTheNameField2() {

        lastNameField.sendKeys(DataGenerator.getLastName());
        nameField.setValue("Ки");
        $(byText("Значение поля имя, должно содержать не меньше 1 буквы и не больше 64 букв")).shouldHave(Condition.not(Condition.visible));
    }

    @Test
    @DisplayName("Ввод данных в поле 'Имя' на кириллице в кол-ве 64 символов.")
    void shouldTestTheNameField3() {

        Configuration.holdBrowserOpen = true;

        lastNameField.sendKeys(DataGenerator.getLastName());
        nameField.setValue("Аййильцикликирмицибайрактазийонкаграманоглувуарвтсдпнуывьстрлфуо");
        $(byText("Значение поля имя, должно содержать не меньше 1 буквы и не больше 64 букв")).shouldHave(Condition.not(Condition.visible));
    }

    @Test
    @DisplayName("Ввод данных в поле 'Имя' на кириллице, содержащие букву 'ё'.")
    void shouldTestTheNameField4() {

        lastNameField.sendKeys(DataGenerator.getLastName());
        nameField.setValue("Пётр");
        $(byText("Значение поля фамилия, может содержать только русские буквы")).shouldHave(Condition.not(Condition.visible));
    }

    @Test
    @DisplayName("Ввод данных в поле 'Имя' на кириллице через дефис.")
    void shouldTestTheNameField5() {
        Configuration.holdBrowserOpen = true;

        lastNameField.sendKeys(DataGenerator.getLastName());
        nameField.setValue("Жак-Ив");
        $(byText("Значение поля имя, может содержать только русские буквы")).shouldHave(Condition.not(Condition.visible));
    }

    @Test
    @DisplayName("Ввод данных в поле 'Имя' на кириллице, содержащий пробел.")
    void shouldTestTheNameField6() {
        Configuration.holdBrowserOpen = true;

        lastNameField.sendKeys(DataGenerator.getLastName());
        nameField.setValue("Каролина Елена");
        $(byText("Значение поля имя, может содержать только русские буквы")).shouldHave(Condition.not(Condition.visible));
    }


    /*для проверки поля "E-mail"*/
    @Test
    @DisplayName("Ввод данных в поле 'E-mail' на латинице, содержащих в себе цифры.")
    void shouldTestTheEmailField1() {

        lastNameField.sendKeys(DataGenerator.getLastName());
        nameField.sendKeys(DataGenerator.getName());
        emailField.setValue("vladivostok2000@rbk.ru");
        $(byText("Значение поля email, не соответствует формату почты")).shouldHave(Condition.not(Condition.visible));
    }

    @Test
    @DisplayName("Ввод данных в поле 'E-mail' на латинице, где имя почтового ящика состоит из 2 символов.")
    void shouldTestTheEmailField2() {

        lastNameField.sendKeys(DataGenerator.getLastName());
        nameField.sendKeys(DataGenerator.getName());
        emailField.setValue("np@mail.ru");
        $(byText("Значение поля email, не соответствует формату почты")).shouldHave(Condition.not(Condition.visible));
    }

    @Test
    @DisplayName("Ввод данных в поле 'E-mail' на латинице, содержащих в себе дефис.")
    void shouldTestTheEmailField3() {

        lastNameField.sendKeys(DataGenerator.getLastName());
        nameField.sendKeys(DataGenerator.getName());
        emailField.setValue("gagarin-space@yandex.ru");
        $(byText("Значение поля email, не соответствует формату почты")).shouldHave(Condition.not(Condition.visible));
    }

    @Test
    @DisplayName("Ввод данных в поле 'E-mail' на латинице, где адрес электронной почты полностью в верхнем регистре.")
    void shouldTestTheEmailField4() {

        lastNameField.sendKeys(DataGenerator.getLastName());
        nameField.sendKeys(DataGenerator.getName());
        emailField.setValue("HOME@YAHOO.COM");
        $(byText("Значение поля email, не соответствует формату почты")).shouldHave(Condition.not(Condition.visible));
    }

    @Test
    @DisplayName("Ввод данных в поле 'E-mail' на латинице, где имя почтового ящика содержит в себе символ '.' .")
    void shouldTestTheEmailField5() {

        lastNameField.sendKeys(DataGenerator.getLastName());
        nameField.sendKeys(DataGenerator.getName());
        emailField.setValue("dog.cat@gmail.com");
        $(byText("Значение поля email, не соответствует формату почты")).shouldHave(Condition.not(Condition.visible));

    }


    /*для проверки поля "Пароль"*/
    @Test
    @DisplayName("Ввод данных в поле 'Пароль' на латинице, содержащие в себе: цифры, спец. символы, верх. и ниж. регистр.")
    void shouldTestThePasswordField1() {

        lastNameField.sendKeys(DataGenerator.getLastName());
        nameField.sendKeys(DataGenerator.getName());
        emailField.sendKeys(DataGenerator.getEmail());
        passwordField.setValue("PasswOrd19!");
        $(byText("Недопустимый пароль. Пароль слишком простой.")).shouldHave(Condition.not(Condition.visible));
    }

    @Test
    @DisplayName("Ввод данных в поле 'Пароль' на кириллице, содержащие в себе: цифры, спец. символы, верх. и ниж. регистр.")
    void shouldTestThePasswordField2() {

        lastNameField.sendKeys(DataGenerator.getLastName());
        nameField.sendKeys(DataGenerator.getName());
        emailField.sendKeys(DataGenerator.getEmail());
        passwordField.setValue("арТиК@12!");
        $(byText("Недопустимый пароль. Пароль слишком простой.")).shouldHave(Condition.not(Condition.visible));
    }


    /*для проверки перехода на форму "Вход"*/
    @Test
    @DisplayName("Проверка перехода на форму 'Вход' по кнопке 'Вход'.")
    void shouldTestTheButton() {
        Configuration.holdBrowserOpen = true;

        $("[type='button'].css-jq7zez").click();
        $$("h2").find(Condition.text("Вход")).shouldHave(Condition.text("Вход"));
    }


    /*для проверки отправки формы "Регистрация"*/
    @Test
    @DisplayName("Регистрация пользователя с заполненными валидными данными.")
    void shouldTestRegistrationUser() {

        Configuration.holdBrowserOpen = true;

        lastNameField.sendKeys(DataGenerator.getLastName());
        nameField.sendKeys(DataGenerator.getName());
        emailField.sendKeys(DataGenerator.getEmail());
        passwordField.sendKeys(DataGenerator.getPassword());
        buttonContinue.click();
        $(withText("Выберите вашу роль")).shouldHave(Condition.visible);
    }

}
