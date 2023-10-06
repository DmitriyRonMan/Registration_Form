package test;

import com.codeborne.selenide.*;
import com.codeborne.selenide.logevents.SelenideLogger;
import data.DataGenerator;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class NegativeTestForRegistrationForm {

    private SelenideElement lastNameField = $("[name='name']");
    private SelenideElement nameField = $("[name=\"surname\"]");
    private SelenideElement emailField = $("[name=\"email\"]");
    private SelenideElement passwordField = $("[name=\"password\"]");
    private SelenideElement buttonContinue = $("[type=\"submit\"]");

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
    @DisplayName("Ввести данные в поле на кириллице + цифры.")
    void shouldTestTheLastNameField1() {

        lastNameField.setValue("Иванов123");
        nameField.sendKeys(DataGenerator.getName());
        emailField.sendKeys(DataGenerator.getEmail());
        passwordField.sendKeys(DataGenerator.getPassword());
        buttonContinue.click();
        $(byText("Фамилия указана неверно. Допустимы только русские буквы, пробелы и дефисы.")).shouldHave(Condition.visible);

    }

    @Test
    @DisplayName("Ввести данные в поле на латинице.")
    void shouldTestTheLastNameField2() {

        lastNameField.setValue("Ivanov");
        nameField.sendKeys(DataGenerator.getName());
        emailField.sendKeys(DataGenerator.getEmail());
        passwordField.sendKeys(DataGenerator.getPassword());
        buttonContinue.click();
        $(byText("Фамилия указана неверно. Допустимы только русские буквы, пробелы и дефисы.")).shouldHave(Condition.visible);
    }

    @Test
    @DisplayName("Ввести данные в поле на арабице.")
    void shouldTestTheLastNameField3() {

        lastNameField.setValue("الكسندر");
        nameField.sendKeys(DataGenerator.getName());
        emailField.sendKeys(DataGenerator.getEmail());
        passwordField.sendKeys(DataGenerator.getPassword());
        buttonContinue.click();
        $(byText("Фамилия указана неверно. Допустимы только русские буквы, пробелы и дефисы.")).shouldHave(Condition.visible);
    }

    @Test
    @DisplayName("Ввести данные в поле на кириллице в кол-ве 1 символа.")
    void shouldTestTheLastNameField4() {

        lastNameField.setValue("А");
        nameField.sendKeys(DataGenerator.getName());
        emailField.sendKeys(DataGenerator.getEmail());
        passwordField.sendKeys(DataGenerator.getPassword());
        buttonContinue.click();
        $(byText("Фамилия указана неверно. Значение поля не должно быть меньше 2 символов.")).shouldHave(Condition.visible);
    }

    @Test
    @DisplayName("Ввести данные в поле на кириллице в кол-ве 65 символов.")
    void shouldTestTheLastNameField5() {

        lastNameField.setValue("Аййильцикликирмицибайраактазийонкаграманоглувуарвтсдпнуывьстрлфуо");
        nameField.sendKeys(DataGenerator.getName());
        emailField.sendKeys(DataGenerator.getEmail());
        passwordField.sendKeys(DataGenerator.getPassword());
        buttonContinue.click();
        $(byText("Фамилия указана неверно. Значение поля не должно быть больше 64 символов.")).shouldHave(Condition.visible);
    }

    @Test
    @DisplayName("Ввести данные в поле спец. символы.")
    void shouldTestTheLastNameField6() {

        lastNameField.setValue("Ив@!-!Ов");
        nameField.sendKeys(DataGenerator.getName());
        emailField.sendKeys(DataGenerator.getEmail());
        passwordField.sendKeys(DataGenerator.getPassword());
        buttonContinue.click();
        $(byText("Фамилия указана неверно. Допустимы только русские буквы, пробелы и дефисы.")).shouldHave(Condition.visible);
    }


    /*для проверки поля "Имя"*/
    @Test
    @DisplayName("Ввести данные в поле на кириллице + цифры.")
    void shouldTestTheNameField1() {

        lastNameField.sendKeys(DataGenerator.getLastName());
        nameField.setValue("Александр12");
        emailField.sendKeys(DataGenerator.getEmail());
        passwordField.sendKeys(DataGenerator.getPassword());
        buttonContinue.click();
        $(byText("Имя указано неверно. Допустимы только русские буквы, пробелы и дефисы.")).shouldHave(Condition.visible);
    }

    @Test
    @DisplayName("Ввести данные в поле на латинице.")
    void shouldTestTheNameField2() {

        lastNameField.sendKeys(DataGenerator.getLastName());
        nameField.setValue("Ivan");
        emailField.sendKeys(DataGenerator.getEmail());
        passwordField.sendKeys(DataGenerator.getPassword());
        buttonContinue.click();
        $(byText("Имя указано неверно. Допустимы только русские буквы, пробелы и дефисы.")).shouldHave(Condition.visible);
    }

    @Test
    @DisplayName("Ввести данные в поле на арабице.")
    void shouldTestTheNameField3() {

        lastNameField.sendKeys(DataGenerator.getLastName());
        nameField.setValue("الكسندر");
        emailField.sendKeys(DataGenerator.getEmail());
        passwordField.sendKeys(DataGenerator.getPassword());
        buttonContinue.click();
        $(byText("Имя указано неверно. Допустимы только русские буквы, пробелы и дефисы.")).shouldHave(Condition.visible);
    }

    @Test
    @DisplayName("Ввести данные в поле на кириллице в кол-ве 1 символа.")
    void shouldTestTheNameField4() {

        lastNameField.sendKeys(DataGenerator.getLastName());
        nameField.setValue("П");
        emailField.sendKeys(DataGenerator.getEmail());
        passwordField.sendKeys(DataGenerator.getPassword());
        buttonContinue.click();
        $(byText("Имя указано неверно. Значение поля не должно быть меньше 2 символов.")).shouldHave(Condition.visible);
    }

    @Test
    @DisplayName("Ввести данные в поле на кириллице в кол-ве 65 символов.")
    void shouldTestTheNameField5() {

        lastNameField.sendKeys(DataGenerator.getLastName());
        nameField.setValue("Аййильцикликирмицибайраактазийонкаграманоглувуарвтсдпнуывьстрлфуо");
        emailField.sendKeys(DataGenerator.getEmail());
        passwordField.sendKeys(DataGenerator.getPassword());
        buttonContinue.click();
        $(byText("Имя указано неверно. Значение поля не должно быть больше 64 символов.")).shouldHave(Condition.visible);
    }

    @Test
    @DisplayName("Ввести данные в поле спец. символы.")
    void shouldTestTheNameField6() {

        lastNameField.sendKeys(DataGenerator.getLastName());
        nameField.setValue("Кар[]!н@");
        emailField.sendKeys(DataGenerator.getEmail());
        passwordField.sendKeys(DataGenerator.getPassword());
        buttonContinue.click();
        $(byText("Имя указано неверно. Допустимы только русские буквы, пробелы и дефисы.")).shouldHave(Condition.visible);
    }


    /*для проверки поля "E-mail"*/
    @Test
    @DisplayName("Ввести в поле электронный адрес, который состоит полностью их кириллических символов.")
    void shouldTestTheEmailField1() throws InterruptedException {

        lastNameField.sendKeys(DataGenerator.getLastName());
        nameField.sendKeys(DataGenerator.getName());
        emailField.setValue("планетаюпитер@майл.ру");
        passwordField.sendKeys(DataGenerator.getPassword());
        buttonContinue.click();
/*
        $(byText("Часть адреса до символа '@' не должна содержать символ 'п'.")).shouldHave(Condition.visible);
*/
        $(withText("Выберите вашу роль")).shouldHave(Condition.not(Condition.visible));

        // Так как текст нельзя привязать из уведомления браузера об ошибке,
        // то буду использовать проверку но то, что нельзя перейти на следующую страницу.

    }

    @Test
    @DisplayName("Ввести в поле электронный адрес, где имя почтового ящика состоит из двух слов, разъединенным пробелом.")
    void shouldTestTheEmailField2() {

        lastNameField.sendKeys(DataGenerator.getLastName());
        nameField.sendKeys(DataGenerator.getName());
        emailField.setValue("vdnh moskva@gmail.com");
        passwordField.sendKeys(DataGenerator.getPassword());
        buttonContinue.click();
/*
        $(byText("Часть адреса до символа '@' не должна содержать символ ' '.")).shouldHave(Condition.visible);
*/
        $(withText("Выберите вашу роль")).shouldHave(Condition.not(Condition.visible));

        // Так как текст нельзя привязать из уведомления браузера об ошибке,
        // то буду использовать проверку но то, что нельзя перейти на следующую страницу.
    }

    @Test
    @DisplayName("Ввести в поле электронный адрес без имени почтового ящика.")
    void shouldTestTheEmailField3() {

        lastNameField.sendKeys(DataGenerator.getLastName());
        nameField.sendKeys(DataGenerator.getName());
        emailField.setValue("@yandex.ru");
        passwordField.sendKeys(DataGenerator.getPassword());
        buttonContinue.click();
/*
        $(byText("Введите часть адреса до символа '@'. Адрес '@yandex.ru' неполный.")).shouldHave(Condition.visible);
*/
        $(withText("Выберите вашу роль")).shouldHave(Condition.not(Condition.visible));

        // Так как текст нельзя привязать из уведомления браузера об ошибке,
        // то буду использовать проверку но то, что нельзя перейти на следующую страницу.
    }

    @Test
    @DisplayName("Ввести в поле электронный адрес без символа '@'.")
    void shouldTestTheEmailField4() {

        lastNameField.sendKeys(DataGenerator.getLastName());
        nameField.sendKeys(DataGenerator.getName());
        emailField.setValue("fedin.mail.ru");
        passwordField.sendKeys(DataGenerator.getPassword());
        buttonContinue.click();
/*
        $(byText("Адрес электронной почты должен содержать символ '@'. В адресе 'fedin.mail.ru' отсутствует символ '@'.")).shouldHave(Condition.visible);
*/
        $(withText("Выберите вашу роль")).shouldHave(Condition.not(Condition.visible));

        // Так как текст нельзя привязать из уведомления браузера об ошибке,
        // то буду использовать проверку но то, что нельзя перейти на следующую страницу.
    }

    @Test
    @DisplayName("Ввести в поле электронный адрес, где доменное имя без символа '.' .")
    void shouldTestTheEmailField5() {

        lastNameField.sendKeys(DataGenerator.getLastName());
        nameField.sendKeys(DataGenerator.getName());
        emailField.setValue("abracadabra@yandexru");
        passwordField.sendKeys(DataGenerator.getPassword());
        buttonContinue.click();
/*
        $(byText("Часть адреса после символа '@' не должна содержать символ '.'.")).shouldHave(Condition.visible);
*/
        $(withText("Выберите вашу роль")).shouldHave(Condition.not(Condition.visible));

        // Так как текст нельзя привязать из уведомления браузера об ошибке,
        // то буду использовать проверку но то, что нельзя перейти на следующую страницу.
    }


    /*для проверки поля "Пароль"*/
    @Test
    @DisplayName("Ввести в поле пароль, состоящий только из единиц.")
    void shouldTestThePasswordField1() {

        lastNameField.sendKeys(DataGenerator.getLastName());
        nameField.sendKeys(DataGenerator.getName());
        emailField.sendKeys(DataGenerator.getEmail());
        passwordField.setValue("11111111");
        buttonContinue.click();
        $(byText("Пароль указан неверно. Имеются повторяющиеся символы.")).shouldHave(Condition.visible);
    }

    @Test
    @DisplayName("Ввести в поле пароль, содержащий в себе запрещенные спец. символы.")
    void shouldTestThePasswordField2() {

        lastNameField.sendKeys(DataGenerator.getLastName());
        nameField.sendKeys(DataGenerator.getName());
        emailField.sendKeys(DataGenerator.getEmail());
        passwordField.setValue("opt<>12");
        buttonContinue.click();
        $(byText("Пароль указан неверно. Пароль содержит запрещенные символы '<>'.")).shouldHave(Condition.visible);
    }

    @Test
    @DisplayName("Ввести в поле пароль, состоящий из 5 символов.")
    void shouldTestThePasswordField3() {

        lastNameField.sendKeys(DataGenerator.getLastName());
        nameField.sendKeys(DataGenerator.getName());
        emailField.sendKeys(DataGenerator.getEmail());
        passwordField.setValue("PasW!");
        buttonContinue.click();
        $(byText("Слишком короткий пароль.")).shouldHave(Condition.visible);
    }

    @Test
    @DisplayName("Ввести в поле пароль, состоящий из цифр от 1 до 6.")
    void shouldTestThePasswordField4() {

        lastNameField.sendKeys(DataGenerator.getLastName());
        nameField.sendKeys(DataGenerator.getName());
        emailField.sendKeys(DataGenerator.getEmail());
        passwordField.setValue("123456");
        buttonContinue.click();
        $(byText("Недопустимый пароль.")).shouldHave(Condition.visible);
    }


    /*для проверки отправки формы "Регистрация"*/

    @Test
    @DisplayName("Регистрация пользователя с заполненными валидными данными.")
    void shouldTestRegistrationUser() {

        lastNameField.setValue("");
        nameField.setValue("");
        emailField.setValue("");
        passwordField.setValue("");
        buttonContinue.click();
        $(withText("Заполните поле.")).shouldHave(Condition.visible);
    }
}
