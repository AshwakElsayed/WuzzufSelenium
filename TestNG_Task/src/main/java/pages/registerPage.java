package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class registerPage extends base {

    public registerPage(WebDriver driver) {
        super(driver);
    }

    //Locators
    final protected By GetStartedButton = By.xpath("//*[@class=\"css-1ith43a eswc9qo0\"]");
    final protected By firstnameInput = By.xpath("//*[@id=\"firstname\"]");
    final protected By lastnameInput = By.xpath("//*[@id=\"lastname\"]");
    final protected By emailInput = By.xpath("//*[@id=\"email\"]");
    final protected By passwordInput = By.xpath("//*[@name=\"password\"]");
    final protected By jobTitleInput = By.xpath("//*[@class=\"css-1itq9hi ek82ord0\"]");
    final protected By createAccountButton = By.xpath("//button[@class=\"css-12g3p01 ezfki8j0\"]");

    //Actions
    public void goToRegisterPage() {
        click(GetStartedButton);
    }

    public void fillFormWithValidData(String fName, String lName, String email, String password,String jop) throws InterruptedException {
        sendKeys(firstnameInput, fName);
        sendKeys(lastnameInput, lName);
        sendKeys(emailInput, email);
        sendKeys(passwordInput, password);
        sendKeys(jobTitleInput,jop);

        waitUntilElementBeClickable(createAccountButton);
        Thread.sleep(3000);
        click(createAccountButton);

        /*int width = driver.findElement(createAccountButton).getSize().getWidth();
        int height = driver.findElement(createAccountButton).getSize().getHeight();
        int xOffset = width / 2;  // Center of the button horizontally
        int yOffset = height / 2;*/
        //hoverAndClick(driver.findElement(createAccountButton), 10, 10);
        //click(createAccountButton);
    }


}
