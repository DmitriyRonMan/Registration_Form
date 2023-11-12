package test;

import com.codeborne.selenide.*;
import com.codeborne.selenide.logevents.SelenideLogger;
import data.DataGenerator;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;


public class NegativeTestForRegistrationForm {

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
    @DisplayName("Ввод данных на кириллице + цифры в поле 'Фамилия'.")
    void shouldTestTheLastNameField1() {

        lastNameField.setValue("Иванов123");
        $(byText("Значение поля фамилия, может содержать только русские буквы")).shouldHave(Condition.visible);


    }

    @Test
    @DisplayName("Ввод данных на латинице в поле 'Фамилия'.")
    void shouldTestTheLastNameField2() {

        lastNameField.setValue("Ivanov");
        $(byText("Значение поля фамилия, может содержать только русские буквы")).shouldHave(Condition.visible);

    }

    @Test
    @DisplayName("Ввод данных на арабице в поле 'Фамилия'.")
    void shouldTestTheLastNameField3() {

        lastNameField.setValue("جينادي");
        $(byText("Значение поля фамилия, может содержать только русские буквы")).shouldHave(Condition.visible);
    }

    @Test
    @DisplayName("Ввод данных в поле 'Фамилия' на кириллице в кол-ве 1 символа.")
    void shouldTestTheLastNameField4() {

        lastNameField.setValue("А");
        $(byText("Значение поля фамилия, должно содержать не меньше 1 буквы и не больше 64 букв")).shouldHave(Condition.visible);
    }

    @Test
    @DisplayName("Ввод данных в поле 'Фамилия' на кириллице в кол-ве 65 символов.")
    void shouldTestTheLastNameField5() {

        lastNameField.setValue("Аййильцикликирмицибайраактазийонкаграманоглувуарвтсдпнуывьстрлфуо");
        $(byText("Значение поля фамилия, должно содержать не меньше 1 буквы и не больше 64 букв")).shouldHave(Condition.visible);
    }

    @Test
    @DisplayName("Ввод данных из спец. символов в поле 'Фамилия'.")
    void shouldTestTheLastNameField6() {

        lastNameField.setValue("Ив@!-!Ов");
        $(byText("Значение поля фамилия, может содержать только русские буквы")).shouldHave(Condition.visible);
    }


    /*для проверки поля "Имя"*/
    @Test
    @DisplayName("Ввод данных на кириллице + цифры в поле 'Имя'.")
    void shouldTestTheNameField1() {

        lastNameField.sendKeys(DataGenerator.getLastName());
        nameField.setValue("Александр12");
        $(byText("Значение поля имя, может содержать только русские буквы")).shouldHave(Condition.visible);
    }

    @Test
    @DisplayName("Ввод данных на латинице в поле 'Имя'.")
    void shouldTestTheNameField2() {

        lastNameField.sendKeys(DataGenerator.getLastName());
        nameField.setValue("Ivan");
        $(byText("Значение поля имя, может содержать только русские буквы")).shouldHave(Condition.visible);
    }

    @Test
    @DisplayName("Ввод данных на арабице в поле 'Имя'.")
    void shouldTestTheNameField3() {

        lastNameField.sendKeys(DataGenerator.getLastName());
        nameField.setValue("الكسندر");
        $(byText("Значение поля имя, может содержать только русские буквы")).shouldHave(Condition.visible);
    }

    @Test
    @DisplayName("Ввод данных в поле 'Имя' на кириллице в кол-ве 1 символа.")
    void shouldTestTheNameField4() {

        lastNameField.sendKeys(DataGenerator.getLastName());
        nameField.setValue("П");
        $(byText("Значение поля имя, должно содержать не меньше 1 буквы и не больше 64 букв")).shouldHave(Condition.visible);
    }

    @Test
    @DisplayName("Ввод данных в поле 'Имя' на кириллице в кол-ве 65 символов.")
    void shouldTestTheNameField5() {

        lastNameField.sendKeys(DataGenerator.getLastName());
        nameField.setValue("Аййильцикликирмицибайраактазийонкаграманоглувуарвтсдпнуывьстрлфуо");
        $(byText("Значение поля имя, должно содержать не меньше 1 буквы и не больше 64 букв")).shouldHave(Condition.visible);
    }

    @Test
    @DisplayName("Ввод данных из спец. символов в поле 'Имя'.")
    void shouldTestTheNameField6() {

        lastNameField.sendKeys(DataGenerator.getLastName());
        nameField.setValue("Кар[]!н@");
        $(byText("Значение поля имя, может содержать только русские буквы")).shouldHave(Condition.visible);
    }


    /*для проверки поля "E-mail"*/
    @Test
    @DisplayName("Ввод данных в поле 'E-mail', которые полностью состоят из кириллицы.")
    void shouldTestTheEmailField1() throws InterruptedException {
        Configuration.holdBrowserOpen = true;

        lastNameField.sendKeys(DataGenerator.getLastName());
        nameField.sendKeys(DataGenerator.getName());
        emailField.setValue("планетаюпитер@майл.ру");
        $(byText("Значение поля email, не соответствует формату почты")).shouldHave(Condition.visible);
    }

