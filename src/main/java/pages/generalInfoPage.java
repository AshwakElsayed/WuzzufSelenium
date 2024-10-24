package pages;

import org.openqa.selenium.*;

public class generalInfoPage extends base {
    public generalInfoPage(WebDriver driver) {
        super(driver);
    }

    final public By generalTitle = By.xpath("//*[@class=\"css-1gitm4y\"]//h1[2]");

    final protected By day = By.xpath("//*[@class=\"col-2-lg col-12\"]//*[@class=\"css-tjx49 efou2fk0\"]");
    final protected By allDays = By.xpath("//*[@class=\" css-1tci6j0\"]//div");


    final protected By month = By.xpath("//*[@class=\"row\"]//*[@class=\"col-3-lg col-12\"][1]//*[@class=\"css-tjx49 efou2fk0\"]");
    final protected By allMonths = By.xpath("//*[@class=\" css-1tci6j0\"]//div");

    final protected By year = By.xpath("//*[@class=\"row\"]//*[@class=\"col-3-lg col-12\"][2]//*[@class=\"css-tjx49 efou2fk0\"]");
    final protected By allYear = By.xpath("//*[@class=\" css-1tci6j0\"]//div");

    final protected By nationality = By.xpath("//form//*[@class=\"section-validation-error css-6hend0 e1v1l3u10\"][1]//*[@class=\"css-rpi6b5 e6pv2vl4\"][2]//*[@class=\" css-1wy0on6\"]");
    final protected By allNationalities = By.xpath("//*[@class=\" css-1tci6j0\"]//div");

    final protected By country = By.xpath("//form//*[@class=\"css-rpi6b5 e6pv2vl4\"][1]//*[@class=\" css-1hwfws3\"]");
    final protected By myCountry = By.xpath("//*[@class=\" css-kt4d65-option\"]");

    final protected By city = By.xpath("//form/*[@class=\"section-validation-error css-6hend0 e1v1l3u10\"][1]//*[@class=\"css-rpi6b5 e6pv2vl4\"][2]//*[@class=\" css-1hwfws3\"]");
    final protected By allCities = By.xpath("//*[@class=\" css-1tci6j0\"]//div");

    final protected By area = By.xpath("//form//*[@class=\"css-rpi6b5 e6pv2vl4\"][3]//*[@class=\" css-1hwfws3\"]");
    final protected By allAreas = By.xpath("//form//*[@class=\"css-rpi6b5 e6pv2vl4\"][3]//*[@class=\" css-11r7ebr-menu\"]//div");

    final protected By mobileNumber = By.xpath("//*[@name=\"primaryPhone\"]");
    final protected By saveAndContinueButton = By.xpath("//button[@class=\"css-1wj05oe ezfki8j0\"]");

    public int getDaysNumber(){
        click(day);
        return driver.findElements(allDays).size();
    }
    public void selectDay(int dayIndex){
        WebElement selectedDay=driver.findElement(By.xpath("//*[@class=\" css-1tci6j0\"]//div["+dayIndex+"]"));
        click(selectedDay);
    }
    public int getMonthsNumber(){
        click(month);
        return driver.findElements(allMonths).size();
    }
    public void selectMonth(int monthIndex){
        WebElement selectedMonth=driver.findElement(By.xpath("//*[@class=\" css-1tci6j0\"]//div["+monthIndex+"]"));
        click(selectedMonth);
    }
    public int getYearsNumber(){
        click(year);
        return driver.findElements(allYear).size();
    }
    public void selectYear(int yearIndex){
        WebElement selectedYear=driver.findElement(By.xpath("//*[@class=\" css-1tci6j0\"]//div["+yearIndex+"]"));
        click(selectedYear);
    }
    public void selectRandomGender(int genderId){
        By gender = By.xpath("//*[@class=\"css-3pwpkg\"]//label["+genderId+"]//*[@class=\"css-bhwo3q e1kea1u61\"]");
        click(gender);
    }
    public int getNationalityNumber(){
        click(nationality);
        return driver.findElements(allNationalities).size();
    }
    public void selectRandomNationality(int Nationalities){
        By selectedNationality = By.xpath("//*[@class=\" css-1tci6j0\"]//div["+Nationalities+"]");
        click(selectedNationality);
        click(country);
        click(myCountry);
    }
    public int getCitiesNumber(){
        click(city);
        return driver.findElements(allCities).size();
    }
    public void selectRandomCity(int Cities){
        By selectedCity = By.xpath("//*[@class=\" css-1tci6j0\"]//div["+Cities+"]");
        click(selectedCity);
    }

    public int getAreasNumber(){
        click(area);
        return driver.findElements(allAreas).size();
    }
    public void selectRandomArea(int Areas) throws InterruptedException {
        By selectedArea = By.xpath("//form//*[@class=\"css-rpi6b5 e6pv2vl4\"][3]//*[@class=\" css-11r7ebr-menu\"]//div["+Areas+"]");
        Thread.sleep(2000);
        click(selectedArea);
    }

    public void insertMobileNumber(String phone)  {
        sendKeys(mobileNumber, phone);
        click(saveAndContinueButton);
    }
}
