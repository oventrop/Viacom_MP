package by.epam.pm;

import org.openqa.selenium.interactions.SourceType;
import org.testng.*;

public class Listener implements ITestListener, ISuiteListener {

    public void onStart(ISuite suite) {
        System.out.println("Suite " + suite.getName() + " started!");
    }

    public void onFinish(ISuite suite) {
        System.out.println("Suite " + suite.getName() + " finished!");
    }

    public void onTestStart(ITestResult result) {
        System.out.println("Test " + result.getTestClass().getName() + " " + result.getName() + " started!");
    }

    public void onTestSuccess(ITestResult result) {
        System.out.println("Test " + result.getTestClass().getName() + " sucsessfully finished!");
    }

    public void onTestFailure(ITestResult result) {

    }

    public void onTestSkipped(ITestResult result) {

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    public void onStart(ITestContext context) {
        System.out.println("SuiteTest " + context.getName() + " started!");
    }

    public void onFinish(ITestContext context) {
        System.out.println("SuiteTest " + context.getName() + " finished!");
    }
}
