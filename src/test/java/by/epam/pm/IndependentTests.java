package by.epam.pm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.*;

public class IndependentTests {

    WebDriver driver;

    private final static String GIT_URL = "https://github.com/";
    private final static String MAIL_URL = "https://mail.ru/";

    @BeforeMethod(description = "Start execution", groups = {"independentTests1","independentTests2"})
    public void startTest() {
        System.setProperty("webdriver.gecko.driver", "D:\\DATA\\geckodriver.exe");
        FirefoxOptions options = new FirefoxOptions();
        options.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
        driver = new FirefoxDriver(options);
    }

    @Test(description = "open GitHub page", groups = "independentTests2", alwaysRun = true)
    public void openGitHub() {
        driver.get(GIT_URL);
        Assert.assertTrue(driver.getCurrentUrl().equals(GIT_URL), "You opened not a GitHub page!");
    }

    @Test(description = "open MailRu page", groups = "independentTests2", alwaysRun = true)
    public void openMailRu() {
        driver.get(MAIL_URL);
        Assert.assertTrue(driver.getCurrentUrl().equals(MAIL_URL), "You opened not a MailRu page!");
    }

    @Parameters({"URL"})
    @Test(description = "parameterized", groups = "independentTests1", alwaysRun = true)
    public void parameterisedTest(String URL) throws InterruptedException {
        driver.get(URL);
        System.out.println(driver.getCurrentUrl());
        Assert.assertTrue(driver.getCurrentUrl().equals(URL), "You opened not a " + URL + " page!");
    }

    @AfterMethod(description = "Close browser", groups = {"independentTests1","independentTests2"})
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }
}