    @Test
    @DisplayName("Ввод данных в поле 'E-mail', где имя почтового ящика состоит из двух слов через пробел.")
    void shouldTestTheEmailField2() {

        lastNameField.sendKeys(DataGenerator.getLastName());
        nameField.sendKeys(DataGenerator.getName());
        emailField.setValue("vdnh moskva@gmail.com");
        $(byText("Значение поля email, не соответствует формату почты")).shouldHave(Condition.visible);
    }

    @Test
    @DisplayName("Ввод данных в поле 'E-mail' без имени почтового ящика.")
    void shouldTestTheEmailField3() {

        lastNameField.sendKeys(DataGenerator.getLastName());
        nameField.sendKeys(DataGenerator.getName());
        emailField.setValue("@yandex.ru");
        $(byText("Значение поля email, не соответствует формату почты")).shouldHave(Condition.visible);


    }

    @Test
    @DisplayName("Ввод данных в поле 'E-mail' без символа '@'.")
    void shouldTestTheEmailField4() {

        lastNameField.sendKeys(DataGenerator.getLastName());
        nameField.sendKeys(DataGenerator.getName());
        emailField.setValue("fedin.mail.ru");
        $(byText("Значение поля email, не соответствует формату почты")).shouldHave(Condition.visible);
    }

    @Test
    @DisplayName("Ввод данных в поле 'E-mail', где доменное имя без символа '.' .")
    void shouldTestTheEmailField5() {

        lastNameField.sendKeys(DataGenerator.getLastName());
        nameField.sendKeys(DataGenerator.getName());
        emailField.setValue("abracadabra@yandexru");
        $(byText("Значение поля email, не соответствует формату почты")).shouldHave(Condition.visible);
    }


    /*для проверки поля "Пароль"*/
    @Test
    @DisplayName("Ввод данных в поле 'Пароль', состоящих только из единиц.")
    void shouldTestThePasswordField1() {
        Configuration.holdBrowserOpen = true;


        lastNameField.sendKeys(DataGenerator.getLastName());
        nameField.sendKeys(DataGenerator.getName());
        emailField.sendKeys(DataGenerator.getEmail());
        passwordField.setValue("11111111");
        $(byText("Пароль указан неверно. Имеются повторяющиеся символы")).shouldHave(Condition.visible);
    }

    @Test
    @DisplayName("Ввод данных в поле 'Пароль', содержащее в себе запрещенные спец. символы.")
    void shouldTestThePasswordField2() {

        lastNameField.sendKeys(DataGenerator.getLastName());
        nameField.sendKeys(DataGenerator.getName());
        emailField.sendKeys(DataGenerator.getEmail());
        passwordField.setValue("opt<>12");
        $(byText("Пароль не должен содержать символы «?», «#», «<», «>», «%», «/»")).shouldHave(Condition.visible);
    }

    @Test
    @DisplayName("Ввод данных в поле 'Пароль', состоящих из 5 символов.")
    void shouldTestThePasswordField3() {

        lastNameField.sendKeys(DataGenerator.getLastName());
        nameField.sendKeys(DataGenerator.getName());
        emailField.sendKeys(DataGenerator.getEmail());
        passwordField.setValue("PasW!");
        $(byText("Значение поля пароль, должно содержать не меньше 7 буквы и не больше 64 букв")).shouldHave(Condition.visible);
    }

    @Test
    @DisplayName("Ввод данных в поле 'Пароль', состоящих из цифр от 1 до 7.")
    void shouldTestThePasswordField4() {

        // нужно проверить последовательность символов

        Configuration.holdBrowserOpen = true;

        lastNameField.sendKeys(DataGenerator.getLastName());
        nameField.sendKeys(DataGenerator.getName());
        emailField.sendKeys(DataGenerator.getEmail());
        passwordField.setValue("1234567");
        $(byText("Недопустимый пароль. Пароль слишком простой.")).shouldHave(Condition.visible);
    }

    @Test
    @DisplayName("Ввод данных в поле 'Пароль', состоящих из последовательных символов на латинице.")
    void shouldTestThePasswordField5() {

        Configuration.holdBrowserOpen = true;

        lastNameField.sendKeys(DataGenerator.getLastName());
        nameField.sendKeys(DataGenerator.getName());
        emailField.sendKeys(DataGenerator.getEmail());
        passwordField.setValue("asdfghj");
        $(byText("Недопустимый пароль. Пароль слишком простой.")).shouldHave(Condition.visible);
    }

    /*для проверки отправки формы "Регистрация"*/

    @Test
    @DisplayName("Регистрация пользователя с незаполненными полями.")
    void shouldTestRegistrationUser() {

        lastNameField.setValue("");
        nameField.setValue("");
        emailField.setValue("");
        passwordField.setValue("");
        buttonContinue.shouldBe(Condition.not(Condition.visible));
    }
}
