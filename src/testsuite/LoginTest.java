package testsuite;
/**
 * 2. Create the package ‘testsuite’ and create the following classes inside the ‘testsuite’ package.
 * 1. LoginTest
 * 2. ForgotPasswordTest
 * Write down the following test into ‘LoginTest’ class
 * 1. userSholdLoginSuccessfullyWithValidCredentials
 * * Enter “Admin” username
 * * Enter “admin123 password
 * * Click on ‘LOGIN’ button
 * * Verify the ‘Dashboard’ text is display
 */

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = "https://opensource-demo.orangehrmlive.com/";
    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){
        //Enter "Admin" Username
        driver.findElement(By.name("username")).sendKeys("Admin");
        //Enter password - admin123
        driver.findElement(By.name("password")).sendKeys("admin123");
       //Click on login button
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        //Finding actual text and get text from element
        String expectedText = "Dashboard";
        WebElement actualTextElement = driver.findElement(By.xpath("//span[@class='oxd-topbar-header-breadcrumb']"));
        String actualText = actualTextElement.getText();
        //Verify expected and actual using Assert
        Assert.assertEquals("Does not display Dashboard", expectedText, actualText);
    }

    @After
    public void setDown() {
        closeBrowser();
    }
}
