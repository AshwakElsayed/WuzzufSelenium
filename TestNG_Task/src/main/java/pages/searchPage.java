package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class searchPage extends base{

    public searchPage(WebDriver driver) {
        super(driver);
    }

    final protected By searchInput = By.xpath("//*[@class=\"css-sg52ec e1n2h7jb1\"]");
    final protected By searchButton = By.xpath("//*[@class=\"css-1sn5x2o ezfki8j0\"]");
    final protected By jopTitle = By.xpath("//*[@class=\"css-1gatmva e1v1l3u10\"]//h2/a");
    final public By numberOfSearchResults = By.xpath("//*[@class=\"css-8neukt\"]");

    public void SearchForJobTitle(String jop){
        sendKeys(searchInput,jop);
        click(searchButton);
    }

    public List<WebElement> getAllJobsNames() {
        return driver.findElements(jopTitle);
    }

    public String getJopName(int index) {
        List<WebElement> products = getAllJobsNames();
        return products.get(index).getText();
    }

}
