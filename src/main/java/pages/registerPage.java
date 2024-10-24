package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class registerPage extends base {

    public registerPage(WebDriver driver) {
        super(driver);
    }

    //Locators
    final public By GetStartedButton = By.xpath("//*[@class=\"css-1ith43a eswc9qo0\"]");
    final public By wuzzufLogo = By.xpath("//*[@aria-labelledby=\"wuzzuf-logo\"]");
    final public By signUpWithGoogle =By.xpath("//*[@class=\"css-hyxd5q e86l8mw3\"]");
    final protected By firstnameInput = By.xpath("//*[@id=\"firstname\"]");
    final protected By lastnameInput = By.xpath("//*[@id=\"lastname\"]");
    final protected By emailInput = By.xpath("//*[@id=\"email\"]");
    final protected By passwordInput = By.xpath("//*[@name=\"password\"]");
    final protected By jobTitleInput = By.xpath("//*[@class=\"css-1itq9hi ek82ord0\"]");
    final public By createAccountButton = By.xpath("//button[@class=\"css-12g3p01 ezfki8j0\"]");

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

    }


}
