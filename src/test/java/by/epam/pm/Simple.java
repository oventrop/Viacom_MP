package by.epam.pm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Simple {

	WebDriver driver;
private final static String GIT_URL = "https://github.com/";
	@BeforeClass(description = "Start execution")
	public void startRemoteTest() {
		System.setProperty("webdriver.gecko.driver", "D:\\DATA\\geckodriver.exe");
		FirefoxOptions options = new FirefoxOptions();
		options.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
		driver = new FirefoxDriver(options);
	}

	@Test(description = "open GitHub page")
	public void openGitHub() {
		driver.get("https://github.com/");
		driver.manage().window().maximize();
		System.out.println(driver.getCurrentUrl());
		Assert.assertTrue(driver.getCurrentUrl().equals(GIT_URL), "You opened not a GitHub page!");
	}

	@AfterClass(description = "Close browser")
	public void closeBrowser() {
		driver.quit();
	}

}
