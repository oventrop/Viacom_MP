package by.epam.pm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DependentTests {

    WebDriver driver;

    private static final String LOGIN_FIELD = "login_field";
    private static final String PASSWORD_FIELD = "password";
    private final static String GIT_URL = "https://github.com/";
    String login;
    String password;

    public DependentTests(String login, String password) {
        this.login = login;
        this.password = password;
    }

    @BeforeClass(description = "Start execution")
    public void startTest() {
        System.setProperty("webdriver.gecko.driver", "D:\\DATA\\geckodriver.exe");
        FirefoxOptions options = new FirefoxOptions();
        options.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
        driver = new FirefoxDriver(options);
    }

    @Test(description = "open GitHub page")
    public void openGitHub() {
        driver.get(GIT_URL);
        driver.manage().window().maximize();
        Assert.assertTrue(driver.getCurrentUrl().equals(GIT_URL), "You opened not a GitHub page!");
    }

    @Test(dependsOnMethods = "openGitHub")
    public void goToLoginPage() {
        WebElement signInButton = driver.findElement(By.xpath("//*[text()='Sign in']"));
        signInButton.click();
    }

    @Test(dependsOnMethods = "goToLoginPage")
    public void enterLogin() {
        WebElement loginField = driver.findElement(By.id(LOGIN_FIELD));
        WebElement passwordField = driver.findElement(By.id(PASSWORD_FIELD));
        WebElement submitButton = driver.findElement(By.xpath("//*[@name = 'commit']"));

        loginField.click();
        loginField.clear();
        loginField.sendKeys(login);

        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys(password);

        submitButton.click();

        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='container']")).isDisplayed());
    }


    @AfterClass(description = "Close browser")
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }


}
