package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class base {
    protected WebDriver driver;
    protected Faker faker;
    Actions action;
    protected WebDriverWait wait;
    List<WebElement> Elements;

    public base(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }


    // Method to click on webElement or By
    public void click(WebElement element){
        element.click();
    }
    public void click(By by){
        action = new Actions(driver);
        action.moveToElement(driver.findElement(by)).perform();
        driver.findElement(by).click();
    }

    // Method to hover over webElement or By
    public void hover(WebElement element){
        action =new Actions(driver);
        action.moveToElement(element).perform();
    }
    // Method to hover over webElement or By
    public void hoverAndClick(WebElement element,int xOffset,int yOffset){
        action =new Actions(driver);
        action.moveToElement(element, xOffset, yOffset).click().perform();
    }


    public void hover(By by){
        action =new Actions(driver);
        action.moveToElement(driver.findElement(by)).perform();
    }
    ////////////////////////////



    // Method to sendKeys using webElement or By
    public void sendKeys(WebElement element,String text){
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(text);
    }
    public void sendKeys(By by,String text){
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        driver.findElement(by).sendKeys(text);

    }
    //Selection
    // Method to select an option from a dropdown using Visible Text  (WebElement)
    public void selectByVisibleText(WebElement element, String visibleText) {
        Select dropdown = new Select(element);
        dropdown.selectByVisibleText(visibleText);
    }
    // Method to select an option from a dropdown using visible text(By)
    public void selectByVisibleText(By by, String visibleText) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeSelected(by));
        Select dropdown = new Select(driver.findElement(by));
        dropdown.selectByVisibleText(visibleText);
    }
    // Method to select an option from a dropdown using value attribute (WebElement)
    public void selectByValue(WebElement element, String value) {
        Select dropdown = new Select(element);
        dropdown.selectByValue(value);
    }
    // Method to select an option from a dropdown using value attribute (By)
    public void selectByValue(By by, String value) {
        Select dropdown = new Select(driver.findElement(by));
        dropdown.selectByValue(value);
    }

    // Method to select an option from a dropdown using index (WebElement)
    public void selectByIndex(WebElement element, int index) {
        Select dropdown = new Select(element);
        dropdown.selectByIndex(index);
    }
    // Method to select an option from a dropdown using index (By)
    public void selectByIndex(By by, int index) {
        Select dropdown = new Select(driver.findElement(by));
        dropdown.selectByIndex(index);
    }

    //Method for getText using By
    public String getText(By by){
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        return driver.findElement(by).getText();
    }

    // Explicit wait                                                                                                                                          11Q22WWWWWWWWWWW
    public void waitUntilElementBeClickable(By by){
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public void waitUntilElementBeClickable(WebElement element){
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitUntilElementBeVisible(By by){
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    // Method for get css value
    public String getCssValue(By by,String property){
        return driver.findElement(by).getCssValue(property);
    }

    // Method to Return Array
    public List<WebElement> getElements() {
        return Elements;
    }

    // Method To Arrow Down key
    public void arrowDown(By by){
        Actions actions = new Actions(driver);
        actions.sendKeys(driver.findElement(by), Keys.ARROW_DOWN).perform();
        actions.sendKeys(Keys.ENTER).perform();
    }

}
