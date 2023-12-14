package data;

import com.github.javafaker.Faker;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Locale;

public class DataGenerator {
    private static Faker fakerLangRu = new Faker(new Locale("ru"));
    private static Faker fakerLangEn = new Faker(new Locale("en"));

    public static String getLastName() {
        return fakerLangRu.name().lastName();
    }

    public static String getName() {

        return fakerLangRu.name().firstName();
    }

    public static String getEmail() {

        return fakerLangEn.internet().emailAddress();
    }

    public static String getPassword() {

        return fakerLangEn.internet().password();
    }

    public static String getPhone(String phone) {
        return phone;
    }

    public static String getComment(String comment) {
        return comment;
    }

    public static RegInfo getRegValidForm() {

        return new RegInfo(getLastName(), getName(), getEmail(), getPassword());
    }

    public static RegInfo getRegFormPassword(String password) {
        return new RegInfo(getLastName(), getName(), getEmail(), password);
    }

    public static RegInfo getRegFormEmail(String email) {
        return new RegInfo(getLastName(), getName(), email, "");
    }

    public static RegInfo getRegFormName(String name) {
        return new RegInfo(getLastName(), name, "", "");
    }

    public static AuthInfo getAuthFormValid() {
        return new AuthInfo("dimon-9_93@mail.ru", "fdsa5771A!");
    }

    public static AuthInfo getAuthFormNoValidEmail() {
        return new AuthInfo("", "fdsa5771A!");
    }

    public static AuthInfo getAuthFormNoValidPassword() {
        return new AuthInfo("dimon-9_93@mail.ru", "");
    }

    public static AuthInfoPassword getAuthPasswordValidForm() {
        return new AuthInfoPassword("dmitriykolesnikov7@gmail.com");
    }

    public static AuthInfoPassword getAuthPasswordNotValidForm() {
        return new AuthInfoPassword("notAutorization@gmail.com");
    }

    public static ContactForm getContactFormValid() {
        return new ContactForm(getName(), getPhone("9886473623"), getEmail(), getComment(""));
    }

    @Data
    @AllArgsConstructor
    public static class RegInfo {
        private String lastName;
        private String name;
        private String email;
        private String password;
    }

    @Data
    @AllArgsConstructor
    public static class AuthInfo {
        private String emailAuth;
        private String passwordAuth;
    }

    @Data
    @AllArgsConstructor
    public static class AuthInfoPassword {
        private String emailAuthPassword;
    }

    @Data
    @AllArgsConstructor
    public static class ContactForm {
        private String name;
        private String phone;
        private String email;
        private String comment;
    }

}
