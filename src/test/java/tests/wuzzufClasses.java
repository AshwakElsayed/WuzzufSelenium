package tests;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.*;

import java.util.ArrayList;

public class wuzzufClasses extends testBase {
    registerPage reg;
    careerInterestsPage career;
    generalInfoPage general;
    professionalInfoPage professional;
    searchPage search;

    @Test(priority = 1)
    public void testRegisterPage() throws InterruptedException {
        reportTest =report.createTest("Register Page");
        reg =new registerPage(driver);
        fake =new Faker();
        soft =new SoftAssert();
        soft.assertEquals(driver.getCurrentUrl(),"https://wuzzuf.net/jobs/egypt","register url not correct");
        reportTest.pass("You are landed in home page");
        soft.assertTrue(driver.findElement(reg.GetStartedButton).isEnabled());
        reportTest.pass("Get started button is enabled");
        reg.goToRegisterPage();
        soft.assertEquals(driver.getCurrentUrl(),"https://wuzzuf.net/register");
        reportTest.pass("You are landed in registration page");
        soft.assertTrue(driver.findElement(reg.signUpWithGoogle).isEnabled());
        reportTest.pass("Sign up with google is enabled");
        soft.assertTrue(driver.findElement(reg.wuzzufLogo).isDisplayed());
        reportTest.pass("Wuzzuf logo is displayed");
        soft.assertTrue(driver.findElement(reg.createAccountButton).isEnabled());
        reportTest.pass("Create Account Button is Enabled");
        reg.fillFormWithValidData(fake.name().firstName(),fake.name().lastName(),fake.internet().emailAddress(),fake.internet().password(),fake.job().field());

        soft.assertAll();
    }
    @Test(priority = 2)
    public void testCareerInterestsPage() throws InterruptedException {
        testRegisterPage();
        reportTest =report.createTest("Career interests page");
        career =new careerInterestsPage(driver);
        soft =new SoftAssert();
        fake =new Faker();

        soft.assertEquals(driver.getCurrentUrl(),"https://wuzzuf.net/setup?ref=signup-successful&sut=reg&login=1","career url not correct");
        reportTest.pass("You are landed in career interests page");
        soft.assertTrue(driver.findElement(career.title).isDisplayed());
        reportTest.pass("Career interests page has a title “Career Interests”.");
        soft.assertTrue(driver.findElement(career.level).isEnabled());
        reportTest.pass("Career level button is enabled");
        soft.assertTrue(driver.findElement(career.typeOfJob).isEnabled());
        reportTest.pass("Type of job button is enabled");
        soft.assertTrue(driver.findElement(career.workplace).isEnabled());
        reportTest.pass("Workplace settings button is enabled");

        career.insertCareerInterestsData(String.valueOf(fake.number().numberBetween(8000,10001)));
        soft.assertAll();
    }
    @Test (priority = 3)
    public void testGeneralInfoPage() throws InterruptedException {
        testCareerInterestsPage();
        reportTest =report.createTest("General info page");
        general =new generalInfoPage(driver);
        fake =new Faker();
        soft =new SoftAssert();

        soft.assertEquals(driver.getCurrentUrl(),"https://wuzzuf.net/setup/career-interests?sut=reg&login=1","general url not correct");
        reportTest.pass("You are landed in general info page");
        soft.assertTrue(driver.findElement(general.generalTitle).isDisplayed(),"general tilte incorrect");
        reportTest.pass("General info page has a title “General Info”.");
        general.selectDay(fake.number().numberBetween(1,general.getDaysNumber()+1));
        general.selectMonth(fake.number().numberBetween(1,general.getMonthsNumber()+1));
        general.selectYear(fake.number().numberBetween(1,general.getYearsNumber()+1));
        general.selectRandomGender(fake.number().numberBetween(1,3));
        general.selectRandomNationality(fake.number().numberBetween(1,general.getNationalityNumber()+1));
        general.selectRandomCity(fake.number().numberBetween(1,general.getCitiesNumber()+1));
        general.selectRandomArea(fake.number().numberBetween(1,general.getAreasNumber()+1));
        general.insertMobileNumber("01"+fake.number().digits(9));
        soft.assertAll();
    }
    @Test (priority = 4)
    public void testProfessionalInfo() throws InterruptedException {
        testGeneralInfoPage();
        reportTest =report.createTest("Professional info page");
        professional =new professionalInfoPage(driver);
        fake =new Faker();
        soft =new SoftAssert();

        soft.assertEquals(driver.getCurrentUrl(),"https://wuzzuf.net/setup/general-info","professional url not correct");
        reportTest.pass("You are landed in professional info page");
        soft.assertTrue(driver.findElement(professional.professionalTitle).isDisplayed());
        reportTest.pass("Professional info page has a title “Professional Info”.");
        System.out.println(driver.findElement(professional.professionalTitle).getText().toLowerCase());
        professional.insertProfessionalInfoPartOne(fake.programmingLanguage().name(),fake.university().name());
        professional.selectDegree(fake.number().numberBetween(1,professional.getDegreesNumber()+1));
        professional.selectGrade(fake.number().numberBetween(1,professional.getGradesNumber()+1));
        professional.selectLanguage(fake.number().numberBetween(1,professional.getLanguagesNumber()+1));
        professional.selectProficiency(fake.number().numberBetween(1,professional.getProficienciesNumber()+1));
        soft.assertTrue(driver.findElement(professional.addLanguageButton).isEnabled());
        reportTest.pass("Add language button is enabled");
        professional.insertProfessionalInfoPartTwo(fake.programmingLanguage().name(),fake.programmingLanguage().name());
        soft.assertAll();
    }
    @Test (priority = 5)
    public void testSearchForJobTitle() throws InterruptedException {
        testProfessionalInfo();
        search = new searchPage(driver);
        reportTest =report.createTest("search for job page");
        soft.assertEquals(driver.getCurrentUrl(),"https://wuzzuf.net/setup/pro-info","search url not correct");
        reportTest.pass("You are landed in search for jop page");

        Thread.sleep(2000);
        search.SearchForJobTitle("Software Engineer");
        Thread.sleep(2000);
        for (int i = 0; i < search.getAllJobsNames().size() ; i++) {
            String jopName = search.getJopName(i).toLowerCase();
            System.out.println(jopName);
            boolean containsKeywords = jopName.contains("software")||
                   jopName.contains("quality control") ||
                   jopName.contains("engineer") ||
                   jopName.contains("developer");


            soft.assertTrue(containsKeywords);
            reportTest.pass("jop name relevant to 'software engineer' : "+ jopName);


        }
        soft.assertTrue(driver.findElement(search.numberOfSearchResults).isDisplayed());
        reportTest.pass("number of search results is displayed");
        Thread.sleep(2000);
        search.ApplyForJop();
        ArrayList<String> tabs=new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        search.saveJop();
        driver.switchTo().window(tabs.get(0));
        search.goToProfileDetails();
        soft.assertAll();
    }
}
