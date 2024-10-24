package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class professionalInfoPage extends base{
    public professionalInfoPage(WebDriver driver) {
        super(driver);
    }

    Actions actions = new Actions(driver);
    final public By title= By.xpath("//*[@title=\"Professional Info\"]//h1[2]");
    final protected By experience =By.xpath("//*[@class=\"section-validation-error css-1h480x3 e1v1l3u10\"]//*[@class=\" css-1wy0on6\"]");
    final protected By myExperience =By.xpath("//*[@class=\" css-1tci6j0\"]//div[1]");
    final protected By educationalLevel =By.xpath("//*[@name=\"currentEducationLevel\"]//*[@class=\"css-1dy69p2 eequ2uf0\"][1]");
    final protected By fieldOfStudy =By.xpath("//*[@class=\"css-1a96k50 ek82ord0\"]");
    final protected By university =By.xpath("//*[@class=\"css-1fttcpj e6pv2vl2\"]//*[@class=\"css-10m6313 e6pv2vl3\"]//*[@class=\" css-1hwfws3\"]");

    final protected By degreeYearInput =By.xpath("//*[@class=\"css-1fttcpj e6pv2vl2\"]//*[@class=\"css-vbnqhq e6pv2vl2\"]//*[@class=\" css-1dgicot-container\"]");
    final protected By myDegreeYear =By.xpath("//*[@class=\" css-1tci6j0\"]//div[12]");


    final protected By grade =By.xpath("//*[@class=\"css-1fttcpj e6pv2vl2\"]//*[@class=\"css-1guj1as\"]//*[@class=\" css-zh6qap-control\"]");
    //final protected By myGrade =By.id("react-select-20-option-1");
    final protected By myGrade =By.xpath("//*[@class=\" css-1tci6j0\"]//div[2]");

    final protected By language =By.xpath("//*[@class=\"css-6hend0 e1v1l3u10\"]//*[@class=\"css-911kv1 e6pv2vl0\"][1]//*[@class=\" css-1hwfws3\"]");
    final protected By myLanguage =By.id("react-select-20-option-1");

    final protected By proficiency =By.xpath("//*[@class=\"css-6hend0 e1v1l3u10\"]//*[@class=\"css-911kv1 e6pv2vl0\"][2]//*[@class=\" css-1hwfws3\"]");
    final protected By myProficiency =By.id("react-select-20-option-1");

    final protected By addLanguageButton =By.xpath("//*[@class=\"css-1xrefku e6pv2vl1\"]//button");

    final protected By skillsInput =By.xpath("//*[@class=\"section-validation-error css-6hend0 e1v1l3u10\"]//*[@class=\" css-1hwfws3\"]");

    final protected By getStartedButton =By.xpath("//form//*[@class=\"css-1mez120\"]/button");

    public void insertProfessionalInfo(String study,String uni,String skillOne,String skillTwo) throws InterruptedException {

        click(experience);
        click(myExperience);

        click(educationalLevel);
        sendKeys(fieldOfStudy,study);

        actions.moveToElement(driver.findElement(university)).click().sendKeys(uni).build().perform();

        click(degreeYearInput);
        click(myDegreeYear);


        click(grade);
        click(myGrade);

        click(language);
        arrowDown(language);

        click(proficiency);
        arrowDown(proficiency);
        click(addLanguageButton);

        actions.moveToElement(driver.findElement(skillsInput)).click().sendKeys(skillOne).build().perform();
        click(getStartedButton);
        //actions.moveByOffset(500, 500).click().perform();
        Thread.sleep(5000);
        actions.moveToElement(driver.findElement(skillsInput)).click().sendKeys(skillTwo).build().perform();
        click(getStartedButton);

        click(getStartedButton);

    }

}
