import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class NegativeTestForRegistrationForm {

    @BeforeAll
    static void setUp() {
        open("https://tms.biacorp.ru/");
        $$("button").find(Condition.text("Зарегистрироваться")).click();
    }

    /*для проверки поля "Фамилия"*/
    @Test
    @DisplayName("Ввести данные в поле на кириллице + цифры.")
    void shouldTestTheLastNameField1() {
        Configuration.holdBrowserOpen = true;
        $("[name=\"name\"]").setValue("Иванов123");
    }

    @Test
    @DisplayName("Ввести данные в поле на латинице.")
    void shouldTestTheLastNameField2() {
        Configuration.holdBrowserOpen = true;
        $("[name=\"name\"]").setValue("Ivanov");
    }

    @Test
    @DisplayName("Ввести данные в поле на арабице.")
    void shouldTestTheLastNameField3() {
        Configuration.holdBrowserOpen = true;
        $("[name=\"name\"]").setValue("الكسندر");
    }

    @Test
    @DisplayName("Ввести данные в поле на кириллице в кол-ве 1 символа.")
    void shouldTestTheLastNameField4() {
        Configuration.holdBrowserOpen = true;
        $("[name=\"name\"]").setValue("А");
    }

    @Test
    @DisplayName("Ввести данные в поле на кириллице в кол-ве 65 символов.")
    void shouldTestTheLastNameField5() {
        Configuration.holdBrowserOpen = true;
        $("[name=\"name\"]").setValue("Аййильцикликирмицибайраактазийонкаграманоглувуарвтсдпнуывьстрлфуо");
    }

    @Test
    @DisplayName("Ввести данные в поле спец. символы.")
    void shouldTestTheLastNameField6() {
        Configuration.holdBrowserOpen = true;
        $("[name=\"name\"]").setValue("Ив@!-!Ов");
    }


    /*для проверки поля "Имя"*/
    @Test
    @DisplayName("Ввести данные в поле на кириллице + цифры.")
    void shouldTestTheNameField1() {
        Configuration.holdBrowserOpen = true;
        $("[name=\"surname\"]").setValue("Александр12");
    }

    @Test
    @DisplayName("Ввести данные в поле на латинице.")
    void shouldTestTheNameField2() {
        Configuration.holdBrowserOpen = true;
        $("[name=\"surname\"]").setValue("Ivan");
    }

    @Test
    @DisplayName("Ввести данные в поле на арабице.")
    void shouldTestTheNameField3() {
        Configuration.holdBrowserOpen = true;
        $("[name=\"surname\"]").setValue("الكسندر");
    }

    @Test
    @DisplayName("Ввести данные в поле на кириллице в кол-ве 1 символа.")
    void shouldTestTheNameField4() {
        Configuration.holdBrowserOpen = true;
        $("[name=\"surname\"]").setValue("П");
    }

    @Test
    @DisplayName("Ввести данные в поле на кириллице в кол-ве 65 символов.")
    void shouldTestTheNameField5() {
        Configuration.holdBrowserOpen = true;
        $("[name=\"surname\"]").setValue("Аййильцикликирмицибайраактазийонкаграманоглувуарвтсдпнуывьстрлфуо");
    }

    @Test
    @DisplayName("Ввести данные в поле спец. символы.")
    void shouldTestTheNameField6() {
        Configuration.holdBrowserOpen = true;
        $("[name=\"surname\"]").setValue("Кар[]!н@");
    }


    /*для проверки поля "E-mail"*/
    @Test
    @DisplayName("Ввести в поле электронный адрес, который состоит полностью их кириллических символов.")
    void shouldTestTheEmailField1() {
        Configuration.holdBrowserOpen = true;
        $("[name=\"email\"]").setValue("планетаюпитер@майл.ру");
    }

    @Test
    @DisplayName("Ввести в поле электронный адрес, где имя почтового ящика состоит из двух слов, разъединенным пробелом.")
    void shouldTestTheEmailField2() {
        Configuration.holdBrowserOpen = true;
        $("[name=\"email\"]").setValue("vdnh moskva@gmail.com");
    }

    @Test
    @DisplayName("Ввести в поле электронный адрес без имени почтового ящика.")
    void shouldTestTheEmailField3() {
        Configuration.holdBrowserOpen = true;
        $("[name=\"email\"]").setValue("@yandex.ru");
    }

    @Test
    @DisplayName("Ввести в поле электронный адрес без символа '@'.")
    void shouldTestTheEmailField4() {
        Configuration.holdBrowserOpen = true;
        $("[name=\"email\"]").setValue("fedin.mail.ru");
    }

    @Test
    @DisplayName("Ввести в поле электронный адрес, где доменное имя без символа '.' .")
    void shouldTestTheEmailField5() {
        Configuration.holdBrowserOpen = true;
        $("[name=\"email\"]").setValue("abracadabra@yandexru");
    }


    /*для проверки поля "Пароль"*/
    @Test
    @DisplayName("Ввести в поле пароль, состоящий только из единиц.")
    void shouldTestThePasswordField1() {
        Configuration.holdBrowserOpen = true;
        $("[name=\"password\"]").setValue("11111111");
    }

    @Test
    @DisplayName("Ввести в поле пароль, содержащий в себе запрещенные спец. символы.")
    void shouldTestThePasswordField2() {
        Configuration.holdBrowserOpen = true;
        $("[name=\"password\"]").setValue("opt<>12");
    }

    @Test
    @DisplayName("Ввести в поле пароль, состоящий из 5 символов.")
    void shouldTestThePasswordField3() {
        Configuration.holdBrowserOpen = true;
        $("[name=\"password\"]").setValue("PasW!");
    }

    @Test
    @DisplayName("Ввести в поле пароль, состоящий из цифр от 1 до 6.")
    void shouldTestThePasswordField4() {
        Configuration.holdBrowserOpen = true;
        $("[name=\"password\"]").setValue("123456");
    }


    /*для проверки отправки формы "Регистрация"*/

    @Test
    @DisplayName("Регистрация пользователя с заполненными валидными данными.")
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
