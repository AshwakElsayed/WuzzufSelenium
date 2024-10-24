package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class professionalInfoPage extends base{
    public professionalInfoPage(WebDriver driver) {
        super(driver);
    }

    Actions actions = new Actions(driver);
    final public By professionalTitle= By.xpath("//*[@class=\"css-1gitm4y\"]//h1[2]");

    final protected By experience =By.xpath("//*[@class=\"section-validation-error css-1h480x3 e1v1l3u10\"]//*[@class=\" css-1wy0on6\"]");
    final protected By myExperience =By.xpath("//*[@class=\" css-1tci6j0\"]//div[1]");

    final protected By educationalLevel =By.xpath("//*[@name=\"currentEducationLevel\"]//*[@class=\"css-1dy69p2 eequ2uf0\"][1]");
    final protected By fieldOfStudy =By.xpath("//*[@class=\"css-1a96k50 ek82ord0\"]");
    final protected By university =By.xpath("//*[@class=\"css-1fttcpj e6pv2vl2\"]//*[@class=\"css-10m6313 e6pv2vl3\"]//*[@class=\" css-1hwfws3\"]");

    final protected By degreeYearInput =By.xpath("//*[@class=\"css-1fttcpj e6pv2vl2\"]//*[@class=\"css-vbnqhq e6pv2vl2\"]//*[@class=\" css-1dgicot-container\"]");
    final protected By allDegrees =By.xpath("//*[@class=\" css-1tci6j0\"]//div");


    final protected By grade =By.xpath("//*[@class=\"css-1fttcpj e6pv2vl2\"]//*[@class=\"css-1guj1as\"]//*[@class=\" css-zh6qap-control\"]");
    final protected By allGrades =By.xpath("//*[@class=\" css-1tci6j0\"]//div");

    final protected By language =By.xpath("//*[@class=\"css-6hend0 e1v1l3u10\"]//*[@class=\"css-911kv1 e6pv2vl0\"][1]//*[@class=\" css-1hwfws3\"]");
    final protected By allLanguages =By.xpath("//*[@class=\" css-1tci6j0\"]//div");

    final protected By proficiency =By.xpath("//*[@class=\"css-6hend0 e1v1l3u10\"]//*[@class=\"css-911kv1 e6pv2vl0\"][2]//*[@class=\" css-1hwfws3\"]");
    final protected By allProficiencies =By.xpath("//*[@class=\" css-1tci6j0\"]//div");

    final public By addLanguageButton =By.xpath("//*[@class=\"css-1xrefku e6pv2vl1\"]//button");

    final protected By skillsInput =By.xpath("//*[@class=\"section-validation-error css-6hend0 e1v1l3u10\"]//*[@class=\" css-1hwfws3\"]");

    final protected By getStartedButton =By.xpath("//form//*[@class=\"css-1mez120\"]/button");


    public void insertProfessionalInfoPartOne(String study,String uni) throws InterruptedException {

        click(experience);
        click(myExperience);

        click(educationalLevel);
        sendKeys(fieldOfStudy,study);

        actions.moveToElement(driver.findElement(university)).click().sendKeys(uni).build().perform();

    }
    public int getDegreesNumber(){
        click(degreeYearInput);
        return driver.findElements(allDegrees).size();
    }
    public void selectDegree(int degreeIndex){
        By selectedDegree =By.xpath("//*[@class=\" css-1tci6j0\"]//div["+degreeIndex+"]");
        click(selectedDegree);
    }

    public int getGradesNumber(){
        click(grade);
        return driver.findElements(allGrades).size();
    }
    public void selectGrade(int gradeIndex){
        By selectedGrade =By.xpath("//*[@class=\" css-1tci6j0\"]//div["+gradeIndex+"]");
        click(selectedGrade);
    }

    public int getLanguagesNumber(){
        click(language);
        return driver.findElements(allLanguages).size();
    }
    public void selectLanguage(int languageIndex){
        By selectedLanguage =By.xpath("//*[@class=\" css-1tci6j0\"]//div["+languageIndex+"]");
        click(selectedLanguage);
    }
    public int getProficienciesNumber(){
        click(proficiency);
        return driver.findElements(allProficiencies).size();
    }
    public void selectProficiency(int proficiencyIndex){
        By selectedProficiency =By.xpath("//*[@class=\" css-1tci6j0\"]//div["+proficiencyIndex+"]");
        click(selectedProficiency);
        click(addLanguageButton);
    }
    public void insertProfessionalInfoPartTwo(String skillOne,String skillTwo) throws InterruptedException {
        actions.moveToElement(driver.findElement(skillsInput)).click().sendKeys(skillOne).build().perform();
        click(getStartedButton);
        //actions.moveByOffset(500, 500).click().perform();
        Thread.sleep(3000);
        actions.moveToElement(driver.findElement(skillsInput)).click().sendKeys(skillTwo).build().perform();
        click(getStartedButton);
        click(getStartedButton);
    }

}
