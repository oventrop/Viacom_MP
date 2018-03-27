package by.epam.pm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.TestNG;
import org.testng.xml.Parser;
import org.testng.xml.XmlSuite;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Main {

    public static void main(String[] args) throws IOException {

//		XmlSuite suite = (XmlSuite) new Parser("testng.xml").parse();
//
//		List<XmlSuite> suites = new ArrayList<XmlSuite>();
//		suites.add(suite);
//		TestNG tng = new TestNG();
//		tng.setXmlSuites(suites);
//		tng.run();


        System.out.println("HelloWorld!");
    }

}
