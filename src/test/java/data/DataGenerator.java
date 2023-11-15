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


    @Data
    @AllArgsConstructor
    public static class RegInfo {
        private String lastName;
        private String name;
        private String email;
        private String password;
    }

}
