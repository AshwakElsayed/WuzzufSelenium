package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

public class generalInfoPage extends base{
    public generalInfoPage(WebDriver driver) {
        super(driver);
    }
    final public By title =By.xpath("//*[@title=\"General Info\"]//h1[2]");

    final protected By day =By.xpath("//*[@class=\"col-2-lg col-12\"]//*[@class=\"css-tjx49 efou2fk0\"]");
    final protected By myDay =By.xpath("//*[@class=\" css-1tci6j0\"]//div[24]");

    final protected By month =By.xpath("//*[@class=\"row\"]//*[@class=\"col-3-lg col-12\"][1]//*[@class=\"css-tjx49 efou2fk0\"]");
    final protected By myMonth =By.xpath("//*[@class=\" css-1tci6j0\"]//div[8]");

    final protected By year =By.xpath("//*[@class=\"row\"]//*[@class=\"col-3-lg col-12\"][2]//*[@class=\"css-tjx49 efou2fk0\"]");
    final protected By myYear =By.xpath("//*[@class=\" css-1tci6j0\"]//div[17]");

    final protected By gender =By.xpath("//*[@class=\"css-3pwpkg\"]//label[2]//*[@class=\"css-bhwo3q e1kea1u61\"]");

    final protected By nationality =By.xpath("//form//*[@class=\"section-validation-error css-6hend0 e1v1l3u10\"][1]//*[@class=\"css-rpi6b5 e6pv2vl4\"][2]//*[@class=\" css-1wy0on6\"]");
    final protected By myNationality =By.xpath("//*[@class=\" css-1tci6j0\"]//div[42]");

    final protected By country =By.xpath("//form//*[@class=\"css-rpi6b5 e6pv2vl4\"][1]//*[@class=\" css-1hwfws3\"]");
    final protected By myCountry =By.xpath("//*[@class=\" css-kt4d65-option\"]");

    final protected By city =By.xpath("//form/*[@class=\"section-validation-error css-6hend0 e1v1l3u10\"][1]//*[@class=\"css-rpi6b5 e6pv2vl4\"][2]//*[@class=\" css-1hwfws3\"]");
    final protected By myCity =By.xpath("//*[@class=\" css-1tci6j0\"]//div[6]");

    final protected By area =By.xpath("//form//*[@class=\"css-rpi6b5 e6pv2vl4\"][3]//*[@class=\" css-1hwfws3\"]");
    final protected By myArea =By.xpath("//*[@class=\" css-1tci6j0\"]//div[@class=\" css-szlc4p-option\"][1]");

    final protected By mobileNumber =By.xpath("//*[@name=\"primaryPhone\"]");
    final protected By saveAndContinueButton =By.xpath("//button[@class=\"css-1wj05oe ezfki8j0\"]");

    public void insertGeneralInfo(String phone) throws InterruptedException {
        click(day);
        click(myDay);

        click(month);
        click(myMonth);

        click(year);
        click(myYear);

        click(gender);

        click(nationality);
        click(myNationality);

        click(country);
        click(myCountry);

        click(city);
        click(myCity);

        click(area);
        click(myArea);

        Thread.sleep(3000);
        sendKeys(mobileNumber ,phone);
        click(saveAndContinueButton);
    }
}
