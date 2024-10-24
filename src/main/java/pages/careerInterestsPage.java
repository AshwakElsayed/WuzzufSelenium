package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class careerInterestsPage extends base{
    public careerInterestsPage(WebDriver driver) {
        super(driver);
    }
    final public By title =By.xpath("//*[@class=\"css-1gitm4y\"]//h1[2]");
    final public By level = By.xpath("//*[@name=\"careerLevel\"]//div[2]");
    final public By typeOfJob = By.xpath("//button[@title=\"Full Time\"]/span");
    final public By workplace = By.xpath("//button[@title=\"On-site\"]/span");
    final protected By categories = By.xpath("//*[@class=\"css-1pwt1s8 ediq4wm0\"]//*[@class=\"css-vut953 e1ekn0hm0\"][1]");
    final protected By minimumSalary = By.xpath("//*[@name=\"minimumSalary\"]");
    final protected By saveAndContinueButton = By.xpath("//div[@class=\"css-1mez120\"]//*[@type=\"button\"]");

    public void insertCareerInterestsData(String salary){
        click(level);
        click(typeOfJob);
        click(workplace);
        click(categories);
        sendKeys(minimumSalary,salary);
        click(saveAndContinueButton);
    }

}
