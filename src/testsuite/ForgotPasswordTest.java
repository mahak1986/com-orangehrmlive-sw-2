package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Write down the following test into ‘ForgotPasswordTest’ class
 * 1. userShouldNavigateToForgotPasswordPageSuccessfully
 * * click on the ‘Forgot your password’ link
 * * Verify the text ‘Reset Password’
 */
public class ForgotPasswordTest extends BaseTest {
    String baseUrl = "https://opensource-demo.orangehrmlive.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToForgotPasswordPageSuccessfully(){
        //Clicking on Forgot Password
        driver.findElement(By.xpath("//p[@class='oxd-text oxd-text--p orangehrm-login-forgot-header']")).click();

        //Finding actual text and get text from element
        String expectedText = "Reset Password";
        WebElement actualTextElement = driver.findElement(By.xpath("//button[@type='submit']"));
        String actualText = actualTextElement.getText();
        //Verify expected and actual using Assert
        Assert.assertEquals("Does not display Reset Password", expectedText, actualText);
    }
    @After
    public void setDown() {
        closeBrowser();
    }

}
