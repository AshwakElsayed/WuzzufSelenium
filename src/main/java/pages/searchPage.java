package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class searchPage extends base{

    public searchPage(WebDriver driver) {
        super(driver);
    }

    //final public By searchTitle =By.xpath("//h1[@class=\"css-ob2buj\"]");
    final protected By searchInput = By.xpath("//*[@class=\"css-150a24d\"]//input");
    final protected By searchButton = By.xpath("//*[@class=\"css-1sn5x2o ezfki8j0\"]");
    final protected By jopTitle = By.xpath("//*[@class=\"css-1gatmva e1v1l3u10\"]//h2/a");
    final public By numberOfSearchResults = By.xpath("//*[@class=\"css-8neukt\"]");
    final public By dataPostedIcon = By.xpath("//*[@class=\"css-18uqayh\"]//i");
    final public By pastWeekIcon = By.xpath("//*[@class=\"css-ala0zs\"]/div[3]//div");
    final public By firstJop = By.xpath("//*[@id=\"app\"]/div/div[3]/div/div/div[2]/div[1]/div/div[1]/h2/a");
    final public By saveJop = By.xpath("//*[@class=\"css-1ur9mvu\"]//*[@class=\"css-15mwhtj\"][1]/button");
    final public By applyForJop = By.xpath("//*[@class=\"css-1m0yk35 ezfki8j0\"]");
    final public By applyLater = By.xpath("//form[@autocomplete=\"off\"]//button[@class=\"css-17magmd ezfki8j0\"]");
    final public By deleteDraft = By.xpath("//button[@class=\"css-yzt1id ezfki8j0\"]");
    final protected By saveUi =By.xpath("//*[@id=\"header-nav\"]//li[2]/a");

    final protected By profileIcon =By.xpath("//*[@class=\"css-7tg4dk\"]/div/div");
    final protected By logOutIcon =By.xpath("//*[@class=\"css-123hd9o epb9wcb2\"][10]//span");

    public void SearchForJobTitle(String jop) throws InterruptedException {
        Thread.sleep(2000);//
        sendKeys(searchInput,jop);
        Thread.sleep(2000);//
        click(searchButton);
    }

    public List<WebElement> getAllJobsNames() {
        return driver.findElements(jopTitle);
    }

    public String getJopName(int index) {
        List<WebElement> products = getAllJobsNames();
        return products.get(index).getText();
    }
    public void ApplyForJop() throws InterruptedException {
        Thread.sleep(2000);//
        click(dataPostedIcon);
        Thread.sleep(2000);//
        click(pastWeekIcon);
        Thread.sleep(2000);//
        click(firstJop);
    }
    public void saveJop() throws InterruptedException {
        Thread.sleep(2000);//
        click(applyForJop);
        Thread.sleep(2000);//
        click(applyLater);
        Thread.sleep(2000);//
        click(deleteDraft);
        //click(saveJop);
        //click(saveUi);
    }
    public void goToProfileDetails() throws InterruptedException {
        Thread.sleep(2000);//
        click(profileIcon);
        Thread.sleep(2000);//
        click(logOutIcon);
    }


}
