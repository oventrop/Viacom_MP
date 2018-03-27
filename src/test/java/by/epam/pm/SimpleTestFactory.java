package by.epam.pm;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;

public class SimpleTestFactory {

    @Factory(dataProvider = "dataProvider")
    public Object[] factoryMethod(String login, String password) {
        return new Object[]{new DependentTests(login, password)};
    }

    @DataProvider
    public Object[][] dataProvider() {
        return new Object[][]{{"test1_login", "test1_pass"}, {"test2_login", "test2_pass"}, {"test3_login", "test3_pass"}};
    }

}
