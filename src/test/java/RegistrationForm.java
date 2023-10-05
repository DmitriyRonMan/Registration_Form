import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;


public class RegistrationForm {

    @BeforeAll
    static void setUp() {
        open("https://tms.biacorp.ru/");
        $$("button").find(Condition.text("Зарегистрироваться")).click();
    }


    /*для проверки поля "Фамилия"*/
    @Test
    @DisplayName("Ввести данные в поле на кириллице в диапазоне от 3 до 60 символов.")
    void shouldTestTheLastNameField1() {
        Configuration.holdBrowserOpen = true;
        $("[name=\"name\"]").setValue("Иванов");
    }

    @Test
    @DisplayName("Ввести данные в поле на кириллице в кол-ве 2 символов.")
    void shouldTestTheLastNameField2() {
        Configuration.holdBrowserOpen = true;
        $("[name=\"name\"]").setValue("Ян");
    }

    @Test
    @DisplayName("Ввести данные в поле на кириллице в кол-ве 64 символов.")
    void shouldTestTheLastNameField3() {
        Configuration.holdBrowserOpen = true;
        $("[name=\"name\"]").setValue("Аййильцикликирмицибайрактазийонкаграманоглувуарвтсдпнуывьстрлфуо");
    }

    @Test
    @DisplayName("Ввести данные в поле на кириллице, содержащие букву 'ё'.")
    void shouldTestTheLastNameField4() {
        Configuration.holdBrowserOpen = true;
        $("[name=\"name\"]").setValue("Алёхин");
    }

    @Test
    @DisplayName("Ввести данные в поле на кириллице через дефис.")
    void shouldTestTheLastNameField5() {
        Configuration.holdBrowserOpen = true;
        $("[name=\"name\"]").setValue("Римский - Корсаков");
    }

    @Test
    @DisplayName("Ввести данные в поле на кириллице, содержащий пробел.")
    void shouldTestTheLastNameField6() {
        Configuration.holdBrowserOpen = true;
        $("[name=\"name\"]").setValue("Дэвис Джексон");
    }


    /*для проверки поля "Имя"*/
    @Test
    @DisplayName("Ввести данные в поле на кириллице в диапазоне от 3 до 60 символов.")
    void shouldTestTheNameField1() {
        Configuration.holdBrowserOpen = true;
        $("[name=\"surname\"]").setValue("Александр");
    }

    @Test
    @DisplayName("Ввести данные в поле на кириллице в кол-ве 2 символов.")
    void shouldTestTheNameField2() {
        Configuration.holdBrowserOpen = true;
        $("[name=\"surname\"]").setValue("Ки");
    }

    @Test
    @DisplayName("Ввести данные в поле на кириллице в кол-ве 64 символов.")
    void shouldTestTheNameField3() {
        Configuration.holdBrowserOpen = true;
        $("[name=\"surname\"]").setValue("Аййильцикликирмицибайрактазийонкаграманоглувуарвтсдпнуывьстрлфуо");
    }

    @Test
    @DisplayName("Ввести данные в поле на кириллице, содержащие букву 'ё'.")
    void shouldTestTheNameField4() {
        Configuration.holdBrowserOpen = true;
        $("[name=\"surname\"]").setValue("Пётр");
    }

    @Test
    @DisplayName("Ввести данные в поле на кириллице через дефис.")
    void shouldTestTheNameField5() {
        Configuration.holdBrowserOpen = true;
        $("[name=\"surname\"]").setValue("Жак-Ив");
    }

    @Test
    @DisplayName("Ввести данные в поле на кириллице, содержащий пробел.")
    void shouldTestTheNameField6() {
        Configuration.holdBrowserOpen = true;
        $("[name=\"surname\"]").setValue("Каролина Елена");
    }


    /*для проверки поля "E-mail"*/
    @Test
    @DisplayName("Ввести данные в поле на латинице, содержащие в себе цифры.")
    void shouldTestTheEmailField1() {
        Configuration.holdBrowserOpen = true;
        $("[name=\"email\"]").setValue("vladivostok2000@rbk.ru");
    }

    @Test
    @DisplayName("Ввести данные в поле на латинице, где имя почтового ящика состоит из 2 символов.")
    void shouldTestTheEmailField2() {
        Configuration.holdBrowserOpen = true;
        $("[name=\"email\"]").setValue("np@mail.ru");
    }

    @Test
    @DisplayName("Ввести данные в поле на латинице, содержащие в себе дефис.")
    void shouldTestTheEmailField3() {
        Configuration.holdBrowserOpen = true;
        $("[name=\"email\"]").setValue("gagarin-space@yandex.ru");
    }

    @Test
    @DisplayName("Ввести данные в поле на латинице, где адрес электронной почты полностью в верхнем регистре.")
    void shouldTestTheEmailField4() {
        Configuration.holdBrowserOpen = true;
        $("[name=\"email\"]").setValue("HOME@YAHOO.COM");
    }

    @Test
    @DisplayName("Ввести данные в поле на латинице, где имя электронной почты полностью в верхнем регистре.")
    void shouldTestTheEmailField5() {
        Configuration.holdBrowserOpen = true;
        $("[name=\"email\"]").setValue("HOME@yahoo.com");
    }

    @Test
    @DisplayName("Ввести данные в поле на латинице, содержащие в себе '.' .")
    void shouldTestTheEmailField6() {
        Configuration.holdBrowserOpen = true;
        $("[name=\"email\"]").setValue("dog.cat@gmail.com");
    }


    /*для проверки поля "Пароль"*/
    @Test
    @DisplayName("Ввести данные в поле на латинице, содержащие в себе: цифры, спец. символы, верх. и ниж. регистр.")
    void shouldTestThePasswordField1() {
        Configuration.holdBrowserOpen = true;
        $("[name=\"password\"]").setValue("PasswOrd19!");
    }

    @Test
    @DisplayName("Ввести данные в поле на кириллице, содержащие в себе: цифры, спец. символы, верх. и ниж. регистр.")
    void shouldTestThePasswordField2() {
        Configuration.holdBrowserOpen = true;
        $("[name=\"password\"]").setValue("арТиК@12!");
    }


    /*для проверки перехода на форму "Вход"*/
    @Test
    @DisplayName("Проверка перехода на форму 'Вход' по кнопке 'Вход'.")
    void shouldTestTheButton() {
        Configuration.holdBrowserOpen = true;
        $("[type=\"button\"].css-jq7zez").click();
        $$("h2").find(Condition.text("Вход")).shouldHave(Condition.text("Вход"));
    }


    /*для проверки отправки формы "Регистрация"*/
    @Test
    @DisplayName("Регистрация пользователя с пустыми полями.")
    void shouldTestRegistrationUser() {
        Configuration.holdBrowserOpen = true;
        $("[name=\"name\"]").setValue("Иванов");
        $("[name=\"surname\"]").setValue("Иван");
        $("[name=\"email\"]").setValue("primer@mailto.plus");
        $("[name=\"password\"]").setValue("PasswOrd19!");
        $("[type=\"submit\"]").click();
        $(withText("Выберите вашу роль")).shouldHave(Condition.visible);
    }







}
