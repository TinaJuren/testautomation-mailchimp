package signup;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.DriveCreator;
import pages.FormPage;

import java.util.Random;

import static org.junit.Assert.assertEquals;
import static pages.FormPage.*;

public class MyStepdefs {

    private WebDriver driver;

    @Given("I have started {string} browser")
    public void iHaveStartedBrowser(String browser) {
            DriveCreator creator = new DriveCreator();
            driver = creator.createBrowser(browser);
        }

    @And("I have entered an email in the Email field {string}")
    public void iHaveEnteredAnEmailInTheEmailField(String email) {
        driver.get("https://login.mailchimp.com/signup/");
        sendKeys(driver, By.id("email"), email);
    }

    @And("I have entered a username in the Username field {string}")
    public void iHaveEnteredAUsernameInTheUsernameField(String username) {
        if (username.equals("tina")) {
            sendKeys(driver, By.id("new_username"), username);
        } else {
            sendKeys(driver, By.id("new_username"), (username + ((new Random().nextInt(1000)) + 1)));
        }
    }

    @And("I have entered a password in the Password filed {string}")
    public void iHaveEnteredAPasswordInThePasswordFiled(String password) {
        sendKeys(driver, By.id("new_password"), password);
    }

    @When("I click the Sign Up button")
    public void iClickTheSignUpButton() {
        driver.getTitle();
        //FormPage formPage = new FormPage();
        scroll(driver);
        click(driver, By.id("create-account"));
    }

    @Then("I get a confirmation- or an error message depending on the validity of the user information {string} {string}")
    public void iGetAConfirmationOrAnErrorMessageDependingOnTheValidityOfTheUserInformation(String username, String email) {

        FormPage formPage = new FormPage();

        if (username.equals("tina")) {
            String expected = "Another user with this username already exists. Maybe it's your evil twin. Spooky.";
            String actual = formPage.getText(driver, By.cssSelector("div.field-wrapper span"));
            assertEquals(expected, actual);
        } else if (username.length() > 100) {
            String expected = "Enter a value less than 100 characters long";
            String actual = formPage.getText(driver, By.cssSelector(".login-field div:nth-child(1) span"));
            assertEquals(expected, actual);
        } else if (email.equals("")) {
            String expected = "Please enter a value";
            String actual = formPage.getText(driver, By.cssSelector("div.field-wrapper span"));
            assertEquals(expected, actual);
        } else {
            String expected = "Success | Mailchimp";
            String actual = driver.getTitle();
            assertEquals(expected, actual);
        }
        driver.quit();
    }

}
