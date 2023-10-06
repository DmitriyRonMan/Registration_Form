package test;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;
import data.DataGenerator;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;


public class RegistrationForm {


    private SelenideElement lastNameField = $("[name='name']");
    private SelenideElement nameField = $("[name='surname']");
    private SelenideElement emailField = $("[name='email']");
    private SelenideElement passwordField = $("[name='password']");
    private SelenideElement buttonContinue = $("[type='submit']");

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
        $$("button").find(Condition.text("Зарегистрироваться")).click();
    }

    /*для проверки поля "Фамилия"*/
    @Test
    @DisplayName("Ввести данные в поле на кириллице в диапазоне от 3 до 60 символов.")
    void shouldTestTheLastNameField1() {

        lastNameField.sendKeys(DataGenerator.getLastName());
        nameField.sendKeys(DataGenerator.getName());
        emailField.sendKeys(DataGenerator.getEmail());
        passwordField.sendKeys(DataGenerator.getPassword());
        buttonContinue.click();
        $("[data-status=\"info\"]").should(Condition.visible);
/*
        $(byText("Фамилия указана неверно. Допустимы только русские буквы, пробелы и дефисы.")).shouldHave(Condition.not(Condition.visible));
*/
    }

    @Test
    @DisplayName("Ввести данные в поле на кириллице в кол-ве 2 символов.")
    void shouldTestTheLastNameField2() {

        lastNameField.setValue("Ян");
        nameField.sendKeys(DataGenerator.getName());
        emailField.sendKeys(DataGenerator.getEmail());
        passwordField.sendKeys(DataGenerator.getPassword());
        buttonContinue.click();
        $("[data-status=\"info\"]").should(Condition.visible);
/*
        $(byText("Фамилия указана неверно. Значение поля не должно быть меньше 3 символов.")).shouldHave(Condition.not(Condition.visible));
*/
    }

    @Test
    @DisplayName("Ввести данные в поле на кириллице в кол-ве 64 символов.")
    void shouldTestTheLastNameField3() {

        lastNameField.setValue("Аййильцикликирмицибайрактазийонкаграманоглувуарвтсдпнуывьстрлфуо");
        nameField.sendKeys(DataGenerator.getName());
        emailField.sendKeys(DataGenerator.getEmail());
        passwordField.sendKeys(DataGenerator.getPassword());
        buttonContinue.click();
        $("[data-status=\"info\"]").should(Condition.visible);
/*
        $(byText("Фамилия указана неверно. Значение поля не должно быть больше 63 символов.")).shouldHave(Condition.not(Condition.visible));
*/

    }

    @Test
    @DisplayName("Ввести данные в поле на кириллице, содержащие букву 'ё'.")
    void shouldTestTheLastNameField4() {

        lastNameField.setValue("Алёхин");
        nameField.sendKeys(DataGenerator.getName());
        emailField.sendKeys(DataGenerator.getEmail());
        passwordField.sendKeys(DataGenerator.getPassword());
        buttonContinue.click();
        $(byText("Фамилия указана неверно. Допустимы только русские буквы, пробелы и дефисы.")).shouldHave(Condition.not(Condition.visible));


    }

    @Test
    @DisplayName("Ввести данные в поле на кириллице через дефис.")
    void shouldTestTheLastNameField5() {

        lastNameField.setValue("Римский - Корсаков");
        nameField.sendKeys(DataGenerator.getName());
        emailField.sendKeys(DataGenerator.getEmail());
        passwordField.sendKeys(DataGenerator.getPassword());
        buttonContinue.click();
        $(byText("Фамилия указана неверно. Допустимы только русские буквы, пробелы и дефисы.")).shouldHave(Condition.not(Condition.visible));
    }

    @Test
    @DisplayName("Ввести данные в поле на кириллице, содержащий пробел.")
    void shouldTestTheLastNameField6() {

        lastNameField.setValue("Дэвис Джексон");
        nameField.sendKeys(DataGenerator.getName());
        emailField.sendKeys(DataGenerator.getEmail());
        passwordField.sendKeys(DataGenerator.getPassword());
        buttonContinue.click();
        $(byText("Фамилия указана неверно. Допустимы только русские буквы, пробелы и дефисы.")).shouldHave(Condition.not(Condition.visible));
    }


    /*для проверки поля "Имя"*/
    @Test
    @DisplayName("Ввести данные в поле на кириллице в диапазоне от 3 до 60 символов.")
    void shouldTestTheNameField1() {

        lastNameField.sendKeys(DataGenerator.getLastName());
        nameField.sendKeys(DataGenerator.getName());
        emailField.sendKeys(DataGenerator.getEmail());
        passwordField.sendKeys(DataGenerator.getPassword());
        buttonContinue.click();
        $(byText("Имя указано неверно. Допустимы только русские буквы, пробелы и дефисы.")).shouldHave(Condition.not(Condition.visible));
    }

    @Test
    @DisplayName("Ввести данные в поле на кириллице в кол-ве 2 символов.")
    void shouldTestTheNameField2() {

        lastNameField.sendKeys(DataGenerator.getLastName());
        nameField.setValue("Ки");
        emailField.sendKeys(DataGenerator.getEmail());
        passwordField.sendKeys(DataGenerator.getPassword());
        buttonContinue.click();
        $(byText("Имя указано неверно. Значение поля не должно быть меньше 3 символов.")).shouldHave(Condition.not(Condition.visible));
    }

    @Test
    @DisplayName("Ввести данные в поле на кириллице в кол-ве 64 символов.")
    void shouldTestTheNameField3() {

        lastNameField.sendKeys(DataGenerator.getLastName());
        nameField.setValue("Аййильцикликирмицибайрактазийонкаграманоглувуарвтсдпнуывьстрлфуо");
        emailField.sendKeys(DataGenerator.getEmail());
        passwordField.sendKeys(DataGenerator.getPassword());
        buttonContinue.click();
        $(byText("Имя указано неверно. Значение поля не должно быть больше 63 символов.")).shouldHave(Condition.not(Condition.visible));
    }

    @Test
    @DisplayName("Ввести данные в поле на кириллице, содержащие букву 'ё'.")
    void shouldTestTheNameField4() {

        lastNameField.sendKeys(DataGenerator.getLastName());
        nameField.setValue("Пётр");
        emailField.sendKeys(DataGenerator.getEmail());
        passwordField.sendKeys(DataGenerator.getPassword());
        buttonContinue.click();
        $(byText("Имя указано неверно. Допустимы только русские буквы, пробелы и дефисы.")).shouldHave(Condition.not(Condition.visible));
    }

    @Test
    @DisplayName("Ввести данные в поле на кириллице через дефис.")
    void shouldTestTheNameField5() {

        lastNameField.sendKeys(DataGenerator.getLastName());
        nameField.setValue("Жак-Ив");
        emailField.sendKeys(DataGenerator.getEmail());
        passwordField.sendKeys(DataGenerator.getPassword());
        buttonContinue.click();
        $(byText("Имя указано неверно. Допустимы только русские буквы, пробелы и дефисы.")).shouldHave(Condition.not(Condition.visible));
    }

    @Test
    @DisplayName("Ввести данные в поле на кириллице, содержащий пробел.")
    void shouldTestTheNameField6() {

        lastNameField.sendKeys(DataGenerator.getLastName());
        nameField.setValue("Каролина Елена");
        emailField.sendKeys(DataGenerator.getEmail());
        passwordField.sendKeys(DataGenerator.getPassword());
        buttonContinue.click();
        $(byText("Имя указано неверно. Допустимы только русские буквы, пробелы и дефисы.")).shouldHave(Condition.not(Condition.visible));
    }


    /*для проверки поля "E-mail"*/
    @Test
    @DisplayName("Ввести данные в поле на латинице, содержащие в себе цифры.")
    void shouldTestTheEmailField1() {

        lastNameField.sendKeys(DataGenerator.getLastName());
        nameField.sendKeys(DataGenerator.getName());
        emailField.setValue("vladivostok2000@rbk.ru");
        passwordField.sendKeys(DataGenerator.getPassword());
        buttonContinue.click();
        $(byText("Email указан неверно. В тексте перед знаком '@' не должно быть символа '2'.")).shouldHave(Condition.not(Condition.visible));
    }

    @Test
    @DisplayName("Ввести данные в поле на латинице, где имя почтового ящика состоит из 2 символов.")
    void shouldTestTheEmailField2() {

        lastNameField.sendKeys(DataGenerator.getLastName());
        nameField.sendKeys(DataGenerator.getName());
        emailField.setValue("np@mail.ru");
        passwordField.sendKeys(DataGenerator.getPassword());
        buttonContinue.click();
        $(byText("Email указан неверно. В тексте перед знаком '@' не должно быть меньше 3 символов.")).shouldHave(Condition.not(Condition.visible));
    }

    @Test
    @DisplayName("Ввести данные в поле на латинице, содержащие в себе дефис.")
    void shouldTestTheEmailField3() {

        lastNameField.sendKeys(DataGenerator.getLastName());
        nameField.sendKeys(DataGenerator.getName());
        emailField.setValue("gagarin-space@yandex.ru");
        passwordField.sendKeys(DataGenerator.getPassword());
        buttonContinue.click();
        $(byText("Email указан неверно. В тексте перед знаком '@' не должно быть символа '-'.")).shouldHave(Condition.not(Condition.visible));
    }

    @Test
    @DisplayName("Ввести данные в поле на латинице, где адрес электронной почты полностью в верхнем регистре.")
    void shouldTestTheEmailField4() {

        lastNameField.sendKeys(DataGenerator.getLastName());
        nameField.sendKeys(DataGenerator.getName());
        emailField.setValue("HOME@YAHOO.COM");
        passwordField.sendKeys(DataGenerator.getPassword());
        buttonContinue.click();
        $(byText("Email указан неверно.")).shouldHave(Condition.not(Condition.visible));
    }

    @Test
    @DisplayName("Ввести данные в поле на латинице, где имя электронной почты полностью в верхнем регистре.")
    void shouldTestTheEmailField5() {

        lastNameField.sendKeys(DataGenerator.getLastName());
        nameField.sendKeys(DataGenerator.getName());
        emailField.setValue("HOME@yahoo.com");
        passwordField.sendKeys(DataGenerator.getPassword());
        buttonContinue.click();
        $(byText("Email указан неверно.")).shouldHave(Condition.not(Condition.visible));
    }

    @Test
    @DisplayName("Ввести данные в поле на латинице, содержащие в себе '.' .")
    void shouldTestTheEmailField6() {

        lastNameField.sendKeys(DataGenerator.getLastName());
        nameField.sendKeys(DataGenerator.getName());
        emailField.setValue("dog.cat@gmail.com");
        passwordField.sendKeys(DataGenerator.getPassword());
        buttonContinue.click();
        $(byText("Email указан неверно. В тексте перед знаком '@' не должно быть символа '.'.")).shouldHave(Condition.not(Condition.visible));
    }


    /*для проверки поля "Пароль"*/
    @Test
    @DisplayName("Ввести данные в поле на латинице, содержащие в себе: цифры, спец. символы, верх. и ниж. регистр.")
    void shouldTestThePasswordField1() {

        lastNameField.sendKeys(DataGenerator.getLastName());
        nameField.sendKeys(DataGenerator.getName());
        emailField.sendKeys(DataGenerator.getEmail());
        passwordField.setValue("PasswOrd19!");
        buttonContinue.click();
        $(byText("Пароль указан неверно. Слишком простой пароль.")).shouldHave(Condition.not(Condition.visible));
    }

    @Test
    @DisplayName("Ввести данные в поле на кириллице, содержащие в себе: цифры, спец. символы, верх. и ниж. регистр.")
    void shouldTestThePasswordField2() {

        lastNameField.sendKeys(DataGenerator.getLastName());
        nameField.sendKeys(DataGenerator.getName());
        emailField.sendKeys(DataGenerator.getEmail());
        passwordField.setValue("арТиК@12!");
        buttonContinue.click();
        $(byText("Пароль указан неверно. В тексте не должны содержаться кириллические символы.")).shouldHave(Condition.not(Condition.visible));
    }


    /*для проверки перехода на форму "Вход"*/
    @Test
    @DisplayName("Проверка перехода на форму 'Вход' по кнопке 'Вход'.")
    void shouldTestTheButton() {

        $("[type=\"button\"].css-jq7zez").click();
        $$("h2").find(Condition.text("Вход")).shouldHave(Condition.text("Вход"));
    }


    /*для проверки отправки формы "Регистрация"*/
    @Test
    @DisplayName("Регистрация пользователя с заполненными валидными данными.")
    void shouldTestRegistrationUser() {

        $("[name='name']").sendKeys(DataGenerator.getLastName());
        nameField.sendKeys(DataGenerator.getName());
        emailField.sendKeys(DataGenerator.getEmail());
        passwordField.sendKeys(DataGenerator.getPassword());
        buttonContinue.click();
        $(withText("Выберите вашу роль")).shouldHave(Condition.visible);
    }

}
