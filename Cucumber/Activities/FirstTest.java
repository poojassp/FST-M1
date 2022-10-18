package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FirstTest {
    WebDriver driver;
    @Given("^user is on the TS homepage$")
    public void openTSHomepage() {
        //driver = new FirefoxDriver();
        driver.get("https://www.training-support.net");
    }

    @When("^user click on the abous us link$")
    public void clickAboutUsLink() {
        driver.findElement(By.linkText("About us")).click();
    }
    @Then("^user is redirected to about us page$")
    public void redirectToAboutUs(){
        String pageTitle = driver.getTitle();
        assertEquals(pageTitle, "About Training Support");

    }

}
