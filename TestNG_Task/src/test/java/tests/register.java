package tests;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.*;

public class register extends testBase {
    registerPage reg;
    careerInterestsPage career;
    generalInfoPage general;
    professionalInfoPage professional;
    searchPage search;

    @Test(priority = 1)
    public void testRegisterPage() throws InterruptedException {
        reg =new registerPage(driver);
        fake =new Faker();
        reg.goToRegisterPage();
        reg.fillFormWithValidData(fake.name().firstName(),fake.name().lastName(),fake.internet().emailAddress(),fake.internet().password(),fake.job().field());
    }
    @Test(priority = 2)
    public void testCareerInterestsPage() throws InterruptedException {
        testRegisterPage();
        career =new careerInterestsPage(driver);
        soft =new SoftAssert();
        fake =new Faker();
        soft.assertTrue(driver.findElement(career.title).getText().toLowerCase().contains("career interests"));
        career.insertCareerInterestsData(String.valueOf(fake.number().numberBetween(8000,10000)));
        soft.assertAll();
    }
    @Test (priority = 3)
    public void testGeneralInfoPage() throws InterruptedException {
        testCareerInterestsPage();
        general =new generalInfoPage(driver);
        fake =new Faker();
        soft =new SoftAssert();
        soft.assertTrue(driver.findElement(general.title).getText().toLowerCase().contains("general info"));
        general.insertGeneralInfo("01"+fake.number().digits(9));
        soft.assertAll();
    }
    @Test (priority = 4)
    public void testProfessionalInfo() throws InterruptedException {
        testGeneralInfoPage();
        professional =new professionalInfoPage(driver);
        fake =new Faker();
        soft =new SoftAssert();
        soft.assertTrue(driver.findElement(professional.title).getText().toLowerCase().contains("professional info"));
        professional.insertProfessionalInfo(fake.programmingLanguage().name()
                ,fake.university().name(),fake.programmingLanguage().name(),fake.programmingLanguage().name());
        soft.assertAll();
    }
    @Test (priority = 5)
    public void testSearchForJobTitle() throws InterruptedException {
        testProfessionalInfo();
        search = new searchPage(driver);
        search.SearchForJobTitle("Software Engineer");

        for (int i = 0; i < search.getAllJobsNames().size() ; i++) {
            String jopName = search.getJopName(i);
            System.out.println(jopName);
            soft.assertTrue(jopName.toLowerCase().contains("software"),
                    "jop name does not relevant to 'software engineer': " + jopName);
        }
        soft.assertTrue(driver.findElement(search.numberOfSearchResults).isDisplayed());
        soft.assertAll();
    }
}
